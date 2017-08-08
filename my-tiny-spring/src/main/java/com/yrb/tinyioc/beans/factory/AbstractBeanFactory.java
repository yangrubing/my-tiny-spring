package com.yrb.tinyioc.beans.factory;

import com.yrb.tinyioc.beans.BeanDefinition;
import com.yrb.tinyioc.beans.BeanPostProcessor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author bjyangrubing
 * @createTime 2017/8/7 14:55
 * Description: 
 */
public abstract class AbstractBeanFactory implements BeanFactory
{
	private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

	private final List<String> beanDefinitionNames = new ArrayList<String>();

	private List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

	@Override
	public Object getBean(String name) throws Exception
	{
		BeanDefinition beanDefinition = beanDefinitionMap.get(name);
		if (beanDefinition == null)
		{
			throw new IllegalArgumentException("No bean named " + name + " is defined");
		}
		Object bean = beanDefinition.getBean();
		if (bean == null)
		{
			bean = doCreateBean(beanDefinition);
			initializeBean(bean, name);
		}
		return bean;
	}

	protected void initializeBean(Object bean, String name) throws Exception
	{
		for (BeanPostProcessor beanPostProcessor : beanPostProcessors)
		{
			bean = beanPostProcessor.postProcessBeforeInitialization(bean, name);
		}

		//TODO :call initialize method
		for (BeanPostProcessor beanPostProcessor : beanPostProcessors)
		{
			bean = beanPostProcessor.postProcessAfterInitialization(bean, name);
		}
	}

	public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception
	{
		beanDefinitionMap.put(name, beanDefinition);
		beanDefinitionNames.add(name);
	}

	public void preInstantiateSingletons() throws Exception
	{
		for (Iterator it = this.beanDefinitionNames.iterator(); it.hasNext(); )
		{
			String beanName = (String) it.next();
			getBean(beanName);
		}
	}

	protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception
	{
		Object bean = createBeanInstance(beanDefinition);
		beanDefinition.setBean(bean);
		applyPropertyValues(bean, beanDefinition);
		return bean;
	}

	protected abstract void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception;

	/**
	 * 通过Class对象来创造一个对象
	 * @param beanDefinition
	 * @return
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	private Object createBeanInstance(BeanDefinition beanDefinition)
			throws IllegalAccessException, InstantiationException
	{
		return beanDefinition.getBeanClass().newInstance();
	}

	public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) throws Exception
	{
		this.beanPostProcessors.add(beanPostProcessor);
	}

	public List getBeansForType(Class type) throws Exception
	{
		List<Object> beans = new ArrayList<Object>();
		for (String beanDefinitionName : beanDefinitionNames)
		{
			if (type.isAssignableFrom(beanDefinitionMap.get(beanDefinitionName).getBeanClass()))
			{
				beans.add(getBean(beanDefinitionName));
			}
		}
		return beans;
	}

}
