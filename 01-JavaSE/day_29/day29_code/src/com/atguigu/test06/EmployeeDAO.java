package com.atguigu.test06;

import java.util.List;

import com.atguigu.test06.bean.Employee;

public interface EmployeeDAO {
	void addEmployee(Employee emp);
	void updateEmployee(Employee emp);
	void deleteEmployeeByEid(int eid);
	Employee getByEid(int eid);
	List<Employee> getAll();
}
