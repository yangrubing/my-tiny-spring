package com.yrb.tinyioc;

/**
 * @author bjyangrubing
 * @createTime 2017/8/7 14:28
 * Description: Bean的定义类
 */
public class BeanDefinition
{
	private Object bean;

	public BeanDefinition(Object bean)
	{
		this.bean = bean;
	}

	public Object getBean()
	{
		return bean;
	}
}
