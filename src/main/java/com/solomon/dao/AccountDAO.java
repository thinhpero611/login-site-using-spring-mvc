package com.solomon.dao;

import java.util.List;

import com.solomon.beans.Account;

public class AccountDAO {
	private AccountJDBCTemplate accountJDBCTemplate;
	
	public void setAccountJDBCTemplate(AccountJDBCTemplate accountJDBCTemplate) {
		this.accountJDBCTemplate = accountJDBCTemplate;
	}
	
	public boolean login(String email, String password) {
		List<Account> accs = accountJDBCTemplate.getAccount(email);
		if (accs.size() != 0 && accs.get(0).getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	
	public Account getUser(String email) {
		return accountJDBCTemplate.getAccount(email).get(0);
	}
}
