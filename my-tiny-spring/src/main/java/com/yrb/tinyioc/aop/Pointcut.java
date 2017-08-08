package com.yrb.tinyioc.aop;

/**
 * @author bjyangrubing
 * @createTime 2017/8/8 11:12
 * Description: 
 */
public interface Pointcut
{
	ClassFilter getClassFilter();

	MethodMatcher getMethodMatcher();

}
