package com.skanda.util.client;

import com.skanda.util.entity.TrainSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Component
public class TrainServiceClient {

    @Autowired
    public RestTemplate restTemplate;

    private static final String TRAIN_URI = "http://localhost:8080/internal/train/";

    public TrainSummary fetchTrainSummary(Long trainId) {
        ResponseEntity<TrainSummary> trainSummaryResponseEntity =
                restTemplate.getForEntity(
                        TRAIN_URI + trainId,
                        TrainSummary.class);
        return trainSummaryResponseEntity.getBody();
    }
}
