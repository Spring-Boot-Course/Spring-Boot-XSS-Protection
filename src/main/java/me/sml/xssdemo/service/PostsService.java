package me.sml.xssdemo.service;

import lombok.AllArgsConstructor;
import me.sml.xssdemo.domain.posts.PostsRepository;
import me.sml.xssdemo.dto.posts.PostsMainResponseDto;
import me.sml.xssdemo.dto.posts.PostsSaveRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto){
        return postsRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<PostsMainResponseDto> findAllDesc(){
        return postsRepository.findAllDesc()
                .map(PostsMainResponseDto::new)
                .collect(Collectors.toList());

    }
}
