package com.infosys.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;


public class CoachDto {

	
	private Integer coach_id;
	
	@NotEmpty(message = "Please enter name")
	private String name;
	
	@NotEmpty(message = "Gender cannot be empty")
	private String gender;
	
	@javax.validation.constraints.NotNull(message="Date cannot be null")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate date_of_birth;
	
	@NotBlank(message="Password Shouldn't be Null.")
	@Size(min=5, max=10)
	private String password;
	
	@javax.validation.constraints.NotNull(message = "Please enter mobile number")
	private Long mobile_number;
	
	@Length(min=5,max = 10) 
	@NotEmpty(message="Speciality Shouldn't be Null.")
	private String speciality;

	public Integer getCoach_id() {
		return coach_id;
	}

	public void setCoach_id(Integer coach_id) {
		this.coach_id = coach_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(LocalDate date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(Long mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	@Override
	public String toString() {
		return "CoachDto [coach_id=" + coach_id + ", name=" + name + ", gender=" + gender + ", date_of_birth="
				+ date_of_birth + ", password=" + password + ", mobile_number=" + mobile_number + ", speciality="
				+ speciality + "]";
	}
	
	
}
