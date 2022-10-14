package com.testyantra.userbooking.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.testyantra.userbooking.dto.UserBusDto;

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
public class UserBusRequest {
	private UserBusDto userBusDto;
}
