package com.yrb.tinyioc.aop;

import org.aopalliance.aop.Advice;

/**
 * @author bjyangrubing
 * @createTime 2017/8/8 11:19
 * Description: 
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor
{
	private AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();

	private Advice advice;

	public void setPointcut(AspectJExpressionPointcut pointcut)
	{
		this.pointcut = pointcut;
	}

	public void setAdvice(Advice advice)
	{
		this.advice = advice;
	}

	@Override
	public Pointcut getPointcut()
	{
		return pointcut;
	}

	@Override
	public Advice getAdvice()
	{
		return advice;
	}

	public void setExpression(String expression)
	{
		this.pointcut.setExpression(expression);
	}
}
