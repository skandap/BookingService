package com.skanda.util.client;

import com.skanda.util.entity.UserSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Component
public class UserServiceClient {

    @Autowired
    private RestTemplate restTemplate;

    private static final String INTERNAL_SECRET = "edgeverve-internal-key";
    private static final String USER_SERVICE_URL = "http://localhost:8081/internal/users/";

    public UserSummary fetchUser(Long userId) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-INTERNAL-SECRET", INTERNAL_SECRET);

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<UserSummary> response = restTemplate.exchange(
                USER_SERVICE_URL + userId,
                HttpMethod.GET,
                entity,
                UserSummary.class
        );
        return response.getBody();
    }
}
