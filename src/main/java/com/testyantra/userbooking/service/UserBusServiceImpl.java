package com.testyantra.userbooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.testyantra.userbooking.constants.UserBusConstants;
import com.testyantra.userbooking.dto.UserBusDto;
import com.testyantra.userbooking.repository.UserBusRepository;
import com.testyantra.userbooking.response.UserBusResponse;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Component
public class UserBusServiceImpl implements UserBusService {
	@Autowired
	UserBusRepository userBusRepository;

	@Override
	public UserBusResponse addUser(UserBusDto busRequest) {
		String methodName = "addUser";
		log.info("Inside the method" + methodName);
		try {
			if (busRequest != null) {
				UserBusDto save = userBusRepository.save(busRequest);
				if (save != null) {
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

	@Override
	public UserBusResponse updateuser(UserBusDto busRequest) {
		String methodName = "updateuser";
		log.info("Inside the method" + methodName);
		try {
			if (busRequest != null) {
				Optional<UserBusDto> findById = userBusRepository.findById(busRequest.getBookingId());
				UserBusDto userBusDto = new UserBusDto();
				userBusDto.setContactNo(busRequest.getContactNo());
				userBusDto.setEmail(busRequest.getEmail());
				if (findById.isPresent()) {
					userBusDto = userBusRepository.save(userBusDto);
				}

				if (userBusDto != null) {
					return UserBusResponse.builder().statusCode(UserBusConstants.SUCESS_STATUS_CODE)
							.statusDesc(UserBusConstants.SUCESS_STATUS_DESC).message(UserBusConstants.USER_UPDATED_MSG)
							.build();
				}
			}

		} catch (Exception e) {
			log.error("Exception occured while performing an operation" + methodName);
		}
		return UserBusResponse.builder().statusCode(UserBusConstants.FAIL_STATUS_CODE)
				.statusDesc(UserBusConstants.FAIL_STATUS_DESC).build();
	}

	@Override
	public UserBusResponse getAllUsers() {
		String methodName = "getAllUsers";
		log.info("Inside the method" + methodName);
		try {
			List<UserBusDto> findAll = userBusRepository.findAll();

			if (findAll != null) {
				return UserBusResponse.builder().statusCode(UserBusConstants.SUCESS_STATUS_CODE)
						.statusDesc(UserBusConstants.SUCESS_STATUS_DESC).listOfUsers(findAll).build();
			}

		} catch (Exception e) {
			log.error("Exception occured while performing an operation" + methodName);
		}
		return UserBusResponse.builder().statusCode(UserBusConstants.FAIL_STATUS_CODE)
				.statusDesc(UserBusConstants.FAIL_STATUS_DESC).build();
	}

	@Override
	public UserBusResponse deleteUser(UserBusDto busRequest) {
		String methodName = "deleteUser";
		log.info("Inside the method" + methodName);
		try {
			if (busRequest != null) {
				userBusRepository.delete(busRequest);
				return UserBusResponse.builder().statusCode(UserBusConstants.SUCESS_STATUS_CODE)
						.statusDesc(UserBusConstants.SUCESS_STATUS_DESC).message(UserBusConstants.USER_DELETED_MSG)
						.build();
			}
		} catch (Exception e) {
			log.error("Exception occured while performing an operation" + methodName);
		}
		return UserBusResponse.builder().statusCode(UserBusConstants.FAIL_STATUS_CODE)
				.statusDesc(UserBusConstants.FAIL_STATUS_DESC).build();

	}

}
