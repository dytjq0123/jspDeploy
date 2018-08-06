package kr.or.ddit.ctag;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.service.StudentServiceInf;

/**
 * Servlet implementation class CustomtagServlet
 */
@WebServlet("/customtag")
public class CustomtagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//학생 1페이지 리스트 조회
		Map<String, Integer> map = new HashMap<String, Integer>();
		int page = 1;
		int pageSize = 10;
		map.put("page", page);
		map.put("pageSize", pageSize);
		
		//request 객체 속성 설정
		StudentServiceInf studentService = new StudentService();
		Map<String, Object> resultMap = studentService.getStudentPageList(map);
		request.setAttribute("studentList", resultMap.get("pageList"));
		
		//ctag.jsp로 전달 (forward)
		request.getRequestDispatcher("/jsp/ctag/ctag.jsp").forward(request, response);
	}


}
