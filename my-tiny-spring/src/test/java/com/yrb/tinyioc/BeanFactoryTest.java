package com.yrb.tinyioc;

import com.yrb.tinyioc.factory.AutowireCapableBeanFactory;
import com.yrb.tinyioc.factory.BeanFactory;
import com.yrb.tinyioc.io.ResourceLoader;
import com.yrb.tinyioc.xml.XmlBeanDefinitionReader;
import org.junit.Test;

import java.util.Map;

/**
 * @author bjyangrubing
 * @createTime 2017/8/7 14:37
 * Description: 
 */
public class BeanFactoryTest
{

	@Test
	public void test() throws Exception
	{

		//1. 读取配置
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");

		//2. 初始化BeanFactory并注册Bean
		BeanFactory beanFactory = new AutowireCapableBeanFactory();
		for (Map.Entry<String, BeanDefinition> entry : xmlBeanDefinitionReader.getRegistry().entrySet())
		{
			beanFactory.registerBeanDefinition(entry.getKey(), entry.getValue());
		}

		//3. 获取bean
		HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
		helloWorldService.helloworld();

	}

}