package kr.or.ddit.jstl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.locale.LocaleWrapper;

/**
 * Servlet implementation class LocaleSelectServlet
 */
@WebServlet("/localeSelect")
public class LocaleSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		LocaleWrapper localeWrapper = new LocaleWrapper(request);
//		String locale = localeWrapper.getParameter("locale");
//		//String locale = request.getParameter("locale");
//		locale = locale == null ? "ko" : locale;
//		
//		request.setAttribute("locale", locale);
		
		request.getRequestDispatcher("/jsp/jstl/locale/localeSelect.jsp").forward(request, response);
		
		
		
	}


}
