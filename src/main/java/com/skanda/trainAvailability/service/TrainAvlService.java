package com.skanda.trainAvailability.service;

import com.skanda.trainAvailability.entity.TrainAvlResponse;

public interface TrainAvlService {
    TrainAvlResponse trainAvlCheck(Long trainId);
}
