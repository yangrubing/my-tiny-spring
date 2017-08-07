package com.yrb.tinyioc.io;

import java.io.InputStream;

/**
 * @author bjyangrubing
 * @createTime 2017/8/7 15:50
 * Description: Resource是spring内部定位资源的借口
 */
public interface Resource
{
	InputStream getInputStream() throws Exception;
}
