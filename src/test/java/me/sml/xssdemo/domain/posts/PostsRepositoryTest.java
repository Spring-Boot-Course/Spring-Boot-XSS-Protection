package me.sml.xssdemo.domain.posts;

import org.apache.tomcat.jni.Local;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanUp(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){

        //given
        postsRepository.save(Posts.builder()
            .author("sml")
            .content("content")
            .title("title")
            .build());

        //when
        List<Posts> posts = postsRepository.findAll();
        Posts post = posts.get(0);

        //then
        assertThat(post.getAuthor(), is("sml"));
        assertThat(post.getContent(), is("content"));
        assertThat(post.getTitle(), is("title"));
    }

    @Test
    public void BaseTimeEntity_확인(){
        //given
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(
                Posts.builder()
                    .title("title")
                    .content("content")
                    .author("sml")
                .build());

        //when
        Posts post = postsRepository.findAll().get(0);

        //then
        assertTrue(post.getCreatedDate().isAfter(now));
        assertTrue(post.getModifiedDate().isAfter(now));
    }
}