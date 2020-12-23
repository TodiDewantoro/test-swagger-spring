package com.swaggerspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swaggerspring.dto.UsersDto;
import com.swaggerspring.entity.UsersEntity;
import com.swaggerspring.repository.UsersRepository;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

	@Autowired
	UsersRepository usersRepository;

	@Override
	public List<UsersEntity> getAllUsers() {
		List<UsersEntity> users = usersRepository.findAllActive();
        return users;
	}

	@Override
	public UsersEntity getDetailUsers(String kodeLeads) {
		UsersEntity user = usersRepository.findByKodeLeadsIgnoreCase(kodeLeads);
		if (user == null) {
			user = null;
            return user;
        }
        return user;
	}

	@Override
	public UsersEntity post(UsersDto dto) {
		UsersEntity user = new UsersEntity();
		user.setFirstName(dto.getFirstName());
		user.setActive(true);
		user.setLastName(dto.getLastName());
		user.setKodeLeads(dto.getKodeLeads());
		usersRepository.save(user);
        return user;
	}

	
	@Override
	public UsersEntity put(String kodeLeads, UsersDto dto) {
		UsersEntity user = usersRepository.findByKodeLeadsIgnoreCase(kodeLeads);
		
		if (user == null) {
			user = null;
            return user;
        }
		
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setKodeLeads(dto.getKodeLeads());
		usersRepository.save(user);
        return user;
	}

	@Override
	public UsersEntity delete(String kodeLeads) {
		UsersEntity user = usersRepository.findByKodeLeadsIgnoreCase(kodeLeads);
		
		if (user == null) {
			user = null;
            return user;
        }

		user.setActive(false);
		usersRepository.save(user);
        
		return user;
	}

	
	
	
	
}
