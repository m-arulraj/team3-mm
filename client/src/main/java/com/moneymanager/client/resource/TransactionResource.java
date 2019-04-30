package com.moneymanager.client.resource;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.moneymanager.client.domain.UserTransaction;
import com.moneymanager.client.service.TransactionService;

@Controller
@RequestMapping("/user-transaction")
public class TransactionResource {

	@Autowired
	TransactionService service;
	
	@GetMapping("/expense")
	public String saveTransactionForExpense(@ModelAttribute("Transaction")UserTransaction userTransaction,HttpSession session) {
		String name = (String) session.getAttribute("name");
		service.saveTransaction(userTransaction, name);
		return "redirect:/expenseResource";
	}
	@GetMapping("/income")
	public String saveTransactionForIncome(@ModelAttribute("Transaction")UserTransaction userTransaction,Principal session) {
		String name = session.getName();
		System.out.println("*******************************"+name);
		service.saveTransaction(userTransaction, name);
		return "redirect:/incomeResource";
	}
	@GetMapping("/investment")
	public String saveTransactionForInverstment(@ModelAttribute("Transaction")UserTransaction userTransaction,HttpSession session) {
		String name = (String) session.getAttribute("name");
		service.saveTransaction(userTransaction, name);
		return "redirect:/investmentResource";
	}
	
	@GetMapping("/all-transactions")
	public String getTransactionsOfExpense(Principal session,Model model) {
		String name = session.getName();
		System.out.println(name);
		List<UserTransaction> transactionsList=service.getTransactions(name);
		model.addAttribute("transactionsList",transactionsList);
		return "user-transactions";
	}
	@GetMapping("/update-transaction")
	public String updateTransaction(@RequestParam("id")Long id ,Model model) {
		UserTransaction transaction = service.getOneTransaction(id);
		model.addAttribute("transaction", transaction);
		return "update-transaction";
	}
	/*
	 * @GetMapping("/transaction") public String
	 * updateTransactionResource(HttpSession session,Model model) { String name =
	 * (String) session.getAttribute("name"); List<UserTransaction>
	 * transactionsList=service.getTransactions(name);
	 * model.addAttribute("transactionsList",transactionsList); return
	 * "user-transactions"; }
	 * 
	 * @GetMapping("/transaction") public String
	 * deleteTransactionResource(HttpSession session,Model model) { String name =
	 * (String) session.getAttribute("name"); List<UserTransaction>
	 * transactionsList=service.getTransactions(name);
	 * model.addAttribute("transactionsList",transactionsList); return
	 * "user-transactions"; }
	 */
}
