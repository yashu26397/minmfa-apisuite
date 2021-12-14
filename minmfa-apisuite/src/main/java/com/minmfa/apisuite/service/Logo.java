package com.minmfa.apisuite.service;

import java.util.Base64;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.minmfa.apisuite.utils.ClientRequestUtils;

public final class Logo {

	private Logo() {
	}

	private static void getOrganizationLogo(String clientKey, String clientSecret) {
		RestTemplate restTemplate = new RestTemplate(ClientRequestUtils.getClientHttpRequestFactory());

		String accessToken = Base64.getEncoder().encodeToString((clientKey + ":" + clientSecret).getBytes());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Basic " + accessToken);

		HttpEntity<String> entity = new HttpEntity<>(null, headers);
		restTemplate.exchange("https://dev.minaws.com/api/minmfa/v1/logo", HttpMethod.GET, entity, String.class);
	}
}
