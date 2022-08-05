package com.itheima.annotation;
/**
 * 使用注解不用实现setter方法
 */

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//相当于在xml配置文件中定义bean id class
@Service("userService")
public class UserServiceImpl implements UserService{
    // 相当于property
    @Resource(name = "userDao")
    private UserDao userDao;

    @Override
    public void save() {
        // 调用userDao 中的save方法
        this.userDao.save();
        System.out.println("userService...save...");
    }
}
