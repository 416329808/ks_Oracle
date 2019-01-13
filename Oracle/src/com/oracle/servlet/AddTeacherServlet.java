package com.oracle.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.daomain.InstitutePronoun;
import com.oracle.daomain.Teacher;
import com.oracle.service.InstitutePronounService;
import com.oracle.service.impl.InstitutePronounServiceImpl;
import com.oracle.service.impl.TeacherServiceImpl;

@WebServlet("/AddTeacherServlet")
public class AddTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddTeacherServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String TeacherID = request.getParameter("TeacherID");
		String TeacherName = request.getParameter("TeacherName");
		String Sex = request.getParameter("Sex");
		// String BelongsInstituteID=request.getParameter("BelongsInstituteID");
		String BelongsInstituteName = request.getParameter("BelongsInstituteName");

		InstitutePronounService insService = new InstitutePronounServiceImpl();

		InstitutePronoun ins = insService.FindinstitutepronounByname(BelongsInstituteName);

		String BelongsInstituteID = ins.getInstitutePronoun();

		TeacherServiceImpl ts = new TeacherServiceImpl();
		Teacher t = new Teacher(TeacherID, TeacherName, Sex, BelongsInstituteID, BelongsInstituteName);
		if (ts.Add(t)) {

			System.out.println("TeacherID:" + TeacherID + "添加成功");
		} else {

			System.out.println("TeacherID:" + TeacherID + "添加失败");
		}
		response.sendRedirect("QueryAllTeacherServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
