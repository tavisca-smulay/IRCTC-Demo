package com.trctc.app.controller;

import com.trctc.app.model.Booking;
import com.trctc.app.model.forms.BookingForm;
import com.trctc.app.service.AvailabilityService;
import com.trctc.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.UsesSunMisc;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    AvailabilityService availabilityService;

    @Autowired
    UserService userService;

    @PostMapping("/book")
    public ResponseEntity<?> addBooking(@RequestBody BookingForm bookingForm){
        if(userService.addBooking(bookingForm)){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

//    @DeleteMapping("/cancel/user/{userId}/booking/{bookingId}")
//    public ResponseEntity<?> cancelBooking(@PathVariable int userId,@PathVariable int bookingId){
//        if(userService.addBooking(bookingForm)){
//            return new ResponseEntity<>(HttpStatus.CREATED);
//        }
//        else{
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }


}
