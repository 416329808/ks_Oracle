package com.oracle.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.daomain.businessadmins;
import com.oracle.service.BusinessAdminsService;
import com.oracle.service.impl.BusinessAdminServiceimpl;

public class BusinessAdminsinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String BusinessPersonID=request.getParameter("BusinessPersonID");
		 //System.out.println(BusinessPersonID);
		 BusinessAdminsService businessAdminsService=new BusinessAdminServiceimpl();
		    businessadmins businessadmins;
			try {
				businessadmins = businessAdminsService.findBusinessadmins(BusinessPersonID);
				request.setAttribute("businessadmins", businessadmins);
				System.out.println(businessadmins);
			    request.getRequestDispatcher("/AffairAdmin/individual_info.jsp").forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
