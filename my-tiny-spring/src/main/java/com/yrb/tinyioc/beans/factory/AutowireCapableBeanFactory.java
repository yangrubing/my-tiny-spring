package com.yrb.tinyioc.beans.factory;

import com.yrb.tinyioc.BeanReference;
import com.yrb.tinyioc.aop.BeanFactoryAware;
import com.yrb.tinyioc.beans.BeanDefinition;
import com.yrb.tinyioc.beans.PropertyValue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author bjyangrubing
 * @createTime 2017/8/7 14:54
 * Description: 自动装载的beanFactory， 根据beanDefinition中的Class来反射得到bean
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory
{
	/**
	 * 将bean的属性值进行注入
	 * @param bean
	 * @param beanDefinition
	 */
	@Override
	public void applyPropertyValues(Object bean, BeanDefinition beanDefinition)
			throws Exception
	{
		if (bean instanceof BeanFactoryAware)
		{
			((BeanFactoryAware) bean).setBeanFactory(this);
		}
		for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues())
		{
			Object value = propertyValue.getValue();
			if (value instanceof BeanReference)
			{
				BeanReference beanReference = (BeanReference) value;
				value = getBean(beanReference.getName());
			}

			try
			{
				Method declaredMethod = bean.getClass().getDeclaredMethod(
						"set" + propertyValue.getName().substring(0, 1).toUpperCase()
								+ propertyValue.getName().substring(1), value.getClass());
				declaredMethod.setAccessible(true);

				declaredMethod.invoke(bean, value);
			}
			catch (NoSuchMethodException e)
			{
				Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
				declaredField.setAccessible(true);
				declaredField.set(bean, value);
			}
		}
	}

}
