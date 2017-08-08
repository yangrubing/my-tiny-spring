package com.yrb.tinyioc.aop;

import com.yrb.tinyioc.HelloWorldService;
import com.yrb.tinyioc.context.ApplicationContext;
import com.yrb.tinyioc.context.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @author bjyangrubing
 * @createTime 2017/8/8 10:06
 * Description: 
 */
public class JdkDynamicAopProxyTest
{

	@Test
	public void test() throws Exception
	{
		//------------helloworld service without aop
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc.xml");
		HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
		helloWorldService.helloWorld();

		//------------helloworld service with aop
		//1. 设置被代理的对象（Join Point)
		AdvisedSupport advisedSupport = new AdvisedSupport();
		TargetSource targetSource = new TargetSource(HelloWorldService.class, helloWorldService);
		advisedSupport.setTargetSource(targetSource);

		//2. 设置拦截器(Advice)
		TimerInterceptor timerInterceptor = new TimerInterceptor();
		advisedSupport.setMethodInterceptor(timerInterceptor);

		//3. 创建代理(Proxy)
		JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advisedSupport);
		HelloWorldService helloWorldServiceProxy = (HelloWorldService) jdkDynamicAopProxy.getProxy();

		//4. 基于AOP的调用
		helloWorldServiceProxy.helloWorld();

	}

}