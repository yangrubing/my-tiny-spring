package com.yrb.tinyioc.aop;

import com.yrb.tinyioc.HelloWorldService;
import com.yrb.tinyioc.context.ApplicationContext;
import com.yrb.tinyioc.context.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @author bjyangrubing
 * @createTime 2017/8/8 15:36
 * Description: 
 */
public class Cglib2AopProxyTest
{
	@Test
	public void testInterceptor() throws Exception
	{
		// --------- helloWorldService without AOP
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc.xml");
		HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
		helloWorldService.helloWorld();

		// --------- helloWorldService with AOP
		// 1. 设置被代理对象(Joinpoint)
		AdvisedSupport advisedSupport = new AdvisedSupport();
		TargetSource targetSource = new TargetSource(helloWorldService.getClass(),
				helloWorldService.getClass().getInterfaces(), helloWorldService);
		advisedSupport.setTargetSource(targetSource);

		// 2. 设置拦截器(Advice)
		TimerInterceptor timerInterceptor = new TimerInterceptor();
		advisedSupport.setMethodInterceptor(timerInterceptor);

		// 3. 创建代理(Proxy)
		Cglib2AopProxy cglib2AopProxy = new Cglib2AopProxy(advisedSupport);
		HelloWorldService helloWorldServiceProxy = (HelloWorldService) cglib2AopProxy.getProxy();

		// 4. 基于AOP的调用
		helloWorldServiceProxy.helloWorld();

	}
}