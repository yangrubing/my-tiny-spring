package com.yrb.tinyioc;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author bjyangrubing
 * @createTime 2017/8/7 14:37
 * Description: 
 */
public class BeanFactoryTest
{

	@Test
	public void test(){

		//1. 初始化beanFactory
		BeanFactory beanFactory = new BeanFactory();

		//2. 注入bean
		BeanDefinition beanDefinition = new BeanDefinition(new HelloWorldService());

		beanFactory.regitsterBeanDefinition("helloWorldService", beanDefinition);

		//3. 获取bean
		HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
		helloWorldService.helloworld();

	}

}