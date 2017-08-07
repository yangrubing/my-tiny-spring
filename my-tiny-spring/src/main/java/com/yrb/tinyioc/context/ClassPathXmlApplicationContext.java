package com.yrb.tinyioc.context;

import com.yrb.tinyioc.beans.BeanDefinition;
import com.yrb.tinyioc.beans.factory.AbstractBeanFactory;
import com.yrb.tinyioc.beans.factory.AutowireCapableBeanFactory;
import com.yrb.tinyioc.beans.io.ResourceLoader;
import com.yrb.tinyioc.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @author bjyangrubing
 * @createTime 2017/8/7 19:45
 * Description: 
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext
{

	private String configLocation;

	public ClassPathXmlApplicationContext(String configLocation) throws Exception
	{
		this(configLocation, new AutowireCapableBeanFactory());
	}

	public ClassPathXmlApplicationContext(String configLocation, AbstractBeanFactory beanFactory) throws Exception
	{
		super(beanFactory);
		this.configLocation = configLocation;
		refresh();
	}

	@Override
	public void refresh() throws Exception
	{
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(new ResourceLoader());
		reader.loadBeanDefinitions(configLocation);
		for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : reader.getRegistry().entrySet())
		{
			beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
		}
	}
}