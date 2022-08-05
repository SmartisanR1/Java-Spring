package com.itheima.annotation1;
/**
 * 不使用注解 自动装配
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationAssembleTest1 {
    public static void main(String[] args) {
        //定义配置文件
        String xmlPath = "com/itheima/annotation1/beans7.xml";
        //加载配置文件
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext(xmlPath);
        //获取UserController实例
        UserController1 userController =
                (UserController1) applicationContext.getBean("userController");
        //调用UserController中的save()方法
        userController.save();
    }
}
