package com.bank.login;

import org.apache.tomcat.jni.Global;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/withdrawserv")
public class Withdrawserv extends HttpServlet{
public void service(HttpServletRequest req,HttpServletResponse res){
	Userprofiledao userprofiledao = new Userprofiledao();
	Withdrawdao withdrawdao = new Withdrawdao();
	HttpSession session = req.getSession();
	String uname = session.getAttribute("user").toString();
	int eamount = Integer.parseInt(req.getParameter("inpwith"));
	try {
		if(userprofiledao.getbal(uname) > 0) {
		 int bal= userprofiledao.getbal(uname);
if(eamount <= bal && eamount > 0) {
	int newbal = bal-eamount;
			int i = userprofiledao.insbal(newbal, uname);
			if(i > 0) {
				Long acc =userprofiledao.getaccno(uname);
				if(acc > 0) {

					withdrawdao.inswith(acc, -eamount);
				session.setAttribute("withamount", eamount);
				session.setAttribute("withbal", newbal);
				res.sendRedirect("Withdrawsucc.jsp");
				}else {
					System.out.println("cant get useracc");
				}
			}else {
				res.getWriter().println("something went wrong!!");
			}
		 }else {
			 res.getWriter().println("enter the valid amount!!");
		 }
		}else {
			res.sendRedirect("Invaliduser.jsp");
		}
		 
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
