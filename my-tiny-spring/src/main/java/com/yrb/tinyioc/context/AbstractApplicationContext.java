package com.yrb.tinyioc.context;

import com.yrb.tinyioc.beans.factory.AbstractBeanFactory;

/**
 * @author bjyangrubing
 * @createTime 2017/8/7 19:43
 * Description: 
 */
public abstract class AbstractApplicationContext implements ApplicationContext
{
	protected AbstractBeanFactory beanFactory;

	public AbstractApplicationContext(AbstractBeanFactory beanFactory)
	{
		this.beanFactory = beanFactory;
	}

	public void refresh() throws Exception
	{
	}

	@Override
	public Object getBean(String name) throws Exception
	{
		return beanFactory.getBean(name);
	}
}
