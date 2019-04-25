package com.moneymanager.client.resource;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
		Collection<Long> income = report.getIncome().values();
		Long incomeAmount = income.stream().mapToLong(Long::longValue).sum();
		
		Collection<Long> investment = report.getInversment().values();
		Long investmentAmount = investment.stream().mapToLong(Long::longValue).sum();
		model.addAttribute("income", incomeAmount);

		model.addAttribute("investment", investmentAmount);
		
		return "INCOME vs INVESTMENT-report";

	}
}
