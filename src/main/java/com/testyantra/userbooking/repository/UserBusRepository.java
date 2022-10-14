package com.testyantra.userbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.testyantra.userbooking.dto.UserBusDto;
import com.testyantra.userbooking.response.UserBusResponse;

@Repository
@Component
public interface UserBusRepository extends JpaRepository<UserBusDto, Integer> {
	
//	public void findByBookingId();

}
