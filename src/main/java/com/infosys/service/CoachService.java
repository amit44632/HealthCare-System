package com.infosys.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.infosys.dto.CoachDto;
import com.infosys.entity.Coach;
import com.infosys.exception.WecareException;
import com.infosys.repository.CoachRepository;

@Service
@PropertySource(value = { "classpath:ValidationMessage.properties" })
public class CoachService {

	@Autowired
	private CoachRepository coach_repository;
	
	@Autowired
	private Environment environment;
	
	public Object createcoach(CoachDto coachdto) {
		
		Coach coach= new Coach();
		
		coach.setCoach_id(coachdto.getCoach_id());
		coach.setName(coachdto.getName());
		coach.setDate_of_birth(LocalDate.from(coachdto.getDate_of_birth()));
		coach.setGender(coachdto.getGender());
		coach.setMobile_number(coachdto.getMobile_number());
		coach.setPassword(coachdto.getPassword());
		coach.setSpeciality(coachdto.getSpeciality());
		
		coach_repository.save(coach);
		
		return "Coach Created with Id :"+coach.getCoach_id()+"";
	}

	public ResponseEntity<String> loginforCoach(String name, String password) throws WecareException {
		
		System.out.println("name in service==="+name+"  password===="+password);
	List<Coach> op=coach_repository.findByNameAndPassword(name,password);
		
	if(op.isEmpty()) {
		throw new WecareException(environment.getProperty("coach.not.found"));
	//	return ResponseEntity.status(HttpStatus.NO_CONTENT).body("user not found");
	}else {
		return ResponseEntity.status(HttpStatus.OK).body(op.get(0).toString());
	}
		
	}

	public ResponseEntity<String> view_User_for_coach(Integer Id) {
		// TODO Auto-generated method stub
		System.out.println("in optional id===="+Id);
		Optional<Coach> op=coach_repository.findById(Id);
		if(op.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("user not found with given id:"+Id);
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(op.toString());
		}
	}

	public Object ViewAllLifeCoaches() {
		List<Coach> op=coach_repository.findAll();
		//System.out.println("Coach size at available-------------"+op.size());
		if(op.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Life coaches not found ");
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(op.toString());
		}
	}

}
