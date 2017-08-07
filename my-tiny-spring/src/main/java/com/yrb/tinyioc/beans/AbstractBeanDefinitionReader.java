package com.yrb.tinyioc.beans;

import com.yrb.tinyioc.beans.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bjyangrubing
 * @createTime 2017/8/7 16:19
 * Description: BeanDefinitionReader的抽象类
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader
{
	private Map<String, BeanDefinition> registry;

	private ResourceLoader resourceLoader;

	protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader)
	{
		this.registry = new HashMap<String, BeanDefinition>();
		this.resourceLoader = resourceLoader;
	}

	public Map<String, BeanDefinition> getRegistry()
	{
		return registry;
	}

	public ResourceLoader getResourceLoader()
	{
		return resourceLoader;
	}
}
