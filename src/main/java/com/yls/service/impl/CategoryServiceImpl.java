package com.yls.service.impl;

import com.fasterxml.jackson.core.ObjectCodec;
import com.yls.mapper.ArticleMapper;
import com.yls.mapper.CategoryMapper;
import com.yls.pojo.Category;
import com.yls.service.CategoryService;
import com.yls.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public void add(Category category) {
        //补充属性值
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());

        Map<String,Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        category.setCreateUser(id);
        categoryMapper.add(category);

    }

    @Override
    public List<Category> list() {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        return categoryMapper.list(id);
    }

    @Override
    public Category findById(Integer id) {

        Category c = categoryMapper.finById(id);
        return c;
    }

    @Override
    public void update(Category category) {
        category.setUpdateTime(LocalDateTime.now());

        categoryMapper.update(category);
    }

    @Override
    public void delete(Integer id) {
        //要先删除把所对应的文章删除
        articleMapper.deleteByCateoryId(id);
        categoryMapper.delete(id);
    }

}
