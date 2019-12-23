package com.trctc.app.service;

import com.trctc.app.model.Booking;
import com.trctc.app.model.BookingStatus;
import com.trctc.app.model.User;
import com.trctc.app.model.forms.BookingForm;
import com.trctc.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AvailabilityService availabilityService;

//    public boolean cancelBooking(int userId, int bookingId){
//        if(userRepository.findById(userId).isPresent()){
////            userRepository.findById(userId).get().addBooking(booking);
//
//            availabilityService.decreaseAvailability(bookingForm.getTrainNumber(),
//                    bookingForm.getDate(),
//                    bookingForm.getSource(),
//                    bookingForm.getDestination(),
//                    bookingForm.getNumberOfSeats());
//
//            return true;
//
//        }
//        else{
//            return false;
//        }
//
//    }

    public boolean addBooking(BookingForm bookingForm){
        Booking booking=new Booking(bookingForm.getTrainNumber(),
                bookingForm.getSource(),
                bookingForm.getDestination(),
                BookingStatus.CONFIRMED,bookingForm.getPassengerList());
        if(userRepository.findById(bookingForm.getUserId()).isPresent()){
            userRepository.findById(bookingForm.getUserId()).get().addBooking(booking);

            availabilityService.decreaseAvailability(bookingForm.getTrainNumber(),
                    bookingForm.getDate(),
                    bookingForm.getSource(),
                    bookingForm.getDestination(),
                    bookingForm.getNumberOfSeats());

            return true;

        }
        else{
            return false;
        }

    }



    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(int id){
        return userRepository.findById(id);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

}
