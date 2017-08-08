package com.yrb.tinyioc.aop;

import org.aopalliance.aop.Advice;

/**
 * @author bjyangrubing
 * @createTime 2017/8/8 11:01
 * Description: 
 */
public interface Advisor
{

	Advice getAdvice();
}
