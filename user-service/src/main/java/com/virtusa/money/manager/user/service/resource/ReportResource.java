package com.virtusa.money.manager.user.service.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.money.manager.user.service.domain.Report;
import com.virtusa.money.manager.user.service.service.ReportService;

@RestController
@RequestMapping(value="/api/user/report")
public class ReportResource {

	@Autowired
	ReportService reportService;
	
	@GetMapping(value="{id}")
	public ResponseEntity<?> getReport(@PathVariable("id") Long id){
		try {
			Report report = reportService.getForReport(id);
			if(report == null) {
				return ResponseEntity.noContent().build();
			}else {
				return ResponseEntity.ok().build();
			}
		} catch (Exception e) {
			return ResponseEntity.noContent().build();
		}
		
		
	}
}
