package com.atguigu.team.service;

import com.atguigu.team.domain.*;


public class TeamService {
    private static int counter = 1;//用于自动生成团队成员的memberId
    private final int MAX_MEMBER = 5;//团队人数上限
    private Programmer[] team = new Programmer[MAX_MEMBER];//保存当前团队成员
    private int total = 0;//团队实际人数

    public TeamService() {
    }
    //返回team中所有程序员构成的数组
    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];

        for (int i = 0; i < total; i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    public void addMember(Employee e) throws TeamException {
        if (total >= MAX_MEMBER)
            throw new TeamException("成员已满，无法添加");
        if (!(e instanceof Programmer))
            throw new TeamException("该成员不是开发人员，无法添加");

        Programmer p = (Programmer)e;
        
        if (isExist(p))
        	throw new TeamException("该员工已在本团队中");
        
        if(p.getStatus().getNAME().equals("BUSY")) {
        	throw new TeamException("该员工已是某团队成员");
        }else if(p.getStatus().getNAME().equals("VOCATION")) {
        	throw new TeamException("该员正在休假，无法添加");
        }

//        switch (p.getStatus()) {
//            case BUSY    :throw new TeamException("该员工已是某团队成员");
//            case VOCATION:throw new TeamException("该员正在休假，无法添加");
//        }
        
        int numOfArch = 0, numOfDsgn = 0, numOfPrg = 0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect) numOfArch++;
            else if (team[i] instanceof Designer) numOfDsgn++;
            else if (team[i] instanceof Programmer) numOfPrg++;
        }

        if (p instanceof Architect) {
            if (numOfArch >= 1) throw new TeamException("团队中至多只能有一名架构师");
        } else if (p instanceof Designer) {
            if (numOfDsgn >= 2) throw new TeamException("团队中至多只能有两名设计师");
        } else if (p instanceof Programmer) {
            if (numOfPrg >= 3) throw new TeamException("团队中至多只能有三名程序员");
        }
        //添加到数组
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);
        team[total++] = p;
    }

    private boolean isExist(Programmer p) {
        for (int i = 0; i < total; i++) {
            if (team[i].getId() == p.getId()) return true;
        }

        return false;
    }
    //删除指定memberId的程序员
    public void removeMember(int memberId) throws TeamException {
        int n = 0;
        //找到指定memberId的员工，并删除
        for (; n < total; n++) {
            if (team[n].getMemberId() == memberId) {
                team[n].setStatus(Status.FREE);
                break;
            }
        }
        //如果遍历一遍，都找不到，则报异常
        if (n == total)
            throw new TeamException("找不到该成员，无法删除");
        //后面的元素覆盖前面的元素
        for (int i = n + 1; i < total; i++) {
            team[i - 1] = team[i];
        }
        team[--total] = null;
    }
}
