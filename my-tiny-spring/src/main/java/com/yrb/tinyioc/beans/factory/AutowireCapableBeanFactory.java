package com.yrb.tinyioc.beans.factory;

import com.yrb.tinyioc.BeanReference;
import com.yrb.tinyioc.beans.BeanDefinition;
import com.yrb.tinyioc.beans.PropertyValue;

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
		beanDefinition.setBean(bean);
		applyPropertyValues(bean, beanDefinition);
		return bean;
	}

	/**
	 * 将bean的属性值进行注入
	 * @param bean
	 * @param beanDefinition
	 */
	private void applyPropertyValues(Object bean, BeanDefinition beanDefinition)
			throws Exception
	{
		for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues())
		{
			Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
			declaredField.setAccessible(true);

			Object value = propertyValue.getValue();

			if (value instanceof BeanReference)
			{
				BeanReference beanReference = (BeanReference) value;
				value = getBean(beanReference.getName());
			}
			declaredField.set(bean, value);
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
