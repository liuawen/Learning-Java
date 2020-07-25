package com.itheima.test;
import org.springframework.context.ApplicationContext;
import 
     org.springframework.context.support.ClassPathXmlApplicationContext;
import com.itheima.po.Customer;
import com.itheima.service.CustomerService;
/**
 * 测试事务
 */
public class TransactionTest {
	public static void main(String[] args) {
		ApplicationContext act = 
             new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerService customerService = 
                                            act.getBean(CustomerService.class);
		Customer customer = new Customer();
		customer.setUsername("zhangsan");
		customer.setJobs("manager");
		customer.setPhone("13233334444");
		customerService.addCustomer(customer);
	}
}
