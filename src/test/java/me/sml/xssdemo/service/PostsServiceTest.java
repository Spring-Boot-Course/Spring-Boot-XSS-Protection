package me.sml.xssdemo.service;

import me.sml.xssdemo.domain.posts.Posts;
import me.sml.xssdemo.domain.posts.PostsRepository;
import me.sml.xssdemo.dto.posts.PostsSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.Is.is;


@SpringBootTest
@RunWith(SpringRunner.class)
public class PostsServiceTest {

    @Autowired
    PostsService postsService;

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanUp(){
        postsRepository.deleteAll();
    }

    @Test
    public void DTO데이터가_posts테이블에_저장된다(){
        //given
        postsService.save(PostsSaveRequestDto.builder()
            .author("autho1r")
            .title("title")
            .content("con")
            .build()
        );

        //when
        List<Posts> posts = postsRepository.findAll();
        Posts post = posts.get(0);

        //then
        assertThat(post.getAuthor()).isEqualTo("author");
    }
}