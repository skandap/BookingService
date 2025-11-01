package com.skanda.trainAvailability.service;

import com.skanda.trainAvailability.entity.TrainAvlResponse;
import com.skanda.util.client.TrainServiceClient;
import com.skanda.util.entity.BookingEntity;
import com.skanda.util.entity.TrainSummary;
import com.skanda.util.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TrainAvlServiceImpl implements TrainAvlService {

    @Autowired
    public BookingRepository bookingRepository;

    @Autowired
    public TrainServiceClient trainServiceClient;

    @Override
    public TrainAvlResponse trainAvlCheck(Long trainId) {
//        List<BookingEntity> entity = bookingRepository.findAllByTrainId(trainId);
        TrainSummary trainSummary = trainServiceClient.fetchTrainSummary(trainId);
        return mapToResponse(trainSummary);
    }

    public TrainAvlResponse mapToResponse(TrainSummary trainSummary) {
        return TrainAvlResponse.builder()
                .trainId(trainSummary.getTrainId())
                .trainNumber(trainSummary.getTrainNumber())
                .trainName(trainSummary.getTrainName())
                .sourceStation(trainSummary.getSourceStation())
                .destinationStation(trainSummary.getDestinationStation())
                .travelDate(LocalDate.now())
                .totalSeats(500) //from trainservice
                .bookedSeats(400) //from booking entity for particular train take total sum of booked seats
                .availableSeats(100) //bussiness logic totalseats-bookedseats
                .status("Available") //bussines logic
                .lastUpdated(LocalDateTime.now()) //fetch from train
                .build();
    }
}
