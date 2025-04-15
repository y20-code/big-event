package com.yls.mapper;

import com.yls.pojo.Category;
import com.yls.pojo.Result;
import org.apache.ibatis.annotations.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface CategoryMapper {

    //新增
    @Insert("insert into category(category_name,category_alias,create_user,create_time,update_time) " +
            "values (#{categoryName},#{categoryAlias},#{createUser},#{createTime},#{updateTime})")
    void add(Category category);

    //查询所有
    @Select("select * from category where create_user = #{userId}")
    List<Category> list(Integer id);

    //根据ID查询
    @Select("select * from category where id = #{id}")
    Category finById(Integer id);

    //更新
    @Update("update category set category_name=#{categoryName},category_alias=#{categoryAlias},update_time=#{updateTime} where id=#{id}")
    void update(Category category);

    @Delete("delete from category where id=${id}")
    void delete(Integer id);
}
