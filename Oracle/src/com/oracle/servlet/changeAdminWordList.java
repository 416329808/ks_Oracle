package com.oracle.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.daomain.checkperson;
import com.oracle.service.AccountService;
import com.oracle.service.impl.AccountServiceImpl;
import com.sun.xml.internal.ws.message.StringHeader;

@WebServlet("/changeAdminWordList")
public class changeAdminWordList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public changeAdminWordList() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ID= (String)request.getParameter("ID");
		
		System.out.println("改密码servlet过来啦"+ID);
		AccountService checkperson= new AccountServiceImpl();
		checkperson c =checkperson.FindaccountByid(ID);		
		request.setAttribute("c", c);
		request.getRequestDispatcher("SystemAdmin/change_password.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
