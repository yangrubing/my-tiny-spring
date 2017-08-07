package com.yrb.tinyioc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author bjyangrubing
 * @createTime 2017/8/7 14:32
 * Description: Bean的工厂类，可以从这个类中生成bean
 */
public class BeanFactory
{
	private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

	public Object getBean(String beanName)
	{
		return beanDefinitionMap.get(beanName).getBean();
	}

	/**
	 * 注册BeanDefinition
	 * @param beanName bean的名称
	 * @param beanDefinition
	 */
	public void regitsterBeanDefinition(String beanName, BeanDefinition beanDefinition)
	{
		beanDefinitionMap.put(beanName, beanDefinition);
	}

}
