package com.yrb.tinyioc.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author bjyangrubing
 * @createTime 2017/8/8 10:14
 * Description: 
 */
public class TimerInterceptor implements MethodInterceptor
{

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable
	{
		long time = System.nanoTime();
		System.out.println("Invocation of Method " + methodInvocation.getMethod().getName() + " start");
		Object result = methodInvocation.proceed();
		System.out.println(
				"Invocation of Method " + methodInvocation.getMethod().getName() + " end ! takes " + (System.nanoTime()
						- time) + " nanoseconds");
		return result;
	}
}
