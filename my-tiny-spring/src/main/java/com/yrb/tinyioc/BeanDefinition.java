package com.yrb.tinyioc;


/**
 * @author bjyangrubing
 * @createTime 2017/8/7 14:28
 * Description: bean的内容以及元数据，保存在beanFactory中，包装bean的实体
 */
public class BeanDefinition
{
	private Object bean;

	private Class beanClass;

	private String beanClassName;

	public PropertyValues getPropertyValues()
	{
		return propertyValues;
	}

	public void setPropertyValues(PropertyValues propertyValues)
	{
		this.propertyValues = propertyValues;
	}

	private PropertyValues propertyValues;

	public Class getBeanClass()
	{
		return beanClass;
	}

	public void setBeanClass(Class beanClass)
	{
		this.beanClass = beanClass;
	}

	public String getBeanClassName()
	{
		return beanClassName;
	}

	public void setBeanClassName(String beanClassName)
	{
		this.beanClassName = beanClassName;
		try
		{
			/**
			 * 根据bean的className来获取bean的Class对象
			 */
			this.beanClass = Class.forName(beanClassName);
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}

	}

	public Object getBean()
	{
		return bean;
	}

	public void setBean(Object bean)
	{
		this.bean = bean;
	}
}
