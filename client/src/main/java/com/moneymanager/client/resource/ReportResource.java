package com.moneymanager.client.resource;

import java.security.Principal;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moneymanager.client.MoneyManagerApp;
import com.moneymanager.client.domain.Report;
import com.moneymanager.client.service.ReportService;

@Controller
public class ReportResource {

	@Autowired
	ReportService reportService;
	final static Logger logger = Logger.getLogger(MoneyManagerApp.class);

	@RequestMapping("/income-vs-investment")
	public String expenseReport(Model model,Principal principal) {

		logger.info("ReportResource income-vs-investment");
		logger.debug("ReportResource income-vs-investment");
		
		String email = principal.getName();
		Report report = reportService.getReport(email);
		Collection<Long> income = report.getIncome().values();
		Long incomeAmount = income.stream().mapToLong(Long::longValue).sum();
		
		Collection<Long> investment = report.getInversment().values();
		Long investmentAmount = investment.stream().mapToLong(Long::longValue).sum();
		model.addAttribute("income", incomeAmount);

		model.addAttribute("investment", investmentAmount);
		
		return "INCOME vs INVESTMENT-report";

	}
	@RequestMapping("/expenses-report")
	public String expensesReport(Model model,Principal principal) {

		logger.info("ReportResource expenses-report");
		logger.debug("ReportResource expenses-report");
		String email = principal.getName();
		Report report = reportService.getReport(email);
		model.addAttribute("fullExpense", report.getFullExpence());
		model.addAttribute("name", "food");
		return "expenses-report";

	}
	
	@RequestMapping("/income-vs-investment-vs-expenses-report")
	public String iieReport(Model model,Principal principal) {

		logger.info("ReportResource income-vs-investment-vs-expenses-report ");
		logger.debug("ReportResource income-vs-investment-vs-expenses-report ");

		Long year =null;
		String email = principal.getName();
		Report report = new Report();
		if(year == null) {
			report = reportService.getReport(2019L,email);
		}else {
			report = reportService.getReport(year,email);
		}
		
		model.addAttribute("report", report);
		return "income-vs-investment-vs-expenses-report";

	}
	@ExceptionHandler(NullPointerException.class)
	public String handleError() {

		return "error-page";
	}
}
