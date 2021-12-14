package com.minmfa.apisuite.service;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.minmfa.apisuite.dto.MfaUserDTO;
import com.minmfa.apisuite.utils.ClientRequestUtils;

public final class OnboardingMfaUser {

	private OnboardingMfaUser() {

	}

	private static void onboardMfaUser(String clientKey, String clientSecret) {
		RestTemplate restTemplate = new RestTemplate(ClientRequestUtils.getClientHttpRequestFactory());

		String accessToken = Base64.getEncoder().encodeToString((clientKey + ":" + clientSecret).getBytes());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Basic " + accessToken);

		Map<String, String> params = new HashMap<>();
		params.put("firstName", "FIRST_NAME");
		params.put("lastName", "LAST_NAME");
		params.put("middleName", "MIDDLE_NAME");
		params.put("username", "USER_NAME");
		params.put("email", "EMAIL");
		params.put("mobileNumber", "MOBILE_NUMBER");
		HttpEntity<Map<String, String>> entity = new HttpEntity<>(params, headers);
		restTemplate.exchange("https://dev.minaws.com/api/minmfa/v1/mfauser", HttpMethod.POST, entity,
				MfaUserDTO.class);
	}
}
