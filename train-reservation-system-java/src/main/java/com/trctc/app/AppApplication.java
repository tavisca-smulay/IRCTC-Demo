package com.trctc.app;

import com.trctc.app.model.*;
import com.trctc.app.model.forms.TrainForm;
import com.trctc.app.repository.TrainRepository;
import com.trctc.app.repository.UserRepository;
import com.trctc.app.service.AvailabilityService;
import com.trctc.app.service.SearchService;
import com.trctc.app.service.TrainService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Bean
	public CommandLineRunner runDemo(UserRepository userRepository,AvailabilityService availabilityService, TrainService trainService, TrainRepository trainRepository, SearchService searchService) {
		return (args -> {

//			List<String> stationList=new ArrayList<>();
//			stationList.add("a");stationList.add("b");stationList.add("c");
//
//			List<String> timeList=new ArrayList<>();
//			timeList.add("10:00");timeList.add("b");timeList.add("c");
//
//			List<String> stationList1=new ArrayList<>();
//			stationList1.add("a");stationList1.add("b");stationList1.add("c"); stationList1.add("d");
//
//			TrainForm trainForm=new TrainForm(12,"abc",stationList,timeList,20);
//			TrainForm trainForm1=new TrainForm(13,"def",stationList1,timeList,30);
//
//			trainService.addTrain(trainForm);
//			trainService.addTrain(trainForm1);
////
////		//	trainService.addTrain(trainForm1);
////
//
//			System.out.println(availabilityService.checkAvailability(13,"23-09-1996","a","d",stationList1,30));
//			availabilityService.decreaseAvailability(13,"23-09-1996","a","d",3);
//			System.out.println(availabilityService.checkAvailability(13,"23-09-1996","a","d",stationList1,30));
//			availabilityService.increaseAvailability(13,"23-09-1996","b","d",3);
//			System.out.println(availabilityService.checkAvailability(13,"23-09-1996","b","d",stationList1,30));
//			System.out.println(availabilityService.checkAvailability(13,"23-09-1996","a","b",stationList1,30));
//

//			Set<Passenger> passengers=new HashSet<>();
//			Passenger p=new Passenger("a",12, Gender.FEMALE);
//			Passenger p1=new Passenger("b",20,Gender.MALE);
//			passengers.add(p);
//			passengers.add(p1);
//			userRepository.save(new User("abc","123","abc",new Booking(12,"a","b",BookingStatus.CONFIRMED,passengers),new Booking(13,"x","y",BookingStatus.RAC,passengers)));
			userRepository.save(new User("abc","123","abc"));

	//		userRepository.save(new User("xyz","123","abc",new Booking(12,"a","b",BookingStatus.CONFIRMED,passengers)));


//			Set<Booking> bookings = userRepository.findByUserName("abc").get().getBookings();
//			for (Booking booking :
//					bookings) {
//				System.out.println(booking.getPassengers());
//				System.out.println(booking.getTrainId());
//				System.out.println(booking.getDestinationStation());
//			}
//			User user=userRepository.findByUserName("abc").get();
//			user.addBooking(new Booking(100,"a","b",BookingStatus.CONFIRMED,passengers));
//			userRepository.save(user);
		});
	}
}
