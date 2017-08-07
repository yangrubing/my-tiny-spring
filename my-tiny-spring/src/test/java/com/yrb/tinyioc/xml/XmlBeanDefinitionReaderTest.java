package com.yrb.tinyioc.xml;

import com.yrb.tinyioc.io.ResourceLoader;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author bjyangrubing
 * @createTime 2017/8/7 16:38
 * Description: 
 */
public class XmlBeanDefinitionReaderTest
{
	@Test
	public void test() throws Exception
	{
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");
		//		Resource resource = xmlBeanDefinitionReader.getResourceLoader().getResource("tinyioc.xml");
		Assert.assertTrue(xmlBeanDefinitionReader.getRegistry().size() > 0);

	}

}