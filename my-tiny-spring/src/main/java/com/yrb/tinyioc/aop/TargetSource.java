package com.yrb.tinyioc.aop;

/**
 * @author bjyangrubing
 * @createTime 2017/8/7 20:22
 * Description: 被代理的对象
 */
public class TargetSource
{

	private Class<?> targetClass;

	private Class<?>[] interfaces;

	private Object target;

	public TargetSource(Class<?> targetClass, Class<?>[] interfaces, Object target)
	{
		this.targetClass = targetClass;
		this.interfaces = interfaces;
		this.target = target;
	}

	public Class<?> getTargetClass()
	{
		return targetClass;
	}

	public Class<?>[] getInterfaces()
	{
		return interfaces;
	}

	public Object getTarget()
	{
		return target;
	}
}
