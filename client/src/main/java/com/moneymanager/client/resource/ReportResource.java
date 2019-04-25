package com.moneymanager.client.resource;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moneymanager.client.domain.Report;
import com.moneymanager.client.service.ReportService;

@Controller
public class ReportResource {

	@Autowired
	ReportService reportService;
	

	@RequestMapping("/income-vs-investment")
	public String expenseReport(Model model,HttpSession httpSession) {

		String email = (String) httpSession.getAttribute("name");
		Report report = reportService.getReport(email);
		model.addAttribute("income", report.getIncome());

		model.addAttribute("investment", report.getInversment());
		
		return "INCOME vs INVESTMENT-report";

	}
}
