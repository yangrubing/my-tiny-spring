package com.yrb.tinyioc;

/**
 * @author bjyangrubing
 * @createTime 2017/8/7 16:18
 * Description: 从配置中读取BeanDefinition
 */
public interface BeanDefinitionReader
{
	void loadBeanDefinitions(String location) throws Exception;
}
