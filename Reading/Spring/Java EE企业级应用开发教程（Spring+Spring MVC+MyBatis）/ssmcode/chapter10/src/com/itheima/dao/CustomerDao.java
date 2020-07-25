package com.itheima.dao;
import com.itheima.po.Customer;
public interface CustomerDao {
	// 通过id查询客户
	public Customer findCustomerById(Integer id);
}
