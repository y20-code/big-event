#大事件项目
##注册接口参数校验 
1. spring Validation  
  导入validation坐标
  在参数上添加@Pattern注解，指定校验规则
  在Controller类上添加@Validated注解
  在全局异常处理器中出来参数校验失败的异常
2. 登录认证
  令牌就是一字符串 
  承载业务数据，减少后续请求查询数据库的次数
  防篡改，保证信息的合法性和有效性 
3. JWT
   1. 简介
      全称：JSON Web Token（https://jwt.io/)
      定义类一种简洁、自包含的格式，用于通信双方以json数据格式安全的传输信息
      组成
        第一部分：Header(头)
        第二部分：Payload(有效载荷) ，不能存放私密信息
        第三部分：Signature(签名)
4. 登录认证_完成
    使用拦截器统一验证令牌
    登录和注册接口需要放行
5. ThreadLocal
    提供线程局部变量
    1. 用来存取数据：set()/get()
   2. 使用ThreadLocal存储的数据，线程安全
6. 实体类校验
    实体类的成员变量上添加注解
    @NotNull
    @NotEmpty
    @Email
    接口方法的实体参数上添加@Validated注解
7. 如何父哦校验项分组
    通过groups属性指定
4完善删除接口