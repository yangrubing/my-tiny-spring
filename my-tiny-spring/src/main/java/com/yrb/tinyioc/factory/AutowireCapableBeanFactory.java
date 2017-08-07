package com.yrb.tinyioc.factory;

import com.yrb.tinyioc.BeanDefinition;
import com.yrb.tinyioc.PropertyValue;

import java.lang.reflect.Field;

/**
 * @author bjyangrubing
 * @createTime 2017/8/7 14:54
 * Description: 自动装载的beanFactory， 根据beanDefinition中的Class来反射得到bean
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory
{
	@Override
	protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception
	{
		Object bean = createBeanInstance(beanDefinition);
		applyPropertyValues(bean, beanDefinition);
		return bean;
	}

	/**
	 * 将bean的属性值进行注入
	 * @param bean
	 * @param beanDefinition
	 */
	private void applyPropertyValues(Object bean, BeanDefinition beanDefinition)
			throws NoSuchFieldException, IllegalAccessException
	{
		for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues())
		{
			Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
			declaredField.setAccessible(true);
			declaredField.set(bean, propertyValue.getValue());
		}
	}

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

}
