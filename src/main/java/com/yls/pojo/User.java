package com.yls.pojo;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    @NotNull //值不能为null
    private Integer id;//主键ID
    private String username;//用户名
    @JsonIgnore //让springmvc把当前对象换成json字符串的时候，忽略password，最终的json字符串中就密钥password这个属性了
    private String password;//密码

    @NotEmpty//值不能为null,并且内容不能为空
    @Pattern(regexp = "^\\S{1,10}$")
    private String nickname;//昵称

    @NotEmpty
    @Email//满足邮箱格式  -->添加这些后还要在update里添加 @Valideated
    private String email;//邮箱
    private String userPic;//用户头像地址
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间
}
