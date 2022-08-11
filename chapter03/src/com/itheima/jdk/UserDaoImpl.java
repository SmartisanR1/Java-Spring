package com.itheima.jdk;

public class UserDaoImpl implements UserDao{
    @Override
    public void addUser() {
        // 模拟异常
        // int i = 10/0;
        System.out.println("添加用户");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除用户");
    }
}
