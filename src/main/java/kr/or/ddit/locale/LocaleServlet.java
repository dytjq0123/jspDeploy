package kr.or.ddit.locale;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LocaleServlet
 */
//@WebServlet("/localeSelect")
public class LocaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("userId", "brown");
		System.out.println(request.getParameter("locale"));
		String p = request.getParameter("locale");
		if(request.getParameter("locale") == null){
			p = "ko";
		}
		System.out.println(p);
		request.setAttribute("pa", p);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/jstl/localeSelect.jsp");
		rd.forward(request, response);
		
		
	}


}
