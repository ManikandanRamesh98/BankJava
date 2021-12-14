package com.bank.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Withdrawdao  {
	
	public int inswith(long accno,int amount)throws Exception {
Connection con = Connect.getConnection();

String query = "insert into withdraw(user_acc_no,with_amount) values(?,?)";
String query1 = "commit";
PreparedStatement statement = con.prepareStatement(query);
statement.setLong(1, accno);
statement.setInt(2, amount);
int i = statement.executeUpdate();
statement.executeUpdate(query1);
return i;
}
	
	
//	//fetch withdraw:
//	public ResultSet fetchwith()throws Exception {
//		Connection con = Connect.getConnection();
//
//		String query = "select user";
//		String query1 = "commit";
//		PreparedStatement statement = con.prepareStatement(query);
//		statement.setLong(1, accno);
//		statement.setInt(2, amount);
//		int i = statement.executeUpdate();
//		statement.executeUpdate(query1);
//		return i;
//		}
}