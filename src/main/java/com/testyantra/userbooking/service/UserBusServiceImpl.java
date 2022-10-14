package com.testyantra.userbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.testyantra.userbooking.constants.UserBusConstants;
import com.testyantra.userbooking.dto.UserBusDto;
import com.testyantra.userbooking.repository.UserBusRepository;
import com.testyantra.userbooking.request.UserBusRequest;
import com.testyantra.userbooking.response.UserBusResponse;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Component
public class UserBusServiceImpl implements UserBusService {
	@Autowired
	UserBusRepository userBusRepository;

	@Override
	public UserBusResponse addUser(UserBusRequest busRequest) {
		String methodName = "addUser";
		log.info("Inside the method" + methodName);
		try {
			if (busRequest != null) {
				UserBusRequest userBusRequest=new UserBusRequest();
				userBusRequest.setBookingId(busRequest.getBookingId());
				userBusRequest.setAddress(busRequest.getAddress());
				userBusRequest.setContactNo(busRequest.getContactNo());
				userBusRequest.setEmail(busRequest.getEmail());
				userBusRequest.setName(busRequest.getName());
				UserBusRequest save = userBusRepository.save(userBusRequest);
				if (save!= null) {
					return UserBusResponse.builder().statusCode(UserBusConstants.SUCESS_STATUS_CODE)
							.statusDesc(UserBusConstants.SUCESS_STATUS_DESC).message(UserBusConstants.USER_ADDED_MSG)
							.build();
				}
			}

		} catch (Exception e) {
			log.error("Exception occured while performing an operation" + methodName);
		}
		return UserBusResponse.builder().statusCode(UserBusConstants.FAIL_STATUS_CODE)
				.statusDesc(UserBusConstants.FAIL_STATUS_DESC).build();
	}

}
