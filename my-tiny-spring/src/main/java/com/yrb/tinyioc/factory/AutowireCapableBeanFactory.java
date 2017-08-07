package com.yrb.tinyioc.factory;

import com.yrb.tinyioc.BeanDefinition;

/**
 * @author bjyangrubing
 * @createTime 2017/8/7 14:54
 * Description: 自动装载的beanFactory， 根据beanDefinition中的Class来反射得到bean
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory
{
	@Override
	protected Object doCreateBean(BeanDefinition beanDefinition)
	{
		try
		{
			Object bean = beanDefinition.getBeanClass().newInstance();
			return bean;
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		catch (InstantiationException e)
		{
			e.printStackTrace();
		}

		return null;
	}
}
