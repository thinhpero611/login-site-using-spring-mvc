package com.solomon.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.solomon.beans.Account;
import com.solomon.dao.AccountDAO;

@Controller
public class LoginController {

	@Autowired
	private ApplicationContext context;

	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login.html", method = RequestMethod.POST)
	public String login(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		AccountDAO accountDAO = (AccountDAO) context.getBean("accountDAO");
		
		Account account = new Account();
		account.setUser(email);
		account.setPassword(password);

		if (!account.validate()) {
			model.addAttribute("error", account.getMessage());
			return "login";
		}

		// authenticate account
		if (accountDAO.login(email, password)) {
			model.addAttribute("username", accountDAO.getUser(email).getName());
			return "loginSuccess";
		} else {
			model.addAttribute("error", "UserName or Password is invalid");
			return "login";
		}
	}
	
	@RequestMapping(value="/redirect.html", method = RequestMethod.GET)
	public String redirect() {
		return "redirect:home.html";
	}
	
	@RequestMapping(value = "/home.html", method = RequestMethod.GET)
	public String finalPage() {
		return "home";
	}
}
