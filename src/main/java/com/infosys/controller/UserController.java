package com.infosys.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.dto.BookingDto;
import com.infosys.dto.UserDto;
import com.infosys.entity.HCUser;
import com.infosys.exception.ResourceNotFoundException;
import com.infosys.repository.UserRepository;
import com.infosys.service.BookingTableService;
import com.infosys.service.CoachService;
import com.infosys.service.UserServiceImpl;

@RestController
@RequestMapping("/User")
public class UserController {


	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private CoachService coachservice;
	
	@Autowired
	private BookingTableService bookingtable_service;
	
	@GetMapping("/")
	public String hello() {
		System.out.println("Hello World");
		return "User";
	}
	
	
	@PostMapping("/signUpUser")
	public ResponseEntity<Object> createUser(@Valid @RequestBody UserDto userdto) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userdto));
		
	}
	
	@GetMapping("/loginforUser")
    public ResponseEntity<Object> loginforUser(@RequestParam(value="name") String name, @RequestParam(value="password") String password ) {
		System.out.println("name==="+name+"-----------"+password);
		
		return ResponseEntity.status(HttpStatus.OK).body(userService.loginforUser(name,password));
	}
	
	@GetMapping("/view_Profile/{Id}")
	 public ResponseEntity<Object> view_Profile_for_user(@PathVariable(value="Id") Integer Id) {
		System.out.println("id================"+Id);
		
		return ResponseEntity.status(HttpStatus.OK).body(userService.view_Profile_for_user(Id));
	}
	
	@GetMapping("ViewAllLifeCoaches")
	 public ResponseEntity<Object> ViewAllLifeCoaches() {
		
		
		return ResponseEntity.status(HttpStatus.OK).body(coachservice.ViewAllLifeCoaches());
	}
	
	@PostMapping("/BookAnAppointment")
      public ResponseEntity<Object> booking_appointment(@RequestBody BookingDto BookingDto) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(bookingtable_service.booking_appointment(BookingDto));
		
	}
	
	@GetMapping("/viewUpcomingAppointment/{Id}")
	 public ResponseEntity<Object> viewUpcomingAppointment(@PathVariable(value="Id") Integer Id) {
		System.out.println("id================"+Id);
		
		return ResponseEntity.status(HttpStatus.OK).body(bookingtable_service.viewUpcomingAppointment(Id));
	}
	
	@PutMapping("/reschedule_appointment/{user_id}")
	  public ResponseEntity<Object> reschedule_appointment(@RequestBody BookingDto BookingDto,@PathVariable(value="user_id") Integer user_id) throws ResourceNotFoundException {
		
			return ResponseEntity.status(HttpStatus.CREATED).body(bookingtable_service.reschedule_appointment(BookingDto,user_id));
			
		}
	@DeleteMapping("/cancelledAppointment")
	 public ResponseEntity<Object> cancelledAppointment(@RequestParam(value="user_id") String user_id, @RequestParam(value="coach_id") String coach_id) {
		
		return ResponseEntity.status(HttpStatus.OK).body(bookingtable_service.cancelledAppointment(user_id,coach_id));
		
	}
	
	
	
//	booking controller api
	
	
//@PostMapping("/appointment")
//	
//	public ResponseEntity<Object> booking_Appointment(@RequestBody BookingDto bookingdto) {
//		
//		return ResponseEntity.status(HttpStatus.CREATED).body(bookingtableservice.booking_Appointment(bookingdto));
//		
//	}
}
