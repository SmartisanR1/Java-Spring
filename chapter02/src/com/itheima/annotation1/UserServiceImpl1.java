package com.itheima.annotation1;
/**
 * 使用注解不用实现setter方法
 */

public class UserServiceImpl1 implements UserService1 {
    private UserDao1 userDao;

    public void setUserDao(UserDao1 userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        // 调用userDao 中的save方法
        this.userDao.save();
        System.out.println("userService...save...");
    }
}
