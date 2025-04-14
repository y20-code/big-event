#大事件项目
##注册接口参数校验 
1. spring Validation  
  导入validation坐标
  在参数上添加@Pattern注解，指定校验规则
  在Controller类上添加@Validated注解
  在全局异常处理器中出来参数校验失败的异常
