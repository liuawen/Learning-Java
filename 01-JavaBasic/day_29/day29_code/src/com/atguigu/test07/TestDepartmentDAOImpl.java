package com.atguigu.test07;

import java.util.List;

import org.junit.Test;

import com.atguigu.test06.bean.Department;

public class TestDepartmentDAOImpl {
	private DepartmentDAO dd = new DepartmentDAOImpl();
	
	@Test
	public void test01(){
		Department d = new Department();
		d.setDname("测试尚硅谷");
		d.setDescription("uuuu");
		
		dd.addDepartment(d);
	}
	
	@Test
	public void test02(){
		//修改5185部门的名称为发钱部
		Department d = dd.getById(5185);
		System.out.println(d);
		
		d.setDname("发钱部");
		
		dd.updateDepartment(d);
	}
	
	@Test
	public void test03(){
		List<Department> all = dd.getAll();
		all.forEach(System.out::println);
	}
	
	@Test
	public void test04(){
		//删除5184
		dd.deleteDepartmentByDid(5184);
	}
}
