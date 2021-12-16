package com.bank.login;

import java.sql.*;
import java.util.Scanner;

public class Userdao {
Scanner sc = new Scanner(System.in);

//Insert Data in to login table:
    public void insertdata(String username,String role) throws Exception {



        Connection con = Connect.getConnection();

        String query = "insert into login(username,role) values(?,?)";
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1,username);
     st.setString(2, role);
        int res = st.executeUpdate();
        if(res > 0) {
        	System.out.println(res +" is affected!!");
        }
        st.close();
        con.close();
    }

    //fetch data:
    public String getrole(String user,String pass) throws Exception{


String role = null;
        Connection con = Connect.getConnection();

        String query = "select * from usernamepass where username in ? and password in ?";
        PreparedStatement st = con.prepareStatement(query);
           st.setString(1, user);
           st.setString(2, pass);
        ResultSet rs = st.executeQuery();
        while(rs.next()) {
        	role = rs.getString(5);
        }
        
        return role;
    }
    
    //get role:
    public String getrole1(String uname) throws Exception {
    	Connection con = Connect.getConnection();
    	
    	String query = "select role from usernamepass where username in ?";
    	PreparedStatement st = con.prepareStatement(query);
    	st.setString(1, uname);
    	ResultSet rs = st.executeQuery();
    	rs.next();
    	String res = rs.getString(1);
    	return res;
    }

  //passchange:
  	public int pinchange(String user,String pass) throws Exception{
  		Connection con = Connect.getConnection();

  		String query = "update usernamepass set password = ? where username in ?";
  		String query1 = "commit";
  		PreparedStatement statement = con.prepareStatement(query);
  		statement.setString(1, pass);
  		statement.setString(2, user);
  		int i = statement.executeUpdate();
  		
  		statement.executeUpdate(query1);
  		return i;
  	}
  	
  	//insusernamepass:
  public int insusernamepass(String username,String pass,String role) throws Exception {
	  Connection con = Connect.getConnection();

		String query = "insert into usernamepass(username,password,role) values(?,?,?)";
		String query1 = "commit";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, username);
		statement.setString(2, pass);
		statement.setString(3, role);
		int i = statement.executeUpdate();
		statement.executeUpdate(query1);
		return i;
  }
  
  //removeacc:
  public int removeuser(String user) throws Exception{
		Connection con = Connect.getConnection();

		String query = "delete from usernamepass where username in ?";
		String query1 = "commit";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, user);
		int i = statement.executeUpdate();
		statement.executeUpdate(query1);
		return i;
	}
}
