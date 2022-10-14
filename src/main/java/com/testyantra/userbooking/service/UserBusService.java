package com.testyantra.userbooking.service;

import org.springframework.stereotype.Component;

import com.testyantra.userbooking.dto.UserBusDto;
import com.testyantra.userbooking.response.UserBusResponse;
@Component
public interface UserBusService {
	public UserBusResponse addUser(UserBusDto busRequest);
	public UserBusResponse updateuser(UserBusDto busRequest);
	public UserBusResponse getAllUsers();
	public UserBusResponse deleteUser(UserBusDto busRequest);
}
