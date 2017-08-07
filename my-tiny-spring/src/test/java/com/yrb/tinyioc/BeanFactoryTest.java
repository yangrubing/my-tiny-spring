package com.yrb.tinyioc;

import com.yrb.tinyioc.factory.AutowireCapableBeanFactory;
import com.yrb.tinyioc.factory.BeanFactory;
import org.junit.Test;

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
		BeanFactory beanFactory = new AutowireCapableBeanFactory();

		//2. 注入bean
		BeanDefinition beanDefinition = new BeanDefinition();

		beanDefinition.setBeanClassName("com.yrb.tinyioc.HelloWorldService");

		beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);

		//3. 获取bean
		HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
		helloWorldService.helloworld();

	}

}