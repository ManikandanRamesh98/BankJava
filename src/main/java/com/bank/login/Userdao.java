package com.bank.login;

import java.sql.*;
import java.sql.Connection;
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


String res = null;
        Connection con = Connect.getConnection();

        String query = "select * from usernamepass where username in ? and password in ?";
        PreparedStatement st = con.prepareStatement(query);
           st.setString(1, user);
           st.setString(2, pass);
        ResultSet rs = st.executeQuery();
        while(rs.next()) {
        	res = rs.getString(5);
        }
        
        return res;
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

    //update:
public void updatedata(Usertable usertable) throws Exception {
    Connection con = Connect.getConnection();

    String query = "update user1 set user_name = ? where id1 in ?";
    PreparedStatement st = con.prepareStatement(query);
    st.setString(1,usertable.getUser_name());
    st.setLong(2, usertable.getId());
    int res = st.executeUpdate();
    System.out.println(res + " is affected!!");
    st.close();
    con.close();
}
//delete:
    public void deletedata(Usertable usertable) throws Exception {
        Connection con = Connect.getConnection();

        String query = "delete from user1 where id1 in ?";
        PreparedStatement st = con.prepareStatement(query);

        st.setLong(1, usertable.getId());
        int res = st.executeUpdate();
        System.out.println(res + " is affected!!");
        st.close();
        con.close();
    }
}
