package com.itheima.dao.impl;

import com.itheima.dao.CustomerDao;
import com.itheima.po.Customer;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class CustomerDaoImpl extends SqlSessionDaoSupport implements CustomerDao {
    //通过id查询客户
    @Override
    public Customer findCustomerById(Integer id) {
        return this.getSqlSession().selectOne("com.itheima.po"
        + ".CustomerMapper.findCustomerById", id);
    }
}
