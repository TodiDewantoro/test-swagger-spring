package com.swaggerspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swaggerspring.dto.StatusMessageDto;
import com.swaggerspring.dto.UsersDto;
import com.swaggerspring.entity.UsersEntity;
import com.swaggerspring.service.UsersService;

@RestController
@RequestMapping("/api")
public class UsersController {
	
	@Autowired
	private UsersService service;
	
	@SuppressWarnings("rawtypes")
	private StatusMessageDto result = new StatusMessageDto();
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping
	public ResponseEntity<?> getAllUsers(){

		try {
			
			List<UsersEntity> users = service.getAllUsers();
			
				if (users.size() == 0) {
					result.setStatus(HttpStatus.BAD_REQUEST.value());
	                result.setMessage("Data not found");
	                result.setData(null);
	                return ResponseEntity.badRequest().body(result);
				} else {
					result.setStatus(200);
	                result.setMessage("Success");
	                result.setData(users);
	                return ResponseEntity.ok(result);
				}
				
			} catch (Exception e) {
			
			StatusMessageDto error = new StatusMessageDto(500,e.getMessage(), null);
	        return ResponseEntity.status(500).body(error);
				
			}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/{kodeLeads}")
	public ResponseEntity<?> getDetailUsers(@PathVariable String kodeLeads){
		try {
			
			UsersEntity users = service.getDetailUsers(kodeLeads);
			
			if (kodeLeads == null) {
				result.setStatus(HttpStatus.BAD_REQUEST.value());
                result.setMessage("Data not found");
                result.setData(null);
                return ResponseEntity.badRequest().body(result);
			} else {
				result.setStatus(200);
                result.setMessage("Success");
                result.setData(users);
                return ResponseEntity.ok(result);
			}
		} catch (Exception e) {
			
			StatusMessageDto error = new StatusMessageDto(500, e.getMessage(), null);
	        return ResponseEntity.status(500).body(error);
	        
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping
	public ResponseEntity<?> post(@RequestBody UsersDto dto){
		try {
			
			UsersEntity users = service.post(dto);
			
			if (dto.getKodeLeads() == null) {
				result.setStatus(HttpStatus.BAD_REQUEST.value());
                result.setMessage("Kode leads tidak boleh kosong");
                result.setData(null);
                return ResponseEntity.badRequest().body(result);
			} else {
				result.setStatus(200);
                result.setMessage("Success");
                result.setData(users);
                return ResponseEntity.ok(result);
			}
		} catch (Exception e) {
			StatusMessageDto error = new StatusMessageDto(500, e.getMessage(), null);
	        return ResponseEntity.status(500).body(error);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping
	public ResponseEntity<?> put(@PathVariable String kodeLeads, @RequestBody UsersDto dto){
		try {
			
			UsersEntity users = service.put(kodeLeads, dto);
			
			if (dto.getKodeLeads() == null) {
				result.setStatus(HttpStatus.BAD_REQUEST.value());
                result.setMessage("Kode leads tidak boleh kosong");
                result.setData(null);
                return ResponseEntity.badRequest().body(result);
			} else {
				result.setStatus(200);
                result.setMessage("Success");
                result.setData(users);
                return ResponseEntity.ok(result);
			}
		} catch (Exception e) {
			StatusMessageDto error = new StatusMessageDto(500, e.getMessage(), null);
	        return ResponseEntity.status(500).body(error);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping
	public ResponseEntity<?> delete(@PathVariable String kodeLeads){
		try {
			
			UsersEntity users = service.delete(kodeLeads);
			
			if (users == null) {
				result.setStatus(HttpStatus.BAD_REQUEST.value());
                result.setMessage("User not found");
                result.setData(null);
                return ResponseEntity.badRequest().body(result);
			} else {
				result.setStatus(200);
                result.setMessage("Success");
                result.setData(users);
                return ResponseEntity.ok(result);
			}
		} catch (Exception e) {
			StatusMessageDto error = new StatusMessageDto(500, e.getMessage(), null);
	        return ResponseEntity.status(500).body(error);
		}
	}
}
