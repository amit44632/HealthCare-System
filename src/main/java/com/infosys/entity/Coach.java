package com.infosys.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Coach {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer coach_id;
	
	
	private String name;
	
	private String gender;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate date_of_birth;
	
	
	private String password;
	
	private Long mobile_number;
	
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
		return "Coach [coach_id=" + coach_id + ", name=" + name + ", gender=" + gender + ", date_of_birth="
				+ date_of_birth + ", password=" + password + ", mobile_number=" + mobile_number + ", speciality="
				+ speciality + "]";
	}
	
}
