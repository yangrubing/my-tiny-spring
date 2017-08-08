package com.yrb.tinyioc.aop;

/**
 * @author bjyangrubing
 * @createTime 2017/8/7 20:20
 * Description: AOP代理
 * AopProxy是个标志型接口
 * 暴露获取aop代理对象方法的接口
 */
public interface AopProxy
{
	/**
	 * 获取代理对象
	 * @return
	 */
	Object getProxy();
}
