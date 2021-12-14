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

public final class ValidateAppOtp {

	private ValidateAppOtp() {

	}

	private static void validateAppOtp(String clientKey, String clientSecret) {
		RestTemplate restTemplate = new RestTemplate(ClientRequestUtils.getClientHttpRequestFactory());

		String accessToken = Base64.getEncoder().encodeToString((clientKey + ":" + clientSecret).getBytes());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Basic " + accessToken);

		Map<String, String> params = new HashMap<>();
		params.put("passcode", "PASSCODE"); // mandatory value enter the code displayed in min app
		params.put("username", "USERNAME"); // mandatory value
		HttpEntity<Map<String, String>> entity = new HttpEntity<>(params, headers);
		restTemplate.exchange("https://dev.minaws.com/api/minmfa/v1/validate/app/otp", HttpMethod.POST, entity,
				Map.class);
	}
}
