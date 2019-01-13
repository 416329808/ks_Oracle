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

@WebServlet("/UpdateTeacherServlet")
public class UpdateTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateTeacherServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		TeacherServiceImpl ts=new TeacherServiceImpl();
		String TeacherID=request.getParameter("TeacherID");
		String TeacherName=request.getParameter("TeacherName");
		String Sex=request.getParameter("Sex");
		
		
		
		String BelongsInstituteName=request.getParameter("BelongsInstituteName");
        InstitutePronounService insService =new InstitutePronounServiceImpl();
		
		InstitutePronoun ins=insService.FindinstitutepronounByname(BelongsInstituteName);
		
		String BelongsInstituteID=ins.getInstitutePronoun();
		
		Teacher t=new Teacher(TeacherID,TeacherName,Sex,BelongsInstituteID,BelongsInstituteName);
		if(ts.UpdateTeacher(TeacherID, t))  System.out.println("TeacherID:"+TeacherID+"修改成功");
		else System.out.println("TeacherID:"+TeacherID+"修改失败");
		response.sendRedirect("QueryAllTeacherServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
