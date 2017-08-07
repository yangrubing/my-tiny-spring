package com.yrb.tinyioc.factory;

import com.yrb.tinyioc.BeanDefinition;

/**
 * @author bjyangrubing
 * @createTime 2017/8/7 14:32
 * Description: 工厂接口
 */
public interface BeanFactory
{
	Object getBean(String name) throws Exception;

	void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;
}
