package com.testyantra.userbooking.service;

import org.springframework.stereotype.Component;

import com.testyantra.userbooking.request.UserBusRequest;
import com.testyantra.userbooking.response.UserBusResponse;
@Component
public interface UserBusService {
public UserBusResponse addUser(UserBusRequest busRequest);
}
