package com.yrb.tinyioc.aop;

import org.aspectj.weaver.tools.PointcutExpression;
import org.aspectj.weaver.tools.PointcutParser;
import org.aspectj.weaver.tools.PointcutPrimitive;
import org.aspectj.weaver.tools.ShadowMatch;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * @author bjyangrubing
 * @createTime 2017/8/8 11:05
 * Description: 
 */
public class AspectJExpressionPointcut implements Pointcut, ClassFilter, MethodMatcher
{
	/*切点的解析器*/
	private PointcutParser pointcutParser;

	private String expression;

	private PointcutExpression pointcutExpression;

	private static final Set<PointcutPrimitive> DEFAULT_SUPPORTED_PRIMITIVES = new HashSet<PointcutPrimitive>();

	static
	{
		DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.EXECUTION);
		DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.ARGS);
		DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.REFERENCE);
		DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.THIS);
		DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.TARGET);
		DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.WITHIN);
		DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.AT_ANNOTATION);
		DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.AT_WITHIN);
		DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.AT_ARGS);
		DEFAULT_SUPPORTED_PRIMITIVES.add(PointcutPrimitive.AT_TARGET);
	}

	public AspectJExpressionPointcut()
	{
		this(DEFAULT_SUPPORTED_PRIMITIVES);
	}

	public AspectJExpressionPointcut(Set<PointcutPrimitive> supportedPrimitives)
	{
		pointcutParser = PointcutParser
				.getPointcutParserSupportingSpecifiedPrimitivesAndUsingContextClassloaderForResolution(
						supportedPrimitives);
	}

	protected void checkReadyToMatch()
	{
		if (pointcutExpression == null)
		{
			pointcutExpression = buildPointcutExpression();
		}
	}

	private PointcutExpression buildPointcutExpression()
	{
		return pointcutParser.parsePointcutExpression(expression);
	}

	@Override
	public boolean matches(Class targetClass)
	{
		checkReadyToMatch();
		return pointcutExpression.couldMatchJoinPointsInType(targetClass);
	}

	@Override
	public boolean matches(Method method, Class targetClass)
	{
		checkReadyToMatch();
		ShadowMatch shadowMatch = pointcutExpression.matchesMethodExecution(method);
		if (shadowMatch.alwaysMatches())
			return true;
		else if (shadowMatch.neverMatches())
			return false;
		return false;
	}

	@Override
	public ClassFilter getClassFilter()
	{
		return this;
	}

	@Override
	public MethodMatcher getMethodMatcher()
	{
		return this;
	}

	public void setExpression(String expression)
	{
		this.expression = expression;
	}
}
