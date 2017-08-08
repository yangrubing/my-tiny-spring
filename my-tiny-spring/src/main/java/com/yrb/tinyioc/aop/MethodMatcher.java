package com.yrb.tinyioc.aop;

import java.lang.reflect.Method;

/**
 * @author bjyangrubing
 * @createTime 2017/8/8 11:04
 * Description: 
 */
public interface MethodMatcher
{
	boolean matches(Method method, Class targetClass);
}
