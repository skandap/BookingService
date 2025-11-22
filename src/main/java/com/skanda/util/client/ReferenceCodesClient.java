package com.skanda.util.client;

import com.skanda.createBooking.behaviours.CodeTypeNotFoundException;
import com.skanda.util.entity.ReferenceCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ReferenceCodesClient {

    @Autowired
    public RestTemplate restTemplate;

    private static final String URI = "http://localhost:8084/reference-codes/code/";

    public ReferenceCodes fetchRefCodes(String code) {
        try {
            ResponseEntity<List<ReferenceCodes>> response = restTemplate.exchange(
                    URI + code,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<ReferenceCodes>>() {
                    }
            );

            List<ReferenceCodes> codes = response.getBody();
            if (codes == null || codes.isEmpty()) {
                throw new CodeTypeNotFoundException("Invalid code: " + code);
            }

            return codes.getFirst();

        } catch (Exception e) {
            throw new CodeTypeNotFoundException("Invalid code :" + code);

        }
    }

}
