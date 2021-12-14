package com.minmfa.apisuite.service;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.minmfa.apisuite.dto.MfaOption;
import com.minmfa.apisuite.utils.ClientRequestUtils;

public final class TriggerMfa {

	private TriggerMfa() {

	}

	private static void triggerMfa(String clientKey, String clientSecret) {
		RestTemplate restTemplate = new RestTemplate(ClientRequestUtils.getClientHttpRequestFactory());

		String accessToken = Base64.getEncoder().encodeToString((clientKey + ":" + clientSecret).getBytes());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Basic " + accessToken);

		Map<String, String> params = new HashMap<>();
		params.put("username", "USER_NAME"); // mandatory value
		params.put("mfaOption", MfaOption.SMS.name()); // choose any one option and mandatory
		params.put("ipAddress", "IP_ADDRESS"); // Optional
		params.put("deviceId", "DEVICE_ID"); // Optional
		HttpEntity<Map<String, String>> entity = new HttpEntity<>(params, headers);
		restTemplate.exchange("https://dev.minaws.com/api/minmfa/v1/trigger/mfa", HttpMethod.POST, entity, List.class);
	}
}
