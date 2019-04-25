package com.moneymanager.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.moneymanager.client.domain.Report;
import com.moneymanager.client.domain.User;
import com.moneymanager.client.util.EndPointUri;

@Service
public class ReportService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	ClientService clientService;

	public Report getReport(String name) {
		User user = clientService.getUserByEmailId(name);

		ResponseEntity<Report> result = restTemplate.getForEntity(EndPointUri.REPORT + user.getId(), Report.class);
		return result.getBody();
	}

	public Report getReport(Long year, String email) {
		User user = clientService.getUserByEmailId(email);

		ResponseEntity<Report> result = restTemplate.getForEntity(EndPointUri.REPORT + user.getId()+"/year/"+year, Report.class);
	
		if(result.getBody() == null) {
			return new Report();
		}else {
			return result.getBody();
		}
		
	}

}
