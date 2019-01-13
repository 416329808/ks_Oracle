package com.oracle.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.daomain.Classe;
import com.oracle.daomain.InstitutePronoun;
import com.oracle.daomain.Profession;
import com.oracle.daomain.Teacher;
import com.oracle.daomain.student;
import com.oracle.service.ClassService;
import com.oracle.service.InstitutePronounService;
import com.oracle.service.ProfessionService;
import com.oracle.service.StudentadminService;
import com.oracle.service.studentService;
import com.oracle.service.impl.ClassServiceImpl;
import com.oracle.service.impl.InstitutePronounServiceImpl;
import com.oracle.service.impl.ProfessionServiceImpl;
import com.oracle.service.impl.StudentadminServiceImpl;
import com.oracle.service.impl.TeacherServiceImpl;
import com.oracle.service.impl.studentServiceImpl;

@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateStudentServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		StudentadminService st = new StudentadminServiceImpl();

		String StudentID = request.getParameter("StudentID");
		String StuentName = request.getParameter("StuentName");
		String Sex = request.getParameter("Sex");
		String institutename = request.getParameter("institutename");
		String proname = request.getParameter("proname");
		String classname = request.getParameter("classname");

		// 获取班级ID
		ClassService classService = new ClassServiceImpl();
		Classe cla = classService.FindClasseByname(classname);
		String ClassesID = cla.getClassesID();

		// 获取学院ID

		InstitutePronounService ins = new InstitutePronounServiceImpl();
		InstitutePronoun institute = ins.FindinstitutepronounByname(institutename);
		String InstituteID = institute.getInstitutePronoun();
		// 获取专业ID
		ProfessionService professionService = new ProfessionServiceImpl();
		Profession pro = professionService.FindProfessionByname(proname);
		String ProfessionID = pro.getProfessionID();

		student s = new student(StudentID, ClassesID, classname, StuentName, Sex, ProfessionID, InstituteID, proname,
				institutename);
		if (st.UpdateStudent(StudentID, s)) {
			System.out.println("StudentID:" + StudentID + "修改成功");
		} else {
			System.out.println("StudentID:" + StudentID + "修改失败");
		}
		response.sendRedirect("QueryAllStudentServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
