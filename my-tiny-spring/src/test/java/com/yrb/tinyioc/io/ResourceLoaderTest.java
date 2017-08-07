package com.yrb.tinyioc.io;

import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

/**
 * @author bjyangrubing
 * @createTime 2017/8/7 17:02
 * Description: 
 */
public class ResourceLoaderTest
{
	@Test
	public void test() throws Exception
	{
		ResourceLoader resourceLoader = new ResourceLoader();
		Resource resource = resourceLoader.getResource("tinyioc.xml");
		InputStream inputStream = resource.getInputStream();
		Assert.assertNotNull(inputStream);
	}
}