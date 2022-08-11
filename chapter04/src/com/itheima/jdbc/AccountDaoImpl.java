package com.itheima.jdbc;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class AccountDaoImpl implements AccountDao{
    //声明JdbcTemplate实现及其setter方法
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addAccount(Account account) {
        //定义SQL
        String sql = "insert into account(username,balance) value(?,?)";
        //定义数组来存储SQL语句中的参数
        Object[] obj = new Object[] {
                account.getUsername(),
                account.getBalance()
        };

        //执行添加操作，返回的是受SQL语句影响的记录条数
        int num = this.jdbcTemplate.update(sql, obj);
        return num;
    }

    @Override
    public int updateAccount(Account account) {
        String sql = "update account set username=?,balance=? where id = ?";
        Object[] params = new Object[] {
                account.getUsername(),
                account.getBalance(),
                account.getId()
        };
        //执行更新操作
        int num = this.jdbcTemplate.update(sql, params);
        return num;
    }

    @Override
    public int deleteAccount(int id) {
        String sql = "delete from account where id = ?";
        int num = this.jdbcTemplate.update(sql, id);
        return num;
    }

    @Override
    public Account findAccountById(int id) {
        String sql = "select * from account where id = ?";
        //创建一个新的BeanPropertyRowMapper对象
        //可以自动地将数据表中的数据映射到用户自定义的类中(前提是用户自定义类中的字段要与数据表中
        //的字段相对应)
        RowMapper<Account> rowMapper =
                new BeanPropertyRowMapper<>(Account.class);
        //将id绑定到SQL语句中，并通过RowMapper返回一个Object类型的单行记录
        return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    @Override
    public List<Account> findAllAccount() {
        String sql = "select * from account";
        RowMapper<Account> rowMapper =
                new BeanPropertyRowMapper<>(Account.class);
        //执行静态的SQL查询，并通过RowMapper返回结果
        return this.jdbcTemplate.query(sql, rowMapper);
    }
}
