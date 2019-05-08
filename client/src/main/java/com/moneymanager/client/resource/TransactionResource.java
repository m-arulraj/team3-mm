package com.moneymanager.client.resource;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.moneymanager.client.domain.ErrorResponse;
import com.moneymanager.client.domain.Message;
import com.moneymanager.client.domain.UserTransaction;
import com.moneymanager.client.service.TransactionService;

@Controller
@RequestMapping("/user-transaction")
public class TransactionResource {

	@Autowired
	TransactionService service;


	@PostMapping("/expense")
	public String saveTransactionForExpense(@ModelAttribute("Transaction") UserTransaction userTransaction,
			Principal principal,RedirectAttributes attributes ,Model model) {
		try {
			String name = principal.getName();
			service.saveTransaction(userTransaction, name);
			
			
			attributes.addFlashAttribute("s", true);
			return "redirect:/expenseResource";
		} catch (HttpClientErrorException e) {

			Gson gson = new Gson();
			ErrorResponse convrted = gson.fromJson(e.getResponseBodyAsString(),ErrorResponse.class);
			List<Message> messages = convrted.getMessages();
			List<Message> newMessage = messages.stream().distinct().collect(Collectors.toList());
			model.addAttribute("errorMsg", newMessage);
			return "redirect:/expenseResource";
		}

	}

	@GetMapping("/income")
	public String saveTransactionForIncome(@ModelAttribute("Transaction") UserTransaction userTransaction,
			Principal principal,Model model,RedirectAttributes attributes) {
		String name = principal.getName();

		service.saveTransaction(userTransaction, name);
		model.addAttribute("sucess", "sucess");
		attributes.addFlashAttribute("s", true);
		return "redirect:/incomeResource";
	}

	@GetMapping("/investment")
	public String saveTransactionForInverstment(@ModelAttribute("Transaction") UserTransaction userTransaction,
			Principal principal,Model model,RedirectAttributes attributes) {
		String name = principal.getName();
		service.saveTransaction(userTransaction, name);
		model.addAttribute("sucess", name);
		attributes.addFlashAttribute("s", true);
		return "redirect:/investmentResource";
	}

	@GetMapping("/all-transactions")
	public String getTransactionsOfExpense(Principal principal, Model model) {
		String name = principal.getName();
		
		List<UserTransaction> transactionsList = service.getTransactions(name);
		model.addAttribute("transactionsList", transactionsList);
		model.addAttribute("types", "income");
		return "user-transactions";
	}

	@GetMapping("/update-transaction")
	public String updateTransactionPage(@RequestParam("id") Long id, Model model) {
		UserTransaction transaction = service.getOneTransaction(id);

		System.out.println(transaction);
		model.addAttribute("transaction", transaction);
		return "update-transaction";
	}

	@PostMapping("/update-transaction")
	public String updateTransaction(@ModelAttribute("transaction") UserTransaction transaction, Model model,
			Principal principal,RedirectAttributes attributes) {
		String email = principal.getName();
		transaction.setUserEmail(email);
		service.updateTransaction(transaction);
		attributes.addFlashAttribute("sUpdate", true);
		
		return "redirect:/user-transaction/all-transactions";
	}

	@GetMapping("/delete-transaction")
	public String deleteTransaction(@RequestParam("id") Long id,RedirectAttributes attributes) {
		service.deleteTransaction(id);
		attributes.addFlashAttribute("sDelete", true);
		return "redirect:/user-transaction/all-transactions";
	}

	@ExceptionHandler(NullPointerException.class)
	public String handleError() {

		return "error-page";
	}

}
