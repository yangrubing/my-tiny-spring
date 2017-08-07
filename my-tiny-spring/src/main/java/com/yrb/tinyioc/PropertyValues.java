package com.yrb.tinyioc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bjyangrubing
 * @createTime 2017/8/7 15:23
 * Description: 包装一个bean的所有PropertyValue
 * 不直接用List因为可以封装一些操作
 */
public class PropertyValues
{

	private final List<PropertyValue> propertyValueList = new ArrayList<PropertyValue>();

	public void addPropertyValue(PropertyValue pv)
	{
		// TODO: 2017/8/7 这里可以有一些去重等操作
		this.propertyValueList.add(pv);
	}

	public List<PropertyValue> getPropertyValues()
	{
		return this.propertyValueList;
	}

}
