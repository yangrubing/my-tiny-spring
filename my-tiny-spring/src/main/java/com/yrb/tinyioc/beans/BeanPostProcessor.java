package com.yrb.tinyioc.beans;

/**
 * @author bjyangrubing
 * @createTime 2017/8/8 11:59
 * Description: 
 */
public interface BeanPostProcessor
{
	Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception;

	Object postProcessAfterInitialization(Object bean, String beanName) throws Exception;
}
