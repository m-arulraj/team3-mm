package com.virtusa.money.manager.user.service.service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.money.manager.user.service.domain.UserTransaction;
import com.virtusa.money.manager.user.service.repository.CategoryListRepository;
import com.virtusa.money.manager.user.service.repository.CategoryRepository;
import com.virtusa.money.manager.user.service.repository.UserRepository;
import com.virtusa.money.manager.user.service.repository.UserTransactionRepository;

@Service
public class SearchService {
	@Autowired
	UserTransactionRepository userTransactionRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	CategoryListRepository categoryListRepository;

	@Autowired
	UserRepository userRepository;

	public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	Comparator<UserTransaction> transactionBasedOnAmount = Comparator.comparing(UserTransaction::getAmount);
	Comparator<UserTransaction> transactionBasedOnCategory = (UserTransaction u1, UserTransaction u2) -> u1
			.getCategoryList().getName().compareTo(u2.getCategoryList().getName());

	Comparator<UserTransaction> transactionBasedOnAmountInreverse = transactionBasedOnAmount.reversed();

	private static final Predicate<UserTransaction> BASEDONDATERANGE(String startDate, String endDate) {

		return i -> LocalDate.parse(i.getDate(), formatter).isAfter(LocalDate.parse(startDate, formatter))
				&& LocalDate.parse(i.getDate(), formatter).isBefore(LocalDate.parse(endDate, formatter));

	}

	private static final Predicate<UserTransaction> FINDTRANSACTIONBYNAME(String name) {
		return i -> i.getCategoryList().getName().equalsIgnoreCase(name);
	}

	private static final Predicate<UserTransaction> FINDTRANSACTIONFORCURRENTUSER(Long id) {
		return i -> i.getUser().getId().equals(id);
	}

	private static final Predicate<UserTransaction> GETBASEDONAMOUNT(Long amount) {
		return i -> i.getAmount().equals(amount);
	}

	public UserTransaction storeUserTransaction(UserTransaction userTransaction) {
		return userTransactionRepository.save(userTransaction);
	}

	public List<UserTransaction> getUserFullTransaction( Long id) {
		List<UserTransaction> userTransaction = userTransactionRepository.findAll();

		List<UserTransaction> userTransactionOptional = userTransaction.stream()
				.filter(FINDTRANSACTIONFORCURRENTUSER(id))
				.collect(Collectors.toList());

		return !userTransactionOptional.isEmpty() ? userTransactionOptional : null;
	}
	
	public List<UserTransaction> getUserTransactionByName(String name, Long id) {
		List<UserTransaction> userTransaction = userTransactionRepository.findAll();

		List<UserTransaction> userTransactionOptional = userTransaction.stream()
				.filter(FINDTRANSACTIONFORCURRENTUSER(id)).filter(FINDTRANSACTIONBYNAME(name))
				.collect(Collectors.toList());

		return !userTransactionOptional.isEmpty() ? userTransactionOptional : null;
	}

	public List<UserTransaction> getTransactionByNameAndDate(String name, Long id) {
		List<UserTransaction> userTransaction = userTransactionRepository.findAll();

		List<UserTransaction> userTransactionOptional = userTransaction.stream()
				.filter(FINDTRANSACTIONFORCURRENTUSER(id)).filter(FINDTRANSACTIONBYNAME(name))
				.sorted(Comparator.comparing(UserTransaction::getDate)).collect(Collectors.toList());

		return !userTransactionOptional.isEmpty() ? userTransactionOptional : null;
	}

	public List<UserTransaction> getTransactionByNameAndAmount(String name, Long id) {
		List<UserTransaction> userTransaction = userTransactionRepository.findAll();

		List<UserTransaction> userTransactionOptional = userTransaction.stream()
				.filter(FINDTRANSACTIONFORCURRENTUSER(id)).filter(FINDTRANSACTIONBYNAME(name))
				.sorted(transactionBasedOnAmountInreverse).collect(Collectors.toList());

		return !userTransactionOptional.isEmpty() ? userTransactionOptional : null;
	}

	public List<UserTransaction> getTransactionByNameAndCategory(String name, Long id) {
		List<UserTransaction> userTransaction = userTransactionRepository.findAll();

		List<UserTransaction> userTransactionOptional = userTransaction.stream()
				.filter(FINDTRANSACTIONFORCURRENTUSER(id)).filter(FINDTRANSACTIONBYNAME(name))
				.sorted(transactionBasedOnCategory).collect(Collectors.toList());

		return !userTransactionOptional.isEmpty() ? userTransactionOptional : null;
	}

	public List<UserTransaction> getTransactionByNameAndDateWithBoundries(String name, Long id, String startDate,
			String endDate){
		List<UserTransaction> userTransaction = userTransactionRepository.findAll();

		List<UserTransaction> userTransactionOptional = userTransaction.stream()
				.filter(FINDTRANSACTIONFORCURRENTUSER(id)).filter(FINDTRANSACTIONBYNAME(name))
				.filter(BASEDONDATERANGE(startDate, endDate)).collect(Collectors.toList());

		return !userTransactionOptional.isEmpty() ? userTransactionOptional : null;
	}

	public List<UserTransaction> getTransactionByNameAndAmountWithRange(String name, Long id, Long amount)
			throws DateTimeException {
		List<UserTransaction> userTransaction = userTransactionRepository.findAll();

		List<UserTransaction> userTransactionOptional = new ArrayList<UserTransaction>();

		userTransactionOptional = userTransaction.stream().filter(FINDTRANSACTIONFORCURRENTUSER(id))
				.filter(FINDTRANSACTIONBYNAME(name)).filter(GETBASEDONAMOUNT(200L)).collect(Collectors.toList());

		return !userTransactionOptional.isEmpty() ? userTransactionOptional : null;
	}

}
