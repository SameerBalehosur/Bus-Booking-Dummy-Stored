package com.testyantra.userbooking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testyantra.userbooking.dto.UserBusDto;
import com.testyantra.userbooking.response.UserBusResponse;
import com.testyantra.userbooking.service.UserBusService;

@RestController
@RequestMapping(path = "/user/busbooking/v1")
public class UserController {
	
	@Autowired
	UserBusService userBusService;
	
	@PostMapping("/addUser")
	public ResponseEntity<UserBusResponse> addUser(@RequestBody UserBusDto busRequest) {
		UserBusResponse addUser = userBusService.addUser(busRequest);
		return new ResponseEntity<UserBusResponse>(addUser,HttpStatus.OK)  ;
	}
	
	@PostMapping("/update")
	public UserBusResponse updateUserData(@RequestBody UserBusDto busRequest) {
		return userBusService.updateuser(busRequest);
	}
	
	@GetMapping("/getAllUsers")
	public UserBusResponse getAllUsers() {
		return userBusService.getAllUsers();
	}
	
	@PostMapping("/deleteUser")
	public UserBusResponse deleteUser(@RequestBody UserBusDto busRequest) {
		return userBusService.deleteUser(busRequest);
	}

}
