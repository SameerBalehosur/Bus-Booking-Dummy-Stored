package com.testyantra.userbooking.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(value = Include.NON_DEFAULT)
@Component
@Entity
public class UserBusDto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int bookingId;
	String name;
	String email;
	String address;
	long contactNo;

}
