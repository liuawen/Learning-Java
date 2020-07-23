package com.atguigu.service;

import static com.atguigu.utils.Data.ARCHITECT;
import static com.atguigu.utils.Data.DESIGNER;
import static com.atguigu.utils.Data.EMPLOYEE;
import static com.atguigu.utils.Data.EMPLOYEES;
import static com.atguigu.utils.Data.EQIPMENTS;
import static com.atguigu.utils.Data.NOTEBOOK;
import static com.atguigu.utils.Data.PC;
import static com.atguigu.utils.Data.PRINTER;
import static com.atguigu.utils.Data.PROGRAMMER;

import com.atguigu.bean.Architect;
import com.atguigu.bean.Designer;
import com.atguigu.bean.Employee;
import com.atguigu.bean.Equipment;
import com.atguigu.bean.NoteBook;
import com.atguigu.bean.PC;
import com.atguigu.bean.Printer;
import com.atguigu.bean.Programmer;
import com.atguigu.exception.TeamException;

public class NameListService {
	private Employee[] all;//用来存储全公司的员工对象
	
	public NameListService(){
		init();
	}
	
	//初始all数组的方法，数据的来源是Data.java
	private void init(){
		//(1)创建all数组，并指定长度
		all = new Employee[EMPLOYEES.length];
		
		//(2)遍历Data中EMPLOYEES的二维数组，把一行一行的数据
		//封装为一个一个的Employee,Programmer等的对象，放到all数组中
		for (int i = 0; i < EMPLOYEES.length; i++) {
			//EMPLOYEES[i][0]是员工类型
			int empType = Integer.parseInt(EMPLOYEES[i][0]);
			
			//因为每一种员工，都有id,name,age,salary，所以这些数据的读取转换，放在switch的上面
			//EMPLOYEES[i][1]是员工编号id
			int id = Integer.parseInt(EMPLOYEES[i][1]);
			
			//EMPLOYEES[i][2]是员工姓名name
			String name = EMPLOYEES[i][2];
			
			//EMPLOYEES[i][3]是员工年龄age
			int age = Integer.parseInt(EMPLOYEES[i][3]);
			
			//EMPLOYEES[i][4]是员工薪资salary
			double salary = Double .parseDouble(EMPLOYEES[i][4]);
			
			switch(empType){
			case EMPLOYEE:
//				all[i] = 创建Employee对象;
				all[i] = new Employee(id, name, age, salary);
				break;
			case PROGRAMMER:
//				all[i] = 创建Programmer对象;
				all[i] = new Programmer(id, name, age, salary, getEquipmentByLineNumber(i));
				break;	
			case DESIGNER:
//				all[i] = 创建Designer对象;
				//EMPLOYEES[i][5]
				double bonus = Double.parseDouble(EMPLOYEES[i][5]);
				all[i] = new Designer(id, name, age, salary, getEquipmentByLineNumber(i), bonus);
				break;
			case ARCHITECT:
//				all[i] = 创建Architect对象;
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				int stock = Integer.parseInt(EMPLOYEES[i][6]);
				all[i] = new Architect(id, name, age, salary, getEquipmentByLineNumber(i), bonus, stock);
				break;			
			}
		}
	}
	
	//读取第i行的设备对象
	private Equipment getEquipmentByLineNumber(int i){
		//(1)读取设备的类型，即EQIPMENTS[i][0]
		int eType = Integer.parseInt(EQIPMENTS[i][0]);
		switch(eType){
		case PC:
			return new PC(EQIPMENTS[i][1], EQIPMENTS[i][2]);
		case NOTEBOOK:
			return new NoteBook(EQIPMENTS[i][1], Double.parseDouble(EQIPMENTS[i][2]));
		case PRINTER:
			return new Printer(EQIPMENTS[i][1], EQIPMENTS[i][2]);
		}
		return null;
	}

	//返回所有的员工对象
	public Employee[] getAll(){
		return all;
	}

	//根据员工编号，获取员工对象
	public Employee getEmployeeById(int id) throws TeamException{
		for (int i = 0; i < all.length; i++) {
			if(all[i].getId() == id){
				return all[i];
			}
		}
		throw new TeamException(id+"对应的员工不存在");
	}
}
