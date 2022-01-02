package com.solomon.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.solomon.beans.Account;
import com.solomon.beans.AccountMapper;

public class AccountJDBCTemplate {
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void create(String email, String password, String name) {
		JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);
		String query = "insert into account (user_mail, password, user_name) values (?,?,?);";
		jdbcTemplateObject.update(query, email, password, name);
	}
	
	public List<Account> getAccount(String email) {
		JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);
		String query = "select * from account where user_mail = ?";
		List<Account> accounts = jdbcTemplateObject.query(query, new AccountMapper(), new Object[] {email});
		return accounts;
	}
}
