package com.yrb.tinyioc.beans.factory;

/**
 * @author bjyangrubing
 * @createTime 2017/8/7 14:32
 * Description: 工厂接口
 */
public interface BeanFactory
{
	Object getBean(String name) throws Exception;

}
