package com.yrb.tinyioc.factory;

import com.yrb.tinyioc.BeanDefinition;

/**
 * @author bjyangrubing
 * @createTime 2017/8/7 14:32
 * Description: 抽象工厂类
 */
public interface BeanFactory
{
	Object getBean(String name);

	void registerBeanDefinition(String name, BeanDefinition beanDefinition);
}
