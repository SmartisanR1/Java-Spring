package com.itheima.instance.static_factory;
/**
 * 使用静态工厂方法实例化
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InstanceTest2 {
    public static void main(String[] args) {
        //定义配置文件路径
        String xmlPath = "com/itheima/instance/static_factory/beans2.xml";
        // ApplicationContext 在加载配置文件时，对Bean进行实例化
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        System.out.println(applicationContext.getBean("bean2"));
    }
}
