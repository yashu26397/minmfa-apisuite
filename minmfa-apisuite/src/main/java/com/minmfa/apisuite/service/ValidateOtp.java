package com.minmfa.apisuite.service;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.minmfa.apisuite.utils.ClientRequestUtils;

public final class ValidateOtp {

	private ValidateOtp() {

	}

	private static void validateOtp(String clientKey, String clientSecret) {
		RestTemplate restTemplate = new RestTemplate(ClientRequestUtils.getClientHttpRequestFactory());

		String accessToken = Base64.getEncoder().encodeToString((clientKey + ":" + clientSecret).getBytes());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Basic " + accessToken);

		Map<String, String> params = new HashMap<>();
		params.put("passcode", "PASSCODE"); // mandatory value pass the code received through email, sms or phonecall
		params.put("trackingId", "TRACKING_ID"); // mandatory value
		HttpEntity<Map<String, String>> entity = new HttpEntity<>(params, headers);
		restTemplate.exchange("https://dev.minaws.com/api/minmfa/v1/validate/otp", HttpMethod.POST, entity, Map.class);
	}
}
