package com.bank.login;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import oracle.net.aso.b;

@WebServlet("/depserv")
public class Depositserv extends HttpServlet{
public void service(HttpServletRequest req,HttpServletResponse res) {
	Userprofiledao userprofiledao = new Userprofiledao();
	Depositdao depositdao = new Depositdao();
	HttpSession session = req.getSession();
	String uname = session.getAttribute("user").toString();
	int eamount = Integer.parseInt(req.getParameter("inpdep"));
	try {
		if(userprofiledao.getbal(uname) > 0) {
		 int bal= userprofiledao.getbal(uname);
if(eamount > 0 && eamount < 30000) {
	int newbal = bal+eamount;
			int i = userprofiledao.insbal(newbal, uname);
			if(i > 0) {
				Long acc =userprofiledao.getaccno(uname);
				if(acc > 0) {
					depositdao.insdep(acc, eamount);
				session.setAttribute("depamount", eamount);
				session.setAttribute("depbal", newbal);
				res.sendRedirect("Depsucc.jsp");
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
