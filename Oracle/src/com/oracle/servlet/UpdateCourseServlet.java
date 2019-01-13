package com.oracle.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.daomain.Course;
import com.oracle.daomain.InstitutePronoun;
import com.oracle.service.InstitutePronounService;
import com.oracle.service.impl.CourseServiceImpl;
import com.oracle.service.impl.InstitutePronounServiceImpl;

/**
 * Servlet implementation class UpdateCourseServlet
 */
@WebServlet("/UpdateCourseServlet")
public class UpdateCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String CourseID=request.getParameter("CourseID");
		String CourseName=request.getParameter("CourseName");
		//String BelongsInstituteID=request.getParameter("BelongsInstituteID");
		String BelongsInstituteName=request.getParameter("BelongsInstituteName");
		InstitutePronounService ins=new InstitutePronounServiceImpl();
		InstitutePronoun institute=ins.FindinstitutepronounByname(BelongsInstituteName);
		String BelongsInstituteID=institute.getInstitutePronoun();
		
		System.out.println(BelongsInstituteID);
		CourseServiceImpl cs=new CourseServiceImpl();
		Course c=new Course(CourseID,CourseName,BelongsInstituteID,BelongsInstituteName);
		if(cs.UpdateById(CourseID, c)) System.out.println("CourseID:"+CourseID+"更新成功");
		else System.out.println("CourseID:"+CourseID+"更新失败");
		response.sendRedirect("QueryAllCourseServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
