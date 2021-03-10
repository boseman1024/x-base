package com.axisx.serviceyizou.serivce.impl;

import com.axisx.apiyizou.dto.ListPostDTO;
import com.axisx.apiyizou.dto.SavePostDTO;
import com.axisx.apiyizou.entity.YizouFollow;
import com.axisx.apiyizou.entity.YizouPost;
import com.axisx.apiyizou.entity.YizouPostFile;
import com.axisx.apiyizou.entity.YizouPostLike;
import com.axisx.apiyizou.vo.PostVO;
import com.axisx.serviceyizou.dao.FollowMapper;
import com.axisx.serviceyizou.dao.PostFileMapper;
import com.axisx.serviceyizou.dao.PostLikeMapper;
import com.axisx.serviceyizou.dao.PostMapper;
import com.axisx.serviceyizou.feign.UserRemoteService;
import com.axisx.serviceyizou.serivce.FileService;
import com.axisx.serviceyizou.serivce.PostService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, YizouPost> implements PostService {

    private BeanCopier beanCopier;
    private YizouPost yizouPost;
    @Autowired
    private FollowMapper followMapper;
    @Autowired
    private PostLikeMapper postLikeMapper;
    @Autowired
    private PostFileMapper postFileMapper;
    @Autowired
    private FileService fileService;
    @Autowired
    private UserRemoteService userRemoteService;

    @Override
    public IPage<PostVO> listPost(ListPostDTO listPostDTO) {
        beanCopier = BeanCopier.create(ListPostDTO.class,YizouPost.class,false);
        yizouPost = new YizouPost();
        beanCopier.copy(listPostDTO,yizouPost,null);
        IPage<PostVO> page = this.baseMapper.listPoster(new Page<>(listPostDTO.getPageNo(),listPostDTO.getPageSize()),yizouPost,null);
        page.getRecords().stream().forEach(data->{
            //关联文件
            data.setFiles(fileService.listByPosterId(data.getId()));
            //关联账号
            data.setCreator(userRemoteService.getUser(data.getCreatorId()).getData());
        });
        return page;
    }

    @Override
    public IPage<PostVO> listFollowPost(ListPostDTO listPosterDTO) {
        List<Integer> toUserIdList = followMapper.selectList(
                Wrappers.<YizouFollow>lambdaQuery()
                        .eq(YizouFollow::getFromUserId,listPosterDTO.getFromUserId())
                )
                .stream()
                .map(YizouFollow::getToUserId)
                .collect(Collectors.toList());
        if(toUserIdList.size() == 0){
            return new Page<>(listPosterDTO.getPageNo(),listPosterDTO.getPageSize(),0);
        }
        IPage<PostVO> page = this.baseMapper.listPoster(new Page<>(listPosterDTO.getPageNo(),listPosterDTO.getPageSize()),new YizouPost(),toUserIdList);
        page.getRecords().stream().forEach(data->{
            //关联文件
            data.setFiles(fileService.listByPosterId(data.getId()));
            //关联账号
            data.setCreator(userRemoteService.getUser(data.getCreatorId()).getData());
        });
        return page;
    }

    @Override
    public Boolean savePost(SavePostDTO savePostDTO) {
        beanCopier = BeanCopier.create(SavePostDTO.class,YizouPost.class,false);
        yizouPost = new YizouPost();
        beanCopier.copy(savePostDTO,yizouPost,null);
        Boolean result = this.save(yizouPost);
        if(result&&savePostDTO.getFiles()!=null){
            savePostDTO.getFiles().stream().forEach(file->{
                Integer fileId = fileService.save(file);
                YizouPostFile yizouPostFile = new YizouPostFile();
                yizouPostFile.setFileId(fileId);
                yizouPostFile.setPostId(yizouPost.getId());
                postFileMapper.insert(yizouPostFile);
            });
        }
        return result;
    }

    @Override
    public Boolean removePost(Integer id) {
        fileService.removerByPosterId(id);
        return this.removeById(id);
    }

    @Override
    public Boolean saveOrRemoveLike(Integer postId, Integer userId) {
        YizouPostLike yizouPostLike = postLikeMapper.selectOne(Wrappers.<YizouPostLike>lambdaQuery().eq(YizouPostLike::getPostId,postId).eq(YizouPostLike::getUserId,userId));
        if(yizouPostLike==null){
            yizouPostLike = new YizouPostLike();
            yizouPostLike.setPostId(postId);
            yizouPostLike.setUserId(userId);
            postLikeMapper.insert(yizouPostLike);
            return true;
        }
        postLikeMapper.deleteById(yizouPostLike.getId());
        return false;
    }
}
