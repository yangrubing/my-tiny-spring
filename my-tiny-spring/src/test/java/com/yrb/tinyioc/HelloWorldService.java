package com.yrb.tinyioc;

/**
 * @author bjyangrubing
 * @createTime 2017/8/7 14:39
 * Description: 
 */
public class HelloWorldService
{
	private String text;

	public void helloworld()
	{
		System.out.println(text);
	}

	public void setText(String text)
	{
		this.text = text;
	}
}
