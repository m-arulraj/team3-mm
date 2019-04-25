package com.virtusa.money.manager.user.service.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import lombok.Data;

@Data
public class Report {

	Map<String, Long> expence = new TreeMap<String,Long>();
	Map<String,Long> income = new TreeMap<String,Long>();
	Map<String,Long> inversment = new TreeMap<String,Long>();
	
	//for expense report
	Map<String, Long> fullExpence = new TreeMap<String,Long>();
	//for line graph
	List<Long> incomeForYear = new ArrayList<Long>(Collections.nCopies(12, 0L));
	List<Long> expenseForYear = new ArrayList<Long>(Collections.nCopies(12, 0L));
	List<Long> investmentForYear = new ArrayList<Long>(Collections.nCopies(12, 0L)); 
	
}
