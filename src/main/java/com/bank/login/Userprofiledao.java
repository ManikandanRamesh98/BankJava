package com.bank.login;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Userprofiledao  {
	
	public int getbal(String username)throws Exception {
Connection con = Connect.getConnection();

String query = "select balance from userprofile where username in ?";
PreparedStatement statement = con.prepareStatement(query);
statement.setString(1, username);
ResultSet rSet = statement.executeQuery();

int res = -1;
while(rSet.next()) {
	res = rSet.getInt(1);
}
return res;
}
	
	//insert balance:
	public int insbal(Integer bal,String username)throws Exception {
		Connection con = Connect.getConnection();

		String query = "update userprofile set balance = ? where username in ?";
		String query1 = "commit";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setInt(1, bal);
		statement.setString(2, username);
		int i = statement.executeUpdate();
		statement.executeUpdate(query1);
System.out.println(i);
		return i;
}
	
	//getaccnof
	public Long getaccno(String uname)throws Exception {
		Connection con = Connect.getConnection();

		String query = "select user_acc_no from userprofile where username in ?";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, uname);
		ResultSet rs = statement.executeQuery();
Long resLong = -1l;
while(rs.next()) {
	resLong = rs.getLong(1);
}
return resLong;
	}
	
	//getuserdetails
	public ResultSet getuserdetails(String user) throws Exception {
		Connection con = Connect.getConnection();

		String query = "select * from userprofile where username in ?";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, user);
		ResultSet rs = statement.executeQuery();
		return rs;
	}
}
