package com.testyantra.userbooking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testyantra.userbooking.request.UserBusRequest;
import com.testyantra.userbooking.response.UserBusResponse;
import com.testyantra.userbooking.service.UserBusService;

@RestController
@RequestMapping(path = "/user/bus-booking/v1")
public class UserController {
	
	@Autowired
	UserBusService userBusService;
	
	
	@PostMapping("/addUser")
	public UserBusResponse addUser(@RequestBody UserBusRequest busRequest) {
		return userBusService.addUser(busRequest);
	}

}
