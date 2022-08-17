package com.itheima.test;

import com.itheima.po.Customer;
import com.itheima.po.User;
import com.itheima.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * 入门程序测试
 */
public class MyBatisTest {
    /**
     * 根据客户编号查询客户信息
     */
    @Test
    public void findCustomerByIdTest() {
        SqlSession sqlSession = MyBatisUtils.getSession();
        //4 SqlSession执行映射文件中定义的SQL，并返回映射结果
        Customer customer = sqlSession.selectOne("com.itheima.mapper" +
                ".CustomerMapper.findCustomerById", 1);
        System.out.println(customer.toString());
        //5 关闭SqlSession
        sqlSession.close();
    }

    /**
     * 根据用户名来模糊查询用户信息列表
     */
    @Test
    public void findCustomerByNameTest() {
        //3 通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = MyBatisUtils.getSession();
        //4 SqlSession执行映射文件中定义的SQL，并返回映射结果
        List<Customer> customers = sqlSession.selectList("com.itheima.mapper" +
                ".CustomerMapper.findCustomerByName", "j");
        for (Customer customer: customers) {
            System.out.println(customer);
        }
        //5 关闭SqlSession
        sqlSession.close();
    }

    /**
     * 添加客户
     */
    @Test
    public void addCustomerTest() {
        //3 通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = MyBatisUtils.getSession();
        //4 SqlSession执行添加操作
        //4.1 创建Customer对象，并向对象中添加数据
        Customer customer = new Customer();
        customer.setUsername("rose");
        customer.setJobs("student");
        customer.setPhone("13333533092");
        //4.2 执行插入方法，返回影响的行数
        int rows = sqlSession.insert("com.itheima.mapper"
        + ".CustomerMapper.addCustomer", customer);
        //4.3 通过返回结果判断插入是否执行成功
        if (rows > 0) {
            System.out.println("您成功插入了" + rows + "条数据！");
        } else {
            System.out.println("执行插入操作失败！！！");
        }
        // 4.4 提交事务
        sqlSession.commit();
        //5 关闭SqlSession
        sqlSession.close();
    }

    /**
     * 更新客户
     */
    @Test
    public void updateCustomerTest() {
        //3 通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = MyBatisUtils.getSession();
        //4 SqlSession执行更新操作
        //4.1 创建Customer对象，并向对象中添加数据
        Customer customer = new Customer();
        customer.setId(6);
        customer.setUsername("rose");
        customer.setJobs("programmer");
        customer.setPhone("13311111111");
        //4.2 执行更新
        int rows = sqlSession.update("com.itheima.mapper"
                + ".CustomerMapper.updateCustomer", customer);
        //4.3 判断更新是否成功
        if (rows > 0) {
            System.out.println("您成功修改了" + rows + "条数据！");
        } else {
            System.out.println("执行修改操作失败！！！");
        }
        // 4.4 提交事务
        sqlSession.commit();
        //5 关闭SqlSession
        sqlSession.close();
    }

    /**
     * 删除客户
     */
    @Test
    public void deleteCustomerTest() {
        SqlSession sqlSession = MyBatisUtils.getSession();
        // SqlSession执行更新操作
        int rows = sqlSession.delete("com.itheima.mapper"
                + ".CustomerMapper.deleteCustomer", 6);
        if (rows > 0) {
            System.out.println("您成功删除了" + rows + "条数据！");
        } else {
            System.out.println("执行删除操作失败！！！");
        }
        // 提交事务
        sqlSession.commit();
        // 关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void findAllUserTest() {
        //获取SqlSession
        SqlSession sqlSession = MyBatisUtils.getSession();
        List<User> list =
                sqlSession.selectList("com.itheima.mapper.UserMapper.findAllUser");
        for (User user : list) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
