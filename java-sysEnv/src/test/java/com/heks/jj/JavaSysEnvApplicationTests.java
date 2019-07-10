package com.heks.jj;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Properties;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaSysEnvApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void test(){
		//获取所有的属性
		Properties properties = System.getProperties();
		//遍历所有的属性
		for (String key : properties.stringPropertyNames()) {
			//输出对应的键和值
			System.out.println(key + "=" + properties.getProperty(key));
		}

	}

	@Test
	public void testJDBC(){
		//获取所有的属性
		Properties properties = System.getProperties();
		//为了看看系统的属性有几个，加了一个计数器
		int count = 0;
		//遍历所有的属性
		for (String key : properties.stringPropertyNames()) {
			System.out.println(key + "=" + properties.getProperty(key));
			count++;
			if (key.equalsIgnoreCase("jdbc.drivers")){
				System.out.println("YES");
				return ;
			}

		}
		System.out.println(count);
	}


	@Test
	public void testGETSET(){
		System.setProperty("xueqiu.env", "production");
		System.out.println(System.getProperty("xueqiu.env"));
		String env = System.getProperty("xueqiu.env", "sep");
		System.out.println(env);
	}
}
