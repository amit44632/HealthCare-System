package com.infosys.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.infosys.dto.BookingDto;
import com.infosys.entity.Booking;
import com.infosys.entity.Coach;
import com.infosys.exception.ResourceNotFoundException;
import com.infosys.repository.BookingRepository;

@Service
public class BookingTableService {

	@Autowired
	private BookingRepository bookingrepository;
	
	public Object booking_Appointment(BookingDto bookingdto) {
		
		Booking book= new Booking();
		
		book.setCoach_id(bookingdto.getCoach_id());
		book.setUser_id(bookingdto.getUser_id());
		book.setAppointment_date(LocalDate.from(bookingdto.getAppointment_date()));
		book.setSlot(bookingdto.getSlot());
		book.setBooking_id(bookingdto.getBooking_id());
		
		bookingrepository.save(book);
		
		return "The Appointment is confirmed on :"+book.getAppointment_date()+" at slot :"+book.getSlot()+"";
	}

	public Object viewUpcomingSchedule(Integer id) {
		
	  Optional<Booking> book=bookingrepository.findByCoachId(id);
	  if(book.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Upcoming Schedule not found.");
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(book.toString());
	  }
	  
		
	}

	public Object booking_appointment(BookingDto bookingDto) {
		
		Booking appointment=new Booking();
		
		appointment.setBooking_id(bookingDto.getBooking_id());
		appointment.setCoach_id(bookingDto.getCoach_id());
		appointment.setUser_id(bookingDto.getUser_id());
		appointment.setAppointment_date(LocalDate.from(bookingDto.getAppointment_date()));
		appointment.setSlot(bookingDto.getSlot());
		
		bookingrepository.save(appointment);
		
		return "The Appointment is confirmed on :"+appointment.getAppointment_date()+" at slot :"+appointment.getSlot()+"";
	}

	public Object viewUpcomingAppointment(Integer id) {
		  List<Booking> book=bookingrepository.findByUserId(id);
		  System.out.println("The size of upcoming schedule for user==="+book.size());
		  if(book.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Upcoming Schedule not found.");
			}else {
				return ResponseEntity.status(HttpStatus.OK).body(book.toString());
		  }
		
	}

	public Object reschedule_appointment(BookingDto bookingDto, Integer user_id) throws ResourceNotFoundException {
      
		Booking book= bookingrepository.findById(user_id)
				.orElseThrow(() -> new ResourceNotFoundException("Appointment couldnot be rescheduled"));


		book.setBooking_id(bookingDto.getBooking_id());
		book.setCoach_id(bookingDto.getCoach_id());
		book.setUser_id(bookingDto.getUser_id());
		book.setAppointment_date(LocalDate.from(bookingDto.getAppointment_date()));
		book.setSlot(bookingDto.getSlot());
		
		bookingrepository.save(book);
		
		return "The Appointment is resheduled and confirmed on :"+book.getAppointment_date()+" at slot :"+book.getSlot()+"";
	}


		
	public Object cancelledAppointment(String user_id, String coach_id) {
		List<Booking> op=bookingrepository.deleteByUserIdAndCoachId(user_id,coach_id);
		
		System.out.println("The size of op==="+op.size());
		if(op.size()>0) {
			bookingrepository.deleteById(op.get(0).getBooking_id());
			return ResponseEntity.status(HttpStatus.OK).body("Appointment cancelled successfully");
		}else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Data Not Found  given UserId and CoachId");
		}
	}

}
