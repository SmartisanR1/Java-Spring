package com.itheima.annotation;

import org.springframework.stereotype.Controller;
/**
 * 相当于在配置文件 中编写<bean id="userController" class="com.itheima.annotation.UserController"/>;
 * 然后使用 了 @Resource 注解标注在 userService 属性上，这相当于在配置文件中编写 <property
 * name="userService" ref="userService" />
 */
import javax.annotation.Resource;
@Controller("userController")
public class UserController {
    @Resource(name = "userService")
    private UserService userService;
    public void save() {
        this.userService.save();
        System.out.println("userController...save...");
    }
}
