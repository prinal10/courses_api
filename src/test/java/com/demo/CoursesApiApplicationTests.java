package com.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.controller.HelloController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoursesApiApplicationTests {

	@Test
	public void testApp() {
		HelloController hc = new HelloController();
		String result = hc.sayHi();
		assertEquals(result, "Hi");

	}

}
