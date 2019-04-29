package com.virtusa.money.manager.user.service.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.css.Counter;

import com.virtusa.money.manager.user.service.domain.Report;
import com.virtusa.money.manager.user.service.domain.UserTransaction;

@Service
public class ReportService {

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	Function<UserTransaction, String> getYearAndMonth() {
		return i -> LocalDate.parse(i.getDate()).getYear() + "-" + LocalDate.parse(i.getDate()).getMonthValue();
	};

	Function<UserTransaction, Integer> getMonth() {
		return i -> LocalDate.parse(i.getDate()).getMonthValue();
	};

	Predicate<UserTransaction> basedOnYear(Long year) {
		return i -> LocalDate.parse(i.getDate()).getYear() == year;
	};

	Function<UserTransaction, String> getExpenseType() {
		return i -> i.getCategoryList().getName();
	};

	@Autowired
	SearchService transactionService;

	Predicate<UserTransaction> forYear(List<Integer> years) {
		return i -> years.contains(LocalDate.parse(i.getDate(), formatter).getYear());
	}

	public Report getForReport(Long id) {

		List<UserTransaction> allTransaction = transactionService.getUserFullTransaction(id);
		Report report = new Report();
		Map<String, Long> income = allTransaction.stream()
				.filter(i -> i.getCategoryList().getCategory().getCategory().equals("income"))
				.sorted(Comparator.comparing(UserTransaction::getDate))
				.collect(Collectors.groupingBy(getYearAndMonth(), Collectors.summingLong(UserTransaction::getAmount)));
		Map<String, Long> expence = allTransaction.stream()
				.filter(i -> i.getCategoryList().getCategory().getCategory().equals("expense"))
				.sorted(Comparator.comparing(UserTransaction::getDate))
				.collect(Collectors.groupingBy(getYearAndMonth(), Collectors.summingLong(UserTransaction::getAmount)));
		Map<String, Long> inversment = allTransaction.stream()
				.filter(i -> i.getCategoryList().getCategory().getCategory().equals("investment"))
				.sorted(Comparator.comparing(UserTransaction::getDate))
				.collect(Collectors.groupingBy(getYearAndMonth(), Collectors.summingLong(UserTransaction::getAmount)));
		Map<String, Long> fullExpense = allTransaction.stream()
				.filter(i -> i.getCategoryList().getCategory().getCategory().equals("expense"))
				.collect(Collectors.groupingBy(getExpenseType(), Collectors.summingLong(UserTransaction::getAmount)));

		report.setIncome(income);
		report.setExpence(expence);
		report.setInversment(inversment);
		report.setFullExpence(fullExpense);
		return report;
	}

	public Report getForReport(Long id, Long year) {

		List<UserTransaction> allTransaction = transactionService.getUserFullTransaction(id);
		Report report = new Report();
		List<Long> incomeForYear = new ArrayList<Long>(Collections.nCopies(12, 0L));
		List<Long> expenseForYear = new ArrayList<Long>(Collections.nCopies(12, 0L));
		List<Long> investmentForYear = new ArrayList<Long>(Collections.nCopies(12, 0L));
		
		allTransaction.stream().filter(i -> i.getCategoryList().getCategory().getCategory().equals("income"))
				.sorted(Comparator.comparing(UserTransaction::getDate)).filter(basedOnYear(year))
				.forEach(i -> incomeForYear.set(LocalDate.parse(i.getDate()).getMonthValue() -1, incomeForYear.get(LocalDate.parse(i.getDate()).getMonthValue())+i.getAmount()));
		
		allTransaction.stream().filter(i -> i.getCategoryList().getCategory().getCategory().equals("expense"))
				.sorted(Comparator.comparing(UserTransaction::getDate)).filter(basedOnYear(year))
				.forEach(i -> expenseForYear.set(LocalDate.parse(i.getDate()).getMonthValue()-1, expenseForYear.get(LocalDate.parse(i.getDate()).getMonthValue())+i.getAmount()));
		
		allTransaction.stream().filter(i -> i.getCategoryList().getCategory().getCategory().equals("investment"))
				.sorted(Comparator.comparing(UserTransaction::getDate)).filter(basedOnYear(year))
				.forEach(i -> investmentForYear.set(LocalDate.parse(i.getDate()).getMonthValue() -1, investmentForYear.get(LocalDate.parse(i.getDate()).getMonthValue())+i.getAmount()));

		report.setIncomeForYear(incomeForYear);
		report.setExpenseForYear(expenseForYear);
		report.setInvestmentForYear(investmentForYear);
		return report;
	}
}
