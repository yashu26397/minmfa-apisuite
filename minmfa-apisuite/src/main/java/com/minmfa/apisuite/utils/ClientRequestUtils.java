package com.minmfa.apisuite.utils;

import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

public class ClientRequestUtils {

	public static ClientHttpRequestFactory getClientHttpRequestFactory() {
		int timeout = 30000;
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		clientHttpRequestFactory.setReadTimeout(timeout);
		clientHttpRequestFactory.setConnectTimeout(timeout);
		clientHttpRequestFactory.setConnectionRequestTimeout(timeout);
		return clientHttpRequestFactory;
	}
}
