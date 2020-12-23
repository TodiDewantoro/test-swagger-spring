package com.swaggerspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.swaggerspring.entity.UsersEntity;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Integer>{

	UsersEntity findByKodeLeadsIgnoreCase(String kodeLeads);
	
	@Query(value = "SELECT * FROM users_entity WHERE is_active = true", nativeQuery = true)
    List<UsersEntity> findAllActive();
}
