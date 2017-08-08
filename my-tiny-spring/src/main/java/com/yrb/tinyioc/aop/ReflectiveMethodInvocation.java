package com.yrb.tinyioc.aop;

import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/**
 * @author bjyangrubing
 * @createTime 2017/8/7 20:24
 * Description: 
 */
public class ReflectiveMethodInvocation implements MethodInvocation
{
	protected Object target;

	protected Method method;

	protected Object[] args;

	public ReflectiveMethodInvocation(Object target, Method method, Object[] args)
	{
		this.args = args;
		this.method = method;
		this.target = target;
	}

	@Override
	public Method getMethod()
	{
		return method;
	}

	@Override
	public Object[] getArguments()
	{
		return args;
	}

	@Override
	public Object proceed() throws Throwable
	{
		return method.invoke(target, args);
	}

	@Override
	public Object getThis()
	{
		return target;
	}

	@Override
	public AccessibleObject getStaticPart()
	{
		return method;
	}
}
