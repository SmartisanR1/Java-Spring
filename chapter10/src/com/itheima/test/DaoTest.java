package com.itheima.test;

import com.itheima.dao.CustomerDao;
import com.itheima.mapper.CustomerMapper;
import com.itheima.po.Customer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * MyBatis于Spring整合
 * DAO测试类
 */
public class DaoTest {
    @Test
    public void findCustomerByIdDaoTest() {
        ApplicationContext act =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        //根容器中的Bean的id来获取指定的Bean
        //CustomerDao customerDao = (CustomerDao) act.getBean("customerDao");
        //另一种方式
        CustomerDao customerDao = act.getBean(CustomerDao.class);
        Customer customer = customerDao.findCustomerById(1);
        System.out.println(customer);
    }

    @Test
    public void findCustomerByIdMapperTest() {
        ApplicationContext act =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerMapper customerMapper = act.getBean(CustomerMapper.class);
        Customer customer = customerMapper.findCustomerById(1);
        System.out.println(customer);
    }
}
