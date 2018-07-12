package com.hero.demo;

import com.sun.glass.ui.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试
 * @author chenwenwei
 * @time 2018.05.05
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class DemoApplicationTests {

	class Demo{
		void Demo(){
			System.out.println(super.getClass());
		}

	}

	class Demo2 extends Demo{
		void Demo(){
			System.out.println(super.getClass().getName());
		}
	}

	@Test
	public void contextLoads() {
		Demo test=new Demo2();
		test.Demo();
	}

}

