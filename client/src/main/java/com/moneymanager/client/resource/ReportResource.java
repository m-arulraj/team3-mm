package com.moneymanager.client.resource;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String expenseReport(Model model,HttpSession httpSession) {

		logger.info("ReportResource income-vs-investment");
		logger.debug("ReportResource income-vs-investment");
		
		String email = (String) httpSession.getAttribute("name");
		Report report = reportService.getReport(email);
		model.addAttribute("income", report.getIncome());

		model.addAttribute("investment", report.getInversment());
		
		return "INCOME vs INVESTMENT-report";

	}
	@RequestMapping("/expenses-report")
	public String expensesReport() {

		logger.info("ReportResource expenses-report");
		logger.debug("ReportResource expenses-report");

		return "expenses-report";

	}
	
	@RequestMapping("/income-vs-investment-vs-expenses-report")
	public String iieReport() {

		logger.info("ReportResource income-vs-investment-vs-expenses-report ");
		logger.debug("ReportResource income-vs-investment-vs-expenses-report ");

		return "income-vs-investment-vs-expenses-report";

	}
}
