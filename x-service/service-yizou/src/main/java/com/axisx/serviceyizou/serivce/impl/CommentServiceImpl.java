package com.axisx.serviceyizou.serivce.impl;

import com.axisx.apiyizou.dto.ListCommentDTO;
import com.axisx.apiyizou.dto.SaveCommentDTO;
import com.axisx.apiyizou.entity.YizouComment;
import com.axisx.apiyizou.vo.CommentVO;
import com.axisx.serviceyizou.dao.CommentMapper;
import com.axisx.serviceyizou.feign.UserRemoteService;
import com.axisx.serviceyizou.serivce.CommentService;
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
public class CommentServiceImpl extends ServiceImpl<CommentMapper, YizouComment> implements CommentService {

    private BeanCopier beanCopier;
    private YizouComment yizouComment;
    @Autowired
    private UserRemoteService userRemoteService;

    @Override
    public IPage<CommentVO> listComment(ListCommentDTO listCommentDTO) {
        beanCopier = BeanCopier.create(ListCommentDTO.class, YizouComment.class,false);
        yizouComment = new YizouComment();
        beanCopier.copy(listCommentDTO,yizouComment,null);
        IPage<CommentVO> page = this.baseMapper.listComment(new Page<>(listCommentDTO.getPageNo(),listCommentDTO.getPageSize()),yizouComment);
        page.getRecords().stream().forEach(data->{
            //关联账号
            data.setFromUser(userRemoteService.getUser(data.getFromUserId()).getData());
            if(data.getToUserId()!=null){
                data.setToUser(userRemoteService.getUser(data.getToUserId()).getData());
            }
        });
        return page;
    }

    @Override
    public Boolean removeComment(Integer id) {
        List<Integer> ids = this.list(
                Wrappers.<YizouComment>lambdaQuery()
                        .eq(YizouComment::getPid,id))
                .stream()
                .map(YizouComment::getId)
                .collect(Collectors.toList()
                );
        this.removeByIds(ids);
        this.removeById(id);
        return true;
    }

    @Override
    public Boolean saveComment(SaveCommentDTO saveCommentDTO) {
        beanCopier = BeanCopier.create(SaveCommentDTO.class, YizouComment.class,false);
        yizouComment = new YizouComment();
        beanCopier.copy(saveCommentDTO,yizouComment,null);
        return this.save(yizouComment);
    }

}
