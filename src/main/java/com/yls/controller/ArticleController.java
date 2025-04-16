package com.yls.controller;

import com.yls.pojo.Article;
import com.yls.pojo.PageBean;
import com.yls.pojo.Result;
import com.yls.service.ArticleService;
import com.yls.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public Result add(@RequestBody @Validated Article article){
        articleService.add(article);
        return Result.success();
    }

    @GetMapping
    public Result<PageBean<Article>> list(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) String state
    ){
        PageBean<Article> pb = articleService.list(pageNum,pageSize,categoryId,state);

        return Result.success(pb);

    }

    @DeleteMapping
    public Result delete(@RequestParam @Validated Integer id){
        articleService.delete(id);
        return Result.success();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam @Validated Integer id){
        List<Article> list = articleService.detail(id);
        return Result.success(list);
    }

    @PutMapping
    public Result update(@RequestBody @Validated Article article){
        articleService.update(article);
        return Result.success();
    }
}
