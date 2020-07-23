package com.atguigu.view;

import com.atguigu.bean.Employee;
import com.atguigu.bean.Programmer;
import com.atguigu.exception.TeamException;
import com.atguigu.service.NameListService;
import com.atguigu.service.TeamService;
import com.atguigu.utils.TSUtility;

public class TeamView {
	private NameListService ns = new NameListService();
	private TeamService ts = new TeamService();
	
	public void menu(){
		System.out.println("-------------------------------------开发团队调度软件--------------------------------------");
		getAllEmployee();
		
		while(true){
			System.out.println("---------------------------------------------------------------------------------------------------");
			System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：");
			char select = TSUtility.readMenuSelection();
			switch(select){
			case '1':
				list();
				break;
			case '2':
				getAllEmployee();
				add();
				break;
			case '3':
				list();
				remove();
				break;
			case '4':
				System.out.print("确认是否退出(Y/N):");
				char confirm = TSUtility.readConfirmSelection();
				if(confirm == 'Y'){
					return;
				}
			}
		}
	}
	
	private void remove() {
		System.out.println("---------------------删除成员---------------------");
		//(1)输入要删除的团队成员的团队编号
		System.out.print("请输入要删除员工的TID：");
		int tid = TSUtility.readInt();
		
		//(2)确认是否删除
		System.out.print("确认是否删除(Y/N):");
		char confirm = TSUtility.readConfirmSelection();
		if(confirm == 'N'){
			System.out.println("删除取消！");
			return;//提前结束删除
		}
		
		try {
			//(3)删除，调用TeamService的removeMemberByTid删除
			ts.removeMemberByTid(tid);
			System.out.println("删除成功！");
		} catch (TeamException e) {
			System.out.println("删除失败，原因：" + e.getMessage());
		}
		
		TSUtility.readReturn();
	}

	private void add() {
		System.out.println("---------------------添加成员---------------------");
		//(1)输入编号
		System.out.print("请输入要添加的员工ID：");
		int id = TSUtility.readInt();
		
		//(2)根据编号获取员工对象
		try {
			Employee emp = ns.getEmployeeById(id);
			
			//(3)添加到团队中
			
			ts.addMember(emp);
			
			System.out.println("添加成功");
		} catch (TeamException e) {
			System.out.println("添加失败，原因：" + e.getMessage());
		}
		
		TSUtility.readReturn();
	}

	private void list() {
		System.out.println("--------------------团队成员列表---------------------");
		System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
		Programmer[] allMembers = ts.getAllMembers();
		for (int i = 0; i < allMembers.length; i++) {
//			System.out.println(allMembers[i]);//自动调用toString()
			System.out.println(allMembers[i].getMemberInfo());
		}
		System.out.println("-----------------------------------------------------");
	}

	private void getAllEmployee(){
		System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
		//(1)获取所有的员工的信息
		
		Employee[] all = ns.getAll();
		
		//(2)遍历
		for (int i = 0; i < all.length; i++) {
			System.out.println(all[i]);//自动调用toString()
		}
	}
}
