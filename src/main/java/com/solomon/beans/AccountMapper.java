package com.solomon.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class AccountMapper implements RowMapper<Account> {
   public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
      Account account = new Account();
      account.setUser(rs.getString("user_mail"));
      account.setName(rs.getString("user_name"));
      account.setPassword(rs.getString("password"));
      account.setAddress(rs.getString("user_address"));
      account.setPhone(rs.getString("user_phone"));
      return account;
   }
}