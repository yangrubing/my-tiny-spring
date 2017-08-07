package com.yrb.tinyioc.io;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author bjyangrubing
 * @createTime 2017/8/7 15:52
 * Description: url资源
 */
public class UrlResource implements Resource
{

	private final URL url;

	public UrlResource(URL url)
	{
		this.url = url;
	}

	@Override
	public InputStream getInputStream() throws Exception
	{
		URLConnection connection = url.openConnection();
		connection.connect();
		return connection.getInputStream();
	}
}
