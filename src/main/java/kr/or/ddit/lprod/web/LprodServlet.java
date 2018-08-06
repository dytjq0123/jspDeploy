package kr.or.ddit.lprod.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.lprod.service.LprodService;
import kr.or.ddit.lprod.service.LprodServiceInf;

/**
 * Servlet implementation class LprodServlet
 */
@WebServlet("/lprodList")
public class LprodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageStr = request.getParameter("page");
		int page = pageStr == null ? 1 : Integer.parseInt(pageStr);
		
		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = pageSizeStr == null ? 10 : Integer.parseInt(pageSizeStr);
		
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		
		LprodServiceInf lprodService = new LprodService();
		
		Map<String, Object> resultMap = lprodService.getLprodPageList(paramMap);
		
		List<LprodVo> lprodList = (List<LprodVo>) resultMap.get("pageList");
		request.setAttribute("lprodList", lprodList);
		
		String pageNavi = (String) resultMap.get("pageNavi");
		request.setAttribute("pageNavi", pageNavi);
		
		RequestDispatcher rd = request.getRequestDispatcher("/lprod/lprodList.jsp");
		rd.forward(request, response);
	}


}
