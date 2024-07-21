package com.infosys.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class HCUser {

	@Id	
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private	Integer user_id;

	private	String name;

	private	String gender;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate date_of_birth;

	private String password;

	private Long mobile_number;

	private String email;

	private Integer pincode;

	private String city;

	private String state;

	private String country;

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + ", gender=" + gender + ", date_of_birth=" + date_of_birth
				+ ", password=" + password + ", mobile_number=" + mobile_number + ", email=" + email + ", pincode="
				+ pincode + ", city=" + city + ", state=" + state + ", country=" + country + "]";
	}
		

}
