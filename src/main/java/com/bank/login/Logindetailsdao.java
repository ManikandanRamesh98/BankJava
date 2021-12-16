package com.bank.login;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.http.HttpServlet;

public class Logindetailsdao {
	public int removelogindetail(String user) throws Exception{
		Connection con = Connect.getConnection();

		String query = "delete from login where username in ?";
		String query1 = "commit";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, user);
		int i = statement.executeUpdate();
		statement.executeUpdate(query1);
		return i;
	}
}
