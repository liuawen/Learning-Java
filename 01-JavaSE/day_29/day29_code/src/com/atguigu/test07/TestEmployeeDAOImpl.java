package com.atguigu.test07;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import com.atguigu.test06.bean.Employee;

public class TestEmployeeDAOImpl {
	private EmployeeDAO ed = new EmployeeDAOImpl();
	@Test
	public void test01() throws ParseException{
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String bir = "1995-01-01";
		String hie = "2019-06-24";
		Employee emp = new Employee(0, "杨洪强", "10086", "男", 40000.0, 0.0, sf.parse(bir), sf.parse(hie), 1, "yang@atguigu.com", 7, "宏福苑", "山东", 1);
		
		ed.addEmployee(emp);
	}
	
	@Test
	public void test02(){
		Employee e = ed.getByEid(26);
		System.out.println(e);
	}
	
	@Test
	public void test03(){
		Employee e = ed.getByEid(21);
		System.out.println(e);
	}
	
	@Test
	public void test04(){
		long count = ed.getEmployeeCount();
		System.out.println(count);
	}
	
	@Test
	public void test05(){
		Map<Integer, Double> map = ed.getAvgPerDepartment();
		Set<Entry<Integer, Double>> entrySet = map.entrySet();
		for (Entry<Integer, Double> entry : entrySet) {
			System.out.println(entry);
		}
	}
}
