package com.oracle.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.daomain.checkperson;
import com.oracle.service.AccountService;
import com.oracle.service.change_passwordService;
import com.oracle.service.impl.AccountServiceImpl;
import com.oracle.service.impl.change_passwordServiceImpl;
import com.oracle.util.md5;

@WebServlet("/changeAdminpasswordServlet")
public class changeAdminpasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public changeAdminpasswordServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		change_passwordService change_passwordService = new change_passwordServiceImpl();
		try {
			String ID = (String) request.getParameter("account");
			String NewPassword = request.getParameter("New_PSW");
			String NewPassword1 = request.getParameter("New_PSW1");
			String OldPassword = request.getParameter("OldPsw");
			OldPassword=md5.md5andbase64(OldPassword);
			AccountService checkperson= new AccountServiceImpl();
			checkperson c =checkperson.FindaccountByid(ID);
			
				if (OldPassword.equals( c.getPasswords())) {
					change_passwordService.change(ID, NewPassword, OldPassword);
					System.out.println("修改成功");					
					response.sendRedirect("QueryAdmininfoServlet?ID="+ID);
				} else {
					System.out.println("与旧密码不符");
					response.sendRedirect("QueryAdmininfoServlet?ID="+ID);
				}
			
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
