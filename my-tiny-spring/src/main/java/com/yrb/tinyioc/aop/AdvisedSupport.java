package com.yrb.tinyioc.aop;

import org.aopalliance.intercept.MethodInterceptor;

/**
 * @author bjyangrubing
 * @createTime 2017/8/7 20:29
 * Description: 封装了要拦截的对象（TargetSource）， 方法拦截器（MethodInterceptor），以及方法匹配器（MethodMatcher）
 */
public class AdvisedSupport
{

	/**要拦截的对象*/
	private TargetSource targetSource;

	/**方法拦截器，
	 * Spring的AOP只支持方法级别的调用，所以其实在AopProxy里，我们只需要将MethodInterceptor放入对象的方法调用
	 * */
	private MethodInterceptor methodInterceptor;

	/**
	 * 方法匹配器，判断是否是需要拦截的方法
	 */
	private MethodMatcher methodMatcher;

	public MethodMatcher getMethodMatcher()
	{
		return methodMatcher;
	}

	public void setMethodMatcher(MethodMatcher methodMatcher)
	{
		this.methodMatcher = methodMatcher;
	}

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
