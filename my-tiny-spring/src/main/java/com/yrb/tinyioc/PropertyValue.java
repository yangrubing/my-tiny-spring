package com.yrb.tinyioc;

/**
 * @author bjyangrubing
 * @createTime 2017/8/7 15:26
 * Description: 用于类的属性注入
 */
public class PropertyValue
{
	private final String name;
	private final Object value;

	public PropertyValue(String name, Object value)
	{
		this.name = name;
		this.value = value;
	}

	public String getName()
	{
		return name;
	}

	public Object getValue()
	{
		return value;
	}
}
