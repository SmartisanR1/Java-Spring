package com.itheima.test;

import com.itheima.po.Customer;
import com.itheima.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MyBatisTest {
    /**
     * 根据客户姓名和职业组合查询客户信息列表
     */
    @Test
    public void findCustomerByNameAndJobsTest() {
        SqlSession sqlSession = MyBatisUtils.getSession();
        Customer customer = new Customer();
        customer.setUsername("jack");
        customer.setJobs("teacher");
        List<Customer> customers = sqlSession.selectList("com.itheima.mapper"
        + ".CustomerMapper.findCustomerByNameAndJobs", customer);
        for (Customer customer2 : customers) {
            System.out.println(customer2);
        }
        sqlSession.close();
    }

    @Test
    public void findCustomerByNameOrJobsTest() {
        SqlSession sqlSession = MyBatisUtils.getSession();
        Customer customer = new Customer();
        customer.setUsername("jack");
        customer.setJobs("teacher");
        List<Customer> customers = sqlSession.selectList("com.itheima.mapper"
                + ".CustomerMapper.findCustomerByNameOrJobs", customer);
        for (Customer customer2 : customers) {
            System.out.println(customer2);
        }
        sqlSession.close();
    }

    /**
     * 更新客户
     */
    @Test
    public void updateCustomerTest() {
        SqlSession sqlSession = MyBatisUtils.getSession();
        Customer customer = new Customer();
        customer.setId(2);
        customer.setPhone("13311111234");
        int rows = sqlSession.update("com.itheima.mapper"
        + ".CustomerMapper.updateCustomer", customer);
        if (rows > 0) {
            System.out.println("您成功修改了" + rows + "条数据！");
        } else {
            System.out.println("执行修改操作失败！！！");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 根据客户编号批量查询客户信息
     */
    @Test
    public void findCustomerByIdsTest() {
        SqlSession sqlSession = MyBatisUtils.getSession();
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        List<Customer> customers = sqlSession.selectList("com.itheima.mapper"
        +".CustomerMapper.findCustomerByIds", ids);
        for (Customer customer : customers) {
            System.out.println(customer);
        }
        sqlSession.close();
    }

    /**
     * bind模糊查询
     */
    @Test
    public void findCustomerByNameTest() {
        SqlSession sqlSession = MyBatisUtils.getSession();
        Customer customer = new Customer();
        customer.setUsername("j");
        List<Customer> customers = sqlSession.selectList("com.itheima.mapper"
        + ".CustomerMapper.findCustomerByName", customer);
        for (Customer customer2 : customers) {
            System.out.println(customer2);
        }
        sqlSession.close();
    }
}
