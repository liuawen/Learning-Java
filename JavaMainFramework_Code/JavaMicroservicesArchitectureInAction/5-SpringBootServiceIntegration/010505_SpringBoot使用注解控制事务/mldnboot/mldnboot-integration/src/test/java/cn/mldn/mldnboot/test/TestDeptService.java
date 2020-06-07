package cn.mldn.mldnboot.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.mldn.mldnboot.SpringBootStartApplication;
import cn.mldn.mldnboot.po.Dept;
import cn.mldn.mldnboot.service.IDeptService;

@SpringBootTest(classes = SpringBootStartApplication.class)		// 定义要测试的SpringBoot类
@RunWith(SpringJUnit4ClassRunner.class)							// 使用Junit进行测试
@WebAppConfiguration											// 进行Web应用配置
public class TestDeptService {
	@Autowired
	private IDeptService deptService ; 							// 注入业务接口对象
	@Test
	public void testList() {
		List<Dept> allDepts = this.deptService.list() ;
		for (Dept dept : allDepts) {
			System.out.println("部门编号：" + dept.getDeptno() + "、部门名称：" + dept.getDname());
		}
	}
}
