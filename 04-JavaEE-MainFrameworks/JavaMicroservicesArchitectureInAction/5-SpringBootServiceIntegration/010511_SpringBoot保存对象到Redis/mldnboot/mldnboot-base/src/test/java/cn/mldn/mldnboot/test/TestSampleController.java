package cn.mldn.mldnboot.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.mldn.mldnboot.SpringBootStartApplication;
import cn.mldn.mldnboot.controller.MessageController;
import junit.framework.TestCase;

@SpringBootTest(classes = SpringBootStartApplication.class)	// 定义要测试的SpringBoot类
@RunWith(SpringJUnit4ClassRunner.class)				// 使用Junit进行测试
@WebAppConfiguration								// 进行Web应用配置
public class TestSampleController {
	@Autowired
	private MessageController messageController;		// 注入控制器对象

	@Test
	public void testHome() {						// 使用junit测试
		TestCase.assertEquals(this.messageController.home(), "www.mldn.cn");
	}
}
