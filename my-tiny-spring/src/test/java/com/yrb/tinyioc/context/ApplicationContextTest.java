package com.yrb.tinyioc.context;

import com.yrb.tinyioc.HelloWorldService;
import org.junit.Test;

/**
 * @author bjyangrubing
 * @createTime 2017/8/7 20:07
 * Description: 
 */
public class ApplicationContextTest
{
	@Test
	public void test() throws Exception
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("tinyioc.xml");
		HelloWorldService helloWorldService = (HelloWorldService) context.getBean("helloWorldService");
		helloWorldService.helloWorld();
	}
}