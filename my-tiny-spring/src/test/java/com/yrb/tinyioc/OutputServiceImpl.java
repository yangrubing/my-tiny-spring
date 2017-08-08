package com.yrb.tinyioc;

/**
 * @author bjyangrubing
 * @createTime 2017/8/8 14:24
 * Description: 
 */
public class OutputServiceImpl implements OutputService
{

	@Override
	public void output(String text)
	{
		System.out.println(text);
	}

}