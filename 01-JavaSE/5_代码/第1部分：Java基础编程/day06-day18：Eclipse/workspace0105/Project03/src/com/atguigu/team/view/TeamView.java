package com.atguigu.team.view;

import com.atguigu.team.domain.*;
import com.atguigu.team.service.*;

public class TeamView {
	private NameListService listSvc = new NameListService();
	private TeamService teamSvc = new TeamService();

	public void enterMainMenu() {
		boolean loopFlag = true;
		char key = 0;

		do {
			if (key != '1') {
				listAllEmployees();
			}
			System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：");
			key = TSUtility.readMenuSelection();
			System.out.println();
			switch (key) {
			case '1':
				listTeam();
				break;
			case '2':
				addMember();
				break;
			case '3':
				deleteMember();
				break;
			case '4':
				System.out.print("确认是否退出(Y/N)：");
				char yn = TSUtility.readConfirmSelection();
				if (yn == 'Y')
					loopFlag = false;
				break;
			}
		} while (loopFlag);
	}

	// 显示所有的员工成员
	private void listAllEmployees() {
		System.out
				.println("\n-------------------------------开发团队调度软件--------------------------------\n");
		Employee[] emps = listSvc.getAllEmployees();
		if (emps.length == 0) {
			System.out.println("没有客户记录！");
		} else {
			System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
		}

		for (Employee e : emps) {
			System.out.println(" " + e);
		}
		System.out
				.println("-------------------------------------------------------------------------------");
	}

	// 显示开发团队成员列表
	private void listTeam() {
		System.out
				.println("\n--------------------团队成员列表---------------------\n");
		Programmer[] team = teamSvc.getTeam();
		if (team.length == 0) {
			System.out.println("开发团队目前没有成员！");
		} else {
			System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
		}

		for (Programmer p : team) {
			System.out.println(" " + p.getDetailsForTeam());
		}
		System.out
				.println("-----------------------------------------------------");
	}

	// 添加成员到团队
	private void addMember() {
		System.out.println("---------------------添加成员---------------------");
		System.out.print("请输入要添加的员工ID：");
		int id = TSUtility.readInt();

		try {
			Employee e = listSvc.getEmployee(id);
			teamSvc.addMember(e);
			System.out.println("添加成功");
		} catch (TeamException e) {
			System.out.println("添加失败，原因：" + e.getMessage());
		}
		// 按回车键继续...
		TSUtility.readReturn();
	}

	// 从团队中删除指定id的成员
	private void deleteMember() {
		System.out.println("---------------------删除成员---------------------");
		System.out.print("请输入要删除员工的TID：");
		int id = TSUtility.readInt();
		System.out.print("确认是否删除(Y/N)：");
		char yn = TSUtility.readConfirmSelection();
		if (yn == 'N')
			return;

		try {
			teamSvc.removeMember(id);
			System.out.println("删除成功");
		} catch (TeamException e) {
			System.out.println("删除失败，原因：" + e.getMessage());
		}
		// 按回车键继续...
		TSUtility.readReturn();
	}

	public static void main(String[] args) {
		TeamView view = new TeamView();
		view.enterMainMenu();
	}
}
