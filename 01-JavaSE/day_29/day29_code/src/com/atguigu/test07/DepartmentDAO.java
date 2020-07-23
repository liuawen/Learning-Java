package com.atguigu.test07;

import java.util.List;

import com.atguigu.test06.bean.Department;

public interface DepartmentDAO {
	void addDepartment(Department dept);
	void updateDepartment(Department dept);
	void deleteDepartmentByDid(int did);
	Department getById(int did);
	List<Department> getAll();
}
