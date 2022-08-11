package com.itheima.aspectj.xml;

import com.itheima.jdk.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//测试类
public class TextXmlAspectj {
    public static void main(String[] args) {
        String xmlPath = "com/itheima/aspectj/xml/applicationContext.xml";
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext(xmlPath);
        //1 从spring 容器获得内容
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        //2 执行方法
        userDao.addUser();
    }
}
