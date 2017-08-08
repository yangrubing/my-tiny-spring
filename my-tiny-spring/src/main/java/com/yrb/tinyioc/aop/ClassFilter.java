package com.yrb.tinyioc.aop;

/**
 * @author bjyangrubing
 * @createTime 2017/8/8 11:02
 * Description: 
 */
public interface ClassFilter
{
	boolean matches(Class targetClass);
}
