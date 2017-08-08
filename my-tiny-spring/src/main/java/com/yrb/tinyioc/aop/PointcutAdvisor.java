package com.yrb.tinyioc.aop;

/**
 * @author bjyangrubing
 * @createTime 2017/8/8 11:17
 * Description: 
 */
public interface PointcutAdvisor extends Advisor
{
	Pointcut getPointcut();
}
