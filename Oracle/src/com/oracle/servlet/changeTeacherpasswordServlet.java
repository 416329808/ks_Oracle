package com.oracle.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.daomain.checkperson;
import com.oracle.service.change_passwordService;
import com.oracle.service.impl.change_passwordServiceImpl;
import com.oracle.util.md5;

import oracle.net.aso.s;

/**
 * Servlet implementation class change_passwordServlet
 */
@WebServlet("/changeTeacherpasswordServlet")
public class changeTeacherpasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public changeTeacherpasswordServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		change_passwordService change_passwordService = new change_passwordServiceImpl();
		try {
			String ID=request.getParameter("ID");
			request.getSession().setAttribute("ID", ID);
			String NewPassword = request.getParameter("New_PSW");
			String NewPassword1 = request.getParameter("New_PSW1");
			String OldPassword = request.getParameter("OldPsw");
			OldPassword=md5.md5andbase64(OldPassword);
			checkperson checkperson=change_passwordService.findByID(ID);
			System.out.println("新一" + NewPassword + "新二" + NewPassword1 + "旧:" + OldPassword);
			System.out.println(NewPassword.equals( NewPassword1));
			if (NewPassword.equals( NewPassword1)) {
				if (OldPassword.equals(checkperson.getPasswords())) {
					change_passwordService.change(ID, NewPassword, OldPassword);
					System.out.println("修改成功");
					String message="修改成功";
					//request.setAttribute("message",message);
					
					response.sendRedirect("TeacherInfoServlet?ID="+ID+"&message="+message);
				} else {
					System.out.println("与旧密码不符");
					String message="与旧密码不符";
					//request.setAttribute("message",message);
					response.sendRedirect("TeacherInfoServlet?ID="+ID+"&message="+message);
				}
			}
			else {
				System.out.println("两个新密码不一致");
				String message="两个新密码不一致";
				//request.setAttribute("message",message);
				response.sendRedirect("TeacherInfoServlet?ID="+ID+"&message="+message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
