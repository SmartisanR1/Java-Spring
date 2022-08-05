package com.itheima.annotation1;

public class UserController1 {
    private UserService1 userService;
    public void setUserService(UserService1 userService) {
        this.userService = userService;
    }
    public void save() {
        this.userService.save();
        System.out.println("userController...save...");
    }
}
