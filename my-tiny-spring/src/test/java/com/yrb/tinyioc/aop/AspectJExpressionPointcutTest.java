package com.yrb.tinyioc.aop;

import com.yrb.tinyioc.HelloWorldService;
import com.yrb.tinyioc.HelloWorldServiceImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author bjyangrubing
 * @createTime 2017/8/8 12:20
 * Description: 
 */
public class AspectJExpressionPointcutTest
{

	@Test
	public void testClassFilter()
	{
		String expression = "execution(* com.yrb.tinyioc.*.*(..))";
		AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
		aspectJExpressionPointcut.setExpression(expression);
		boolean matches = aspectJExpressionPointcut.getClassFilter().matches(HelloWorldService.class);
		Assert.assertTrue(matches);
	}

	@Test
	public void testMethodInterceptor() throws Exception
	{
		String expression = "execution(* com.yrb.tinyioc.*.*(..))";
		AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
		aspectJExpressionPointcut.setExpression(expression);
		boolean matches = aspectJExpressionPointcut.getMethodMatcher()
				.matches(HelloWorldServiceImpl.class.getDeclaredMethod("helloWorld"), HelloWorldServiceImpl.class);
		Assert.assertTrue(matches);
	}

}
