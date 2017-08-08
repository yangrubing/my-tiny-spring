package com.yrb.tinyioc.aop;

import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author bjyangrubing
 * @createTime 2017/8/7 20:30
 * Description: 基于JDK的动态代理
 */
public class JdkDynamicAopProxy implements AopProxy, InvocationHandler
{
	private AdvisedSupport advised;

	public JdkDynamicAopProxy(AdvisedSupport advised)
	{
		this.advised = advised;
	}

	@Override
	public Object getProxy()
	{
		return Proxy.newProxyInstance(getClass().getClassLoader(),
				advised.getTargetSource().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		MethodInterceptor methodInterceptor = advised.getMethodInterceptor();
		if (advised.getMethodMatcher() != null && advised.getMethodMatcher()
				.matches(method, advised.getTargetSource().getTarget().getClass()))
		{
			return methodInterceptor
					.invoke(new ReflectiveMethodInvocation(advised.getTargetSource().getTarget(), method, args));
		}
		else
		{
			return method.invoke(advised.getTargetSource().getTarget(), args);
		}

	}
}

