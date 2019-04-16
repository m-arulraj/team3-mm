package com.virtusa.money.manager.user.service.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.money.manager.user.service.domain.Report;
import com.virtusa.money.manager.user.service.domain.UserTransaction;


@Service
public class ReportService {

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	Function<UserTransaction, String> getYearAndMonth() {
		return i -> LocalDate.parse(i.getDate(), formatter).getYear() + "-"
				+ LocalDate.parse(i.getDate(), formatter).getMonthValue();
	};

	

	@Autowired
	SearchService transactionService;
	
	Predicate<UserTransaction> forYear(List<Integer> years) {
		return i -> years.contains(LocalDate.parse(i.getDate(), formatter).getYear());
	}

	public Report getForReport(Long id) {
		
		List<UserTransaction> allTransaction = transactionService.getUserFullTransaction(id);
		Report report =new Report();
		Map<String, Long> income = allTransaction.stream()
				.filter(i -> i.getCategoryList().getCategory().equals("income"))
				.sorted(Comparator.comparing(UserTransaction::getDate))
				.collect(Collectors.groupingBy(getYearAndMonth(), Collectors.summingLong(UserTransaction::getAmount)));
		Map<String, Long> expence = allTransaction.stream()
				.filter(i -> i.getCategoryList().getCategory().equals("income"))
				.sorted(Comparator.comparing(UserTransaction::getDate))
				.collect(Collectors.groupingBy(getYearAndMonth(), Collectors.summingLong(UserTransaction::getAmount)));
		Map<String, Long> inversment = allTransaction.stream()
				.filter(i -> i.getCategoryList().getCategory().equals("income"))
				.sorted(Comparator.comparing(UserTransaction::getDate))
				.collect(Collectors.groupingBy(getYearAndMonth(), Collectors.summingLong(UserTransaction::getAmount)));
	
		
		report.setIncome(income);
		report.setExpence(expence);
		report.setInversment(inversment);
		return report ;
	}
}
