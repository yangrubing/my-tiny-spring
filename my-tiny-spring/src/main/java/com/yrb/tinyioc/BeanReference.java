package com.yrb.tinyioc;

/**
 * @author bjyangrubing
 * @createTime 2017/8/7 17:17
 * Description: 
 */
public class BeanReference
{

	private String name;
	private Object bean;

	public BeanReference(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Object getBean()
	{
		return bean;
	}

	public void setBean(Object bean)
	{
		this.bean = bean;
	}
}
