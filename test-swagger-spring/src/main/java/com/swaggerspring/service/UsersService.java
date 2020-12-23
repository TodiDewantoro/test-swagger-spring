package com.swaggerspring.service;

import java.util.List;

import com.swaggerspring.dto.UsersDto;
import com.swaggerspring.entity.UsersEntity;

public interface UsersService {
	
	List<UsersEntity> getAllUsers();

	UsersEntity getDetailUsers(String kodeLeads);

	UsersEntity post(UsersDto dto);
	
	UsersEntity delete( String kodeLeads);

	UsersEntity put(String kodeLeads, UsersDto dto);
}
