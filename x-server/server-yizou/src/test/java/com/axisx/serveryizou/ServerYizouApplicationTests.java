package com.axisx.serveryizou;

import com.axisx.apicommon.dto.ResponseDTO;
import com.axisx.apiyizou.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.time.LocalDateTime;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
class ServerYizouApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setUp() {
        log.info("{}","测试初始化");
    }

    @Test
    void savePostTest() {
        log.info("{}","添加测试");
        SavePostDTO request = new SavePostDTO();
        for(int i=0;i<10;i++){
            request.setCreatorId(1);
            request.setLocation("当前位置"+Math.random());
            request.setCreateTime(LocalDateTime.now());
            request.setContent("文字:"+i);
            ResponseDTO response = this.restTemplate.postForObject("/post/save",request, ResponseDTO.class);
            log.info("{}",response);
        }
    }


    @Test
    void listPostTest() {
        log.info("{}","查询列表");
        ListPostDTO request = new ListPostDTO();
        request.setPageNo(1);
        request.setPageSize(20);
        ResponseDTO response = this.restTemplate.postForObject("/post/list",request, ResponseDTO.class);
        log.info("{}","查询结果");
        log.info("{}",response);
    }

    @Test
    void removePostTest() {
        log.info("{}","删除测试");
        ResponseDTO response = this.restTemplate.getForObject("/post/remove/1", ResponseDTO.class);
        log.info("{}",response);
    }

    @Test
    void saveOrRemoveLikeTest() {
        log.info("{}","喜欢开关");
        SavePostLikeDTO request = new SavePostLikeDTO();
        request.setUserId(1);
        request.setPostId(2);
        ResponseDTO response = this.restTemplate.postForObject("/post/like",request, ResponseDTO.class);
        log.info("{}",response);
    }

    @Test
    void saveCommentTest() {
        log.info("{}","添加测试");
        SaveCommentDTO request = new SaveCommentDTO();
        for(int i=0;i<10;i++){
            request.setFromUserId(1);
            request.setToUserId(1);
            request.setCreateTime(LocalDateTime.now());
            request.setContent("评论"+Math.random());
            request.setPostId(i);
            ResponseDTO response = this.restTemplate.postForObject("/comment/save",request, ResponseDTO.class);
            log.info("{}",response);
        }
    }


    @Test
    void listCommentTest() {
        log.info("{}","查询列表");
        ListCommentDTO request = new ListCommentDTO();
        request.setPageNo(1);
        request.setPageSize(20);
        ResponseDTO response = this.restTemplate.postForObject("/comment/list",request, ResponseDTO.class);
        log.info("{}","查询结果");
        log.info("{}",response);
    }

    @Test
    void removeCommentTest() {
        log.info("{}","删除测试");
        ResponseDTO response = this.restTemplate.getForObject("/comment/remove/1", ResponseDTO.class);
        log.info("{}",response);
    }

}
