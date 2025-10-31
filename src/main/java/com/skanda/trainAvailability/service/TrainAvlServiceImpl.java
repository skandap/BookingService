package com.skanda.trainAvailability.service;

import com.skanda.trainAvailability.entity.TrainAvlResponse;
import com.skanda.util.client.TrainServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainAvlServiceImpl implements TrainAvlService{



    @Autowired
    public TrainServiceClient trainServiceClient;

    @Override
    public TrainAvlResponse trainAvlCheck(String trainId) {
        return null;
    }
}
