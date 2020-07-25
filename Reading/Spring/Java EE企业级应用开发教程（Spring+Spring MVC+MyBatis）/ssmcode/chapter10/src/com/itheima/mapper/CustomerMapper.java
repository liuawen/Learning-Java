package com.itheima.mapper;
import com.itheima.po.Customer;
public interface CustomerMapper {
	// 通过id查询客户
	public Customer findCustomerById(Integer id);
	
	// 添加客户
	public void addCustomer(Customer customer);

}
