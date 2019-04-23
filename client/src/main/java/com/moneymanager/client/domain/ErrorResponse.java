package com.moneymanager.client.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement(name="error")
public class ErrorResponse {
	
	private boolean isError;
	private List<Message> messages;
	private String level;
}
