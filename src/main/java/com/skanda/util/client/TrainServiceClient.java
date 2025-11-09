package com.skanda.util.client;

import com.skanda.trainAvailability.behaviour.TrainBookingNotFoundEx;
import com.skanda.util.entity.TrainSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class TrainServiceClient {

    @Autowired
    private RestTemplate restTemplate;

    private static final String TRAIN_URI = "http://localhost:8080/internal/train/";

    public TrainSummary fetchTrainSummary(Long trainId) {
        try {
            ResponseEntity<TrainSummary> response =
                    restTemplate.getForEntity(TRAIN_URI + trainId, TrainSummary.class);

            return response.getBody();

        } catch (HttpClientErrorException.NotFound ex) {
            throw new TrainBookingNotFoundEx("Train not found for ID: " + trainId);
        } catch (Exception ex) {
            throw new TrainBookingNotFoundEx("Error fetching train details for ID: " + trainId );
        }
    }
}
