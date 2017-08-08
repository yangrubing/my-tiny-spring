package com.yrb.tinyioc.aop;

/**
 * @author bjyangrubing
 * @createTime 2017/8/8 15:51
 * Description: 
 */
public class ProxyFactory extends AdvisedSupport implements AopProxy
{

	@Override
	public Object getProxy()
	{
		return createAopProxy().getProxy();
	}

	protected final AopProxy createAopProxy()
	{
		return new Cglib2AopProxy(this);
	}
}
