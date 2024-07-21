package com.infosys.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.infosys.dto.UserDto;
import com.infosys.entity.Coach;
import com.infosys.entity.HCUser;
import com.infosys.repository.UserRepository;

@Service
public class UserServiceImpl {

	@Autowired
    private UserRepository userrepository;
	


	public Object createUser(UserDto userdto) {
		
		HCUser user= new HCUser();
		
		user.setUser_id(userdto.getUser_id());
		user.setName(userdto.getName());
		user.setGender(userdto.getGender());
		user.setCity(userdto.getCity());
		user.setCountry(userdto.getCountry());
		user.setDate_of_birth(LocalDate.from(userdto.getDate_of_birth()));
		user.setEmail(userdto.getEmail());
		user.setMobile_number(userdto.getMobile_number());
		user.setPassword(userdto.getPassword());
		user.setPincode(userdto.getPincode());
		user.setState(userdto.getState());
		
		userrepository.save(user);
		
		
		return "User Created Successfully with id:"+user.getUser_id()+"";
	}



	public ResponseEntity<String> loginforUser(String name, String password) {
		System.out.println("name in service==="+name+"  password===="+password);
		List<HCUser> op=userrepository.findByUserNameAndPassword(name,password);
			
		if(op.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("user not found");
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(op.get(0).toString());
		}
		
	}



	public Object view_Profile_for_user(Integer Id) {
		
		Optional<HCUser> op=userrepository.findById(Id);
		
		if(op.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("user not found with given id:"+Id);
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(op.toString());
		}
	}



	
	
	
}
