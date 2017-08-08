package com.yrb.tinyioc.aop;

import com.yrb.tinyioc.beans.BeanPostProcessor;
import com.yrb.tinyioc.beans.factory.AbstractBeanFactory;
import com.yrb.tinyioc.beans.factory.BeanFactory;
import org.aopalliance.intercept.MethodInterceptor;

import java.util.List;

/**
 * @author bjyangrubing
 * @createTime 2017/8/8 14:04
 * Description: 
 */
public class AspectJAwareAdvisorAutoProxyCreator implements BeanPostProcessor, BeanFactoryAware
{

	private AbstractBeanFactory beanFactory;

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws Exception
	{
		this.beanFactory = (AbstractBeanFactory) beanFactory;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception
	{
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception
	{
		if (bean instanceof AspectJExpressionPointcutAdvisor)
			return bean;
		if (bean instanceof MethodInterceptor)
			return bean;

		List<AspectJExpressionPointcutAdvisor> advisors = beanFactory
				.getBeansForType(AspectJExpressionPointcutAdvisor.class);
		for (AspectJExpressionPointcutAdvisor advisor : advisors)
		{
			if (advisor.getPointcut().getClassFilter().matches(bean.getClass()))
			{
				ProxyFactory advisedSupport = new ProxyFactory();
				advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
				advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());

				TargetSource targetSource = new TargetSource(bean.getClass(), bean.getClass().getInterfaces(), bean);
				advisedSupport.setTargetSource(targetSource);

				return advisedSupport.getProxy();
			}
		}

		return bean;
	}
}
