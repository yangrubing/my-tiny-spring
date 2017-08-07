package com.yrb.tinyioc;

import org.junit.Assert;

/**
 * @author bjyangrubing
 * @createTime 2017/8/7 17:24
 * Description: 
 */
public class OutputService
{
	private HelloWorldService helloWorldService;

	public void output(String text)
	{
		Assert.assertNotNull(helloWorldService);
		System.out.println(text);
	}

	public void setHelloWorldService(HelloWorldService helloWorldService)
	{
		this.helloWorldService = helloWorldService;
	}
}
