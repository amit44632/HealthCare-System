package com.infosys.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

public class UserDto {

	private	Integer user_id;
	
	@NotEmpty(message = "Please enter name")
	@Size(min=3, max=50)
	private	String name;

	@NotEmpty(message = "Gender cannot be empty")
	private	String gender;
	
	@javax.validation.constraints.NotNull(message="Date cannot be null")
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate date_of_birth;

	@NotBlank(message="Password Shouldn't be Null.")
	@Size(min=5, max=10)
	private String password;

	@javax.validation.constraints.NotNull(message = "Please enter mobile number")
	private Long mobile_number;
	
    @Email
	private String email;
    
    @NotNull(message = "The Pincode field must not be blank.")
	private Integer pincode;

	@NotEmpty(message = "City cannot be empty")
	@Size(min=3, max=20)
	private String city;

	@NotEmpty(message = "State cannot be empty")
	@Size(min=3, max=20)
	private String state;

	@NotEmpty(message = "Country cannot be empty")
	@Size(min=3, max=20)
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
		return "UserDto [user_id=" + user_id + ", name=" + name + ", gender=" + gender + ", date_of_birth="
				+ date_of_birth + ", password=" + password + ", mobile_number=" + mobile_number + ", email=" + email
				+ ", pincode=" + pincode + ", city=" + city + ", state=" + state + ", country=" + country + "]";
	}
	
	
}
