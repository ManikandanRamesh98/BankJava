package com.bank.login;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Depositdao {
	public int insdep(long accno,int amount)throws Exception {
		Connection con = Connect.getConnection();

		String query = "insert into deposit(user_acc_no,dep_amount) values(?,?)";
		String query1 = "commit";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setLong(1, accno);
		statement.setInt(2, amount);
		int i = statement.executeUpdate();
		statement.executeUpdate(query1);
		return i;
		}
	
	//remove acc:
	public int removedep(Long accno) throws Exception{
		Connection con = Connect.getConnection();

		String query = "delete from deposit where user_acc_no in ?";
		String query1 = "commit";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setLong(1, accno);
		int i = statement.executeUpdate();
		statement.executeUpdate(query1);
		return i;
	}
}
