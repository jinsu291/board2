package com.example.board2.app.home.controller;

import com.example.board2.app.article.entity.Article;
import com.example.board2.app.article.service.ArticleService;
import com.example.board2.app.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/")
@RequiredArgsConstructor
@Controller
public class HomeController {

    private final ArticleService articleService;
    private final UserService userService;

    @GetMapping("/")
    public String list(Model model, @RequestParam(value="page", defaultValue="0") int page) {
        Page<Article> paging = this.articleService.getList(page);
        model.addAttribute("paging", paging);
        return "article/list";
    }
}
