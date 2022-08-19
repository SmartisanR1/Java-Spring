package com.itheima.test;

import com.itheima.po.Orders;
import com.itheima.po.Person;
import com.itheima.po.User;
import com.itheima.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Mybatis关联查询映射测试类
 */
public class MyBatisAssociatedTest {
    /**
     * 嵌套查询
     */
    @Test
    public void findPersonByIdTest() {
        SqlSession sqlSession = MyBatisUtils.getSession();
        Person person = sqlSession.selectOne("com.itheima.mapper."
        + "PersonMapper.findPersonById", 1);
        System.out.println(person);
        sqlSession.close();
    }

    /**
     * 嵌套结果
     */
    @Test
    public void findPersonByIdTest2() {
        SqlSession sqlSession = MyBatisUtils.getSession();
        Person person = sqlSession.selectOne("com.itheima.mapper." +
                "PersonMapper.findPersonById2", 1);
        System.out.println(person);
        sqlSession.close();
    }

    /**
     * 一对多
     */
    @Test
    public void findUserTest() {
        SqlSession session = MyBatisUtils.getSession();
        User user = session.selectOne("com.itheima.mapper."
        + "UserMapper.findUserWithOrders", 1);
        System.out.println(user);
        session.close();
    }

    /**
     * 多对多
     */
    @Test
    public void findOrdersTest() {
        SqlSession session = MyBatisUtils.getSession();
        Orders orders = session.selectOne("com.itheima.mapper."
        + "OrdersMapper.findOrdersWithProduct2", 1);
        System.out.println(orders);
        session.close();
    }
}
