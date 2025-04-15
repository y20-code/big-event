package com.yls.controller;

import com.yls.pojo.Article;
import com.yls.pojo.Result;
import com.yls.service.ArticleService;
import com.yls.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public Result add(@RequestBody Article article){
        articleService.add(article);
        return Result.success();
    }
}
