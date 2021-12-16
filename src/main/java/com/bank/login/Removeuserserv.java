package com.bank.login;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/removeaccserv")
public class Removeuserserv extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Logindetailsdao logindetailsdao = new Logindetailsdao();
	Withdrawdao withdrawdao = new Withdrawdao();
	Depositdao depositdao = new Depositdao();
	Userprofiledao userprofiledao = new Userprofiledao();
	Userdao userdao = new Userdao();
HttpSession session = req.getSession();
String user = req.getParameter("remusername");
Long accno = -1l;
try {
	accno = userprofiledao.getaccno(user);
} catch (Exception e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
	try {
		int lrem = logindetailsdao.removelogindetail(user);
		if(lrem >= 0) {
			int withrem = withdrawdao.removewith(accno);
			if(withrem >= 0) {
				int deprem = depositdao.removedep(accno);
				if(deprem >= 0) {
					int userprofrem = userprofiledao.removeuserprof(accno);
					if(userprofrem > 0) {
						int userrem = userdao.removeuser(user);
						if(userrem > 0) {
							resp.sendRedirect("Userrem.jsp");
						}
					}
				}
			}
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
