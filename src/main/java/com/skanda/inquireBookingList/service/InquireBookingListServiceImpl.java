package com.skanda.inquireBookingList.service;

import com.skanda.inquireBookingList.entity.InquireBookingListResponse;
import com.skanda.util.client.ReferenceCodesClient;
import com.skanda.util.client.TrainServiceClient;
import com.skanda.util.client.UserServiceClient;
import com.skanda.util.entity.BookingEntity;
import com.skanda.util.entity.ReferenceCodes;
import com.skanda.util.entity.TrainSummary;
import com.skanda.util.entity.UserSummary;
import com.skanda.util.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class InquireBookingListServiceImpl implements InquireBookingListService {

    @Autowired
    public BookingRepository bookingRepository;
    @Autowired
    public UserServiceClient userServiceClient;

    @Autowired
    public TrainServiceClient trainServiceClient;

    @Autowired
    public ReferenceCodesClient referenceCodesClient;

    @Override
    public List<InquireBookingListResponse> fetchBookingList() {
        List<BookingEntity> bookingEntity = bookingRepository.findAll();
        return mapToResponse(bookingEntity);
    }

    public List<InquireBookingListResponse> mapToResponse(List<BookingEntity> bookingEntity) {
        List<InquireBookingListResponse> inquireBookingListResponses = new ArrayList<>();
        for (BookingEntity e : bookingEntity) {
            UserSummary userSummary = userServiceClient.fetchUser(e.getUserId());
            TrainSummary trainSummary = trainServiceClient.fetchTrainSummary(e.getTrainId());
            ReferenceCodes bookingStatus= referenceCodesClient.fetchRefCodes(e.getBookingStatus());
            ReferenceCodes paymentMode= referenceCodesClient.fetchRefCodes(e.getPaymentMode());
            ReferenceCodes classType= referenceCodesClient.fetchRefCodes(e.getClassType());
            InquireBookingListResponse response = new InquireBookingListResponse();
            response.setBookingId(e.getBookingId());
            response.setUser(userSummary);
            response.setTrain(trainSummary);
            response.setTravelDate(e.getTravelDate());
            response.setNumberOfSeats(e.getNumberOfSeats());
            response.setTotalFare(e.getTotalFare());
            response.setPaymentMode(paymentMode);
            response.setBookingStatus(bookingStatus);
            response.setClassType(classType);
            response.setCreatedAt(LocalDateTime.now());
            inquireBookingListResponses.add(response);
        }
        return inquireBookingListResponses;
    }
}
