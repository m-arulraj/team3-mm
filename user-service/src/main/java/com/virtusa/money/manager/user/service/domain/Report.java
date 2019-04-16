package com.virtusa.money.manager.user.service.domain;

import java.util.Map;
import java.util.TreeMap;

import lombok.Data;

@Data
public class Report {

	Map<String, Long> expence = new TreeMap<String,Long>();
	Map<String,Long> income = new TreeMap<String,Long>();
	Map<String,Long> inversment = new TreeMap<String,Long>();
	
	
	
}
