package com.yrb.tinyioc;

import com.yrb.tinyioc.beans.BeanPostProcessor;

/**
 * @author bjyangrubing
 * @createTime 2017/8/8 12:14
 * Description: 
 */
public class BeanInitializeLogger implements BeanPostProcessor
{
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception
	{
		System.out.println("Initialize bean " + beanName + " start!");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception
	{
		System.out.println("Initialize bean " + beanName + " end!");
		return bean;
	}
}
