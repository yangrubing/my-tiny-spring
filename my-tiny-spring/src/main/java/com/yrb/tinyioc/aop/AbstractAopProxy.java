package com.yrb.tinyioc.aop;

/**
 * @author bjyangrubing
 * @createTime 2017/8/8 15:18
 * Description: AopProxy接口的抽象实现，有获取代理对象的能力
 */
public abstract class AbstractAopProxy implements AopProxy
{
	/**该对象持有了一个AdvisedSupport*/
	protected AdvisedSupport advised;

	public AbstractAopProxy(AdvisedSupport advised)
	{
		this.advised = advised;
	}
}
