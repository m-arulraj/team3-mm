package com.virtusa.money.manager.user.service.domain;

import java.util.List;

import lombok.Data;

@Data
public class ErrorResponse {
	
	private boolean isError;
	private List<Message> messages;
	private String level;
}
