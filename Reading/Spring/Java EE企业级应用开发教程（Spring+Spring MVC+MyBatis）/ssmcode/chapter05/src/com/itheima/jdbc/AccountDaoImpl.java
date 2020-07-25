package com.itheima.jdbc;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class AccountDaoImpl implements AccountDao {
	// 声明JdbcTemplate属性及其setter方法
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// 添加账户
	public int addAccount(Account account) {
		// 定义SQL
		String sql = "insert into account(username,balance) value(?,?)";
		// 定义数组来存放SQL语句中的参数
		Object[] obj = new Object[] { account.getUsername(), account.getBalance() };
		// 执行添加操作，返回的是受SQL语句影响的记录条数
		int num = this.jdbcTemplate.update(sql, obj);
		return num;
	}

	// 更新账户
	public int updateAccount(Account account) {
		// 定义SQL
		String sql = "update account set username=?,balance=? where id = ?";
		// 定义数组来存放SQL语句中的参数
		Object[] params = new Object[] { account.getUsername(), account.getBalance(), account.getId() };
		// 执行添加操作，返回的是受SQL语句影响的记录条数
		int num = this.jdbcTemplate.update(sql, params);
		return num;
	}

	// 删除账户
	public int deleteAccount(int id) {
		// 定义SQL
		String sql = "delete  from account where id = ? ";
		// 执行添加操作，返回的是受SQL语句影响的记录条数
		int num = this.jdbcTemplate.update(sql, id);
		return num;
	}

	// 通过id查询账户数据信息
	public Account findAccountById(int id) {
		// 定义SQL语句
		String sql = "select * from account where id = ?";
		// 创建一个新的BeanPropertyRowMapper对象
		RowMapper<Account> rowMapper = new BeanPropertyRowMapper<Account>(Account.class);
		// 将id绑定到SQL语句中，并通过RowMapper返回一个Object类型的单行记录
		return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
	}

	// 查询所有账户信息
	public List<Account> findAllAccount() {
		// 定义SQL语句
		String sql = "select * from account";
		// 创建一个新的BeanPropertyRowMapper对象
		RowMapper<Account> rowMapper = new BeanPropertyRowMapper<Account>(Account.class);
		// 执行静态的SQL查询，并通过RowMapper返回结果
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	/**
	 *  转账
	 *  inUser：收款人
	 *  outUser：汇款人
	 *  money：收款金额
	*/
//	public void transfer(String outUser, String inUser, Double money) {
//	    // 收款时，收款用户的余额=现有余额+所汇金额
//	    this.jdbcTemplate.update("update account set balance = balance +? "
//	            + "where username = ?",money, inUser);
//	    // 模拟系统运行时的突发性问题
//	    int i = 1/0;
//	    // 汇款时，汇款用户的余额=现有余额-所汇金额
//	    this.jdbcTemplate.update("update account set balance = balance-? "
//	            + "where username = ?",money, outUser);
//	}

	@Transactional(propagation = Propagation.REQUIRED, 
            isolation = Isolation.DEFAULT, readOnly = false)
	public void transfer(String outUser, String inUser, Double money) {
	    // 收款时，收款用户的余额=现有余额+所汇金额
	    this.jdbcTemplate.update("update account set balance = balance +? "
	            + "where username = ?",money, inUser);
	    // 模拟系统运行时的突发性问题
	    int i = 1/0;
	    // 汇款时，汇款用户的余额=现有余额-所汇金额
	    this.jdbcTemplate.update("update account set balance = balance-? "
	            + "where username = ?",money, outUser);
	}

}
