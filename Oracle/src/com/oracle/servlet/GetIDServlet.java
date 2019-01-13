package com.oracle.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.daomain.checkperson;
import com.oracle.service.LoginService;
import com.oracle.service.passwordService;
import com.oracle.service.impl.LoginServiceImpl;
import com.oracle.service.impl.passwordServiceImpl;

/**
 * Servlet implementation class GetIDServlet
 */
@WebServlet("/GetIDServlet")
public class GetIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private passwordService passwordService= new passwordServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetIDServlet() {
    	
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ID = request.getParameter("ID");
		System.out.println("从学生信息页面接受到学号= "+ID);	
		System.out.println("传参ID="+ID);
		checkperson checkperson = null;
		try {
			checkperson= passwordService.getpassword(ID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("checkperson",checkperson);
		request.getRequestDispatcher("Student/change_password.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
