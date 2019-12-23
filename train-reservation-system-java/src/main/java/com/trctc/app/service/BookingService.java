package com.trctc.app.service;

import com.trctc.app.model.Train;
import com.trctc.app.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    private void getAllBookings (String userName) {
      //  bookingRepository.
    }
}
