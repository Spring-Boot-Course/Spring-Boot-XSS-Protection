package me.sml.xssdemo.controller;

import lombok.RequiredArgsConstructor;
import me.sml.xssdemo.service.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class WebController {

    private final PostsService postsService;

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        return "main";
    }
}
