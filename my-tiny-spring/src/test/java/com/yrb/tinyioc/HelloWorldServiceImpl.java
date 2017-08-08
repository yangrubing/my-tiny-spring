package com.yrb.tinyioc;

/**
 * @author bjyangrubing
 * @createTime 2017/8/7 14:39
 * Description: 
 */
public class HelloWorldServiceImpl implements HelloWorldService
{
	private String text;

	private OutputService outputService;

	public void helloWorld()
	{
		outputService.output(text);
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public void setOutputService(OutputService outputService)
	{
		this.outputService = outputService;
	}
}
