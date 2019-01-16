package me.sml.xssdemo.restcontroller;

import lombok.RequiredArgsConstructor;
import me.sml.xssdemo.dto.posts.PostsMainResponseDto;
import me.sml.xssdemo.dto.posts.PostsSaveRequestDto;
import me.sml.xssdemo.service.PostsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WebRestController {

    private final PostsService postsService;

    @PostMapping("/post")
    public void savePosts(@RequestBody PostsSaveRequestDto dto){
        postsService.save(dto);
    }

    @GetMapping("/post")
    public List<PostsMainResponseDto> getPosts(){
        List<PostsMainResponseDto> results = postsService.findAllDesc();
        return results;
    }
}
