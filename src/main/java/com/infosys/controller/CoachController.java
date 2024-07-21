package com.infosys.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.dto.CoachDto;
import com.infosys.exception.WecareException;
import com.infosys.repository.BookingRepository;
import com.infosys.service.BookingTableService;
import com.infosys.service.CoachService;

@RestController
@RequestMapping("/Coach")
//@Validated
public class CoachController {

	@Autowired
	private CoachService coachservice;
	
	@Autowired
	private BookingTableService bookingtableservice;
	
//	@GetMapping("/")
//	public String hello() {
//		System.out.println("Hello World");
//		return "Coach";
//	}
	
	
	@PostMapping("/signUpCoach")
	public ResponseEntity<Object> createCoach(@Valid @RequestBody CoachDto coachdto) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(coachservice.createcoach(coachdto));
		
	}
	
	@GetMapping("/loginforCoach")
    public ResponseEntity<Object> loginforCoach(@RequestParam(value="name") String name, @RequestParam(value="password") String password ) throws WecareException {
		System.out.println("name==="+name+"-----------"+password);
		
		return ResponseEntity.status(HttpStatus.OK).body(coachservice.loginforCoach(name,password));
	}
	
	@GetMapping("/view_profile/{Id}")
	 public ResponseEntity<Object> view_User_for_coach(@PathVariable(value="Id") Integer Id) {
		System.out.println("id================"+Id);
		
		return ResponseEntity.status(HttpStatus.OK).body(coachservice.view_User_for_coach(Id));
	}
	
	@GetMapping("/viewUpcomingScheduleCoach/{Id}")
	 public ResponseEntity<Object> viewUpcomingSchedule(@PathVariable(value="Id") Integer Id) {
		System.out.println("id================"+Id);
		
		return ResponseEntity.status(HttpStatus.OK).body(bookingtableservice.viewUpcomingSchedule(Id));
	}
}
