package com.yrb.tinyioc.aop;

/**
 * @author bjyangrubing
 * @createTime 2017/8/7 20:22
 * Description: 被代理的对象
 */
public class TargetSource
{

	private Class targetClass;

	private Object target;

	public TargetSource(Class targetClass, Object target)
	{
		this.targetClass = targetClass;
		this.target = target;
	}

	public Class getTargetClass()
	{
		return targetClass;
	}

	public Object getTarget()
	{
		return target;
	}

}
