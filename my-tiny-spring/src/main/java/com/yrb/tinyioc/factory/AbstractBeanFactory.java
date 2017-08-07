package com.yrb.tinyioc.factory;

import com.yrb.tinyioc.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author bjyangrubing
 * @createTime 2017/8/7 14:55
 * Description: 
 */
public abstract class AbstractBeanFactory implements BeanFactory
{
	private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

	@Override
	public Object getBean(String name)
	{
		return beanDefinitionMap.get(name).getBean();
	}

	@Override
	public void registerBeanDefinition(String name, BeanDefinition beanDefinition)
	{
		Object bean = doCreateBean(beanDefinition);
		beanDefinition.setBean(bean);
		beanDefinitionMap.put(name, beanDefinition);
	}

	/**
	 * 根据beanDefinition, 初始化bean
	 * @param beanDefinition
	 * @return
	 */
	protected abstract Object doCreateBean(BeanDefinition beanDefinition);
}
