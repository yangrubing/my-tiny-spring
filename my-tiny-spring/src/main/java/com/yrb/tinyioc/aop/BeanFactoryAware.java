package com.yrb.tinyioc.aop;

import com.yrb.tinyioc.beans.factory.BeanFactory;

/**
 * @author bjyangrubing
 * @createTime 2017/8/8 13:58
 * Description: 
 */
public interface BeanFactoryAware
{
	void setBeanFactory(BeanFactory beanFactory) throws Exception;
}
