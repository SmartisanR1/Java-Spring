package com.itheima.test;

import com.itheima.po.Customer;
import com.itheima.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyBatisTest {
    /**
     * 根据客户姓名和职业组合查询客户信息列表
     */
    @Test
    public void findCustomerByNameAndJobsTest() {
        SqlSession sqlSession = MyBatisUtils.getSession();
        Customer customer = new Customer();
//        customer.setUsername("jack");
//        customer.setJobs("teacher");
        List<Customer> customers = sqlSession.selectList("com.itheima.mapper"
        + ".CustomerMapper.findCustomerByNameAndJobs", customer);
        for (Customer customer2 : customers) {
            System.out.println(customer2);
        }
        sqlSession.close();
    }
}
