package com.swaggerspring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusMessageDto<T> {

	private Integer status;
	private String message;
	private T data;
}
