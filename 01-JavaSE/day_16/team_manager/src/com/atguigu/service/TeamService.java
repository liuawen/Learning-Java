package com.atguigu.service;

import java.util.Arrays;

import com.atguigu.bean.Architect;
import com.atguigu.bean.Designer;
import com.atguigu.bean.Employee;
import com.atguigu.bean.Programmer;
import com.atguigu.bean.Status;
import com.atguigu.exception.TeamException;

public class TeamService {
	//因为开发团队，要求必须是程序员、设计师、架构师
	private Programmer[] team;//用来装开发团队的成员
	private int total;//记录实际开发团队的成员的数量
	private static final int MAX_MEMBER = 5;
	private int currentMemberId = 1;//只增不减
	
	public TeamService(){
		team = new Programmer[MAX_MEMBER];
	}
	
	//添加一个团队成员
	public void addMember(Employee emp) throws TeamException{
		//(1)判断总人数
		if(total >= MAX_MEMBER){
			throw new TeamException("成员已满，无法添加");
		}
		
		//(2)判断是否是程序员或它子类的对象
		if(!(emp instanceof Programmer)){
			throw new TeamException("该成员不是开发人员，无法添加");
		}
		
		//(3)判断状态
		//如果要获取状态信息，需要把emp对象向下转型
		Programmer p = (Programmer) emp;
		switch(p.getStatus()){
		case BUSY:
			throw new TeamException("该员已是团队成员");
		case VOCATION:
			throw new TeamException("该员正在休假，无法添加");
		}
		
		//(4)判断每一种人的人数
		//现统计当前team中的每一个类型的对象的人数
		int pCount = 0;//程序员人数
		int dCount = 0;//设计师人数
		int aCount = 0;//架构师人数
		
		//这里用total，有几个人统计几个人
		for (int i = 0; i < total; i++) {
			//条件判断有顺序要求
			if(team[i] instanceof Architect){
				aCount++;
			}else if(team[i] instanceof Designer){
				dCount++;
			}else{
				pCount++;
			}
		}
		
		//如果刚才传入的emp-->p，是架构师，我们再看架构师够不够
		//如果刚才传入的emp-->p，是设计师，我们再看设计师够不够
		//如果刚才传入的emp-->p，是程序员，我们再看程序员够不够
		if(emp instanceof Architect ){
			if(aCount >= 1){
				throw new TeamException("团队中只能有一名架构师");
			}
		}else if(emp instanceof Designer ){
			if(dCount >= 2){
				throw new TeamException("团队中只能有两名设计师");
			}
		}else{
			if(pCount >= 3){
				throw new TeamException("团队中只能有三名程序员");
			}
		}
		
		//(5)可以正常添加
		//添加之前，修改状态，分配团队编号
		p.setStatus(Status.BUSY);
		p.setMemberId(currentMemberId++);
		//添加到team数组
		team[total++] = p;
	}
	
	//返回所有团队成员的方法
	public Programmer[] getAllMembers(){
		return Arrays.copyOf(team, total);
	}

	//根据团队编号删除团队成员
	public void removeMemberByTid(int tid) throws TeamException{
		//(1)要查找tid成员对应的下标index
		int index = -1;
		//这里用total，有几个人判断几个人
		for (int i = 0; i < total; i++) {
			if(team[i].getMemberId() == tid){
				index = i;
				break;
			}
		}
		if(index == -1){
			throw new TeamException(tid + "的团队成员不存在!");
		}
		
		//(2)先修改要被删除的成员的一些信息
		//team[index]这个成员要被删除
		team[index].setStatus(Status.FREE);
		team[index].setMemberId(0);
		
		//(3)把index后面的元素往前移动
		/*
		 * 如果记不住，如何推断
		 * 第一个参数：原数组
		 * 第二个参数：从哪个开始移动
		 * 第三个参数：目标数组
		 * 第四个参数：第二个参数的下标的元素移动到哪个下标，例如：index+1位置的元素移动到index
		 * 第五个参数：一共移动几个
		 * 
		 * 假设total = 5个，删除index= 1位置的元素
		 * 移动[2]->[1],[3]->[2],[4]->[3]  3个  =total - index - 1
		 */
		System.arraycopy(team, index+1, team, index, total-index-1);
		
		//(4)把最后一个置为null
		team[total--] = null;//使得这个对象尽快被回收，腾出内存
		
	}
}
