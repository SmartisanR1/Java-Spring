package com.itheima.scope;
/**
 * 单例模式，Sprig容器默认就是singleton
 * prototype: 会为每个对该Bean的请求都创建一个新的实例
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    public static void main(String[] args) {
        // 定义配置文件路径
        String xmlPath = "com/itheima/scope/beans4.xml";
        // 加载配置文件
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext(xmlPath);
        //输出获得实例
        System.out.println(applicationContext.getBean("scope"));
        System.out.println(applicationContext.getBean("scope"));
    }
}
