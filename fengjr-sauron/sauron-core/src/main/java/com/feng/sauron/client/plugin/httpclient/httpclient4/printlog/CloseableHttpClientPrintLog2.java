package com.feng.sauron.client.plugin.httpclient.httpclient4.printlog;

import java.net.URI;

import org.apache.http.client.methods.HttpUriRequest;

import com.feng.sauron.client.plugin.PrintTraceLog;
import com.feng.sauron.client.plugin.TracerAdapterFactory;

/**
 * @author wei.wang@fengjr.com
 * @version 创建时间：2016年10月31日 下午1:53:42
 * 
 */
public class CloseableHttpClientPrintLog2 implements PrintTraceLog {

	private CloseableHttpClientPrintLog2() {
	}

	private static class InnerClass {
		private static final CloseableHttpClientPrintLog2 Inner_Class = new CloseableHttpClientPrintLog2();
	}

	public static CloseableHttpClientPrintLog2 getInstances() {
		return InnerClass.Inner_Class;
	}

	@Override
	public String print(TracerAdapterFactory tracerAdapterFactory) {

		try {
			if (tracerAdapterFactory.params != null && tracerAdapterFactory.params.length >= 2 && tracerAdapterFactory.params[1] instanceof HttpUriRequest) {
				HttpUriRequest httpUriRequest = (HttpUriRequest) tracerAdapterFactory.params[1];
				URI uri = httpUriRequest.getURI();
				tracerAdapterFactory.detail = uri.getHost() + ":" + uri.getPort();
				tracerAdapterFactory.paramClazz = new Class<?>[] { String.class };
				tracerAdapterFactory.params = new Object[] { uri.toString() };

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
