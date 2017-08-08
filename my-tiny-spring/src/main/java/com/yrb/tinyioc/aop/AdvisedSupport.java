package com.yrb.tinyioc.aop;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * @author bjyangrubing
 * @createTime 2017/8/7 20:29
 * Description: 代理相关的元数据
 */
public class AdvisedSupport
{
	private TargetSource targetSource;

	private MethodInterceptor methodInterceptor;

	public TargetSource getTargetSource()
	{
		return targetSource;
	}

	public void setTargetSource(TargetSource targetSource)
	{
		this.targetSource = targetSource;
	}

	public MethodInterceptor getMethodInterceptor()
	{
		return methodInterceptor;
	}

	public void setMethodInterceptor(MethodInterceptor methodInterceptor)
	{
		this.methodInterceptor = methodInterceptor;
	}
}
