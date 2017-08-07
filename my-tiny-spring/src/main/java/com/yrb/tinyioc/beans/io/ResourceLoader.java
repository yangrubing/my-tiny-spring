package com.yrb.tinyioc.beans.io;

import java.net.URL;

/**
 * @author bjyangrubing
 * @createTime 2017/8/7 15:53
 * Description: 根据location来加载资源
 */
public class ResourceLoader
{
	public Resource getResource(String location)
	{
		URL resource = this.getClass().getClassLoader().getResource(location);
		return new UrlResource(resource);
	}
}
