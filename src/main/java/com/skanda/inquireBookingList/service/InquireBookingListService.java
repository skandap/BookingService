package com.skanda.inquireBookingList.service;

import com.skanda.inquireBookingList.entity.InquireBookingListResponse;

import java.util.List;

public interface InquireBookingListService {
    List<InquireBookingListResponse> fetchBookingList();
}
