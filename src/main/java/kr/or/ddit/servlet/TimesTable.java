package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TimesTable
 */
@WebServlet("/TimesTable")
public class TimesTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimesTable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.write("<!DOCTYPE html>");
		pw.write("<html>");
		pw.write("<head>");
		pw.write("<meta charset=\"UTF-8\">");
		pw.write("<title>Inset title here</title>");
		pw.write("<style>");
		pw.write("td{border : 1px solid blue}");
		pw.write("</style>");
		pw.write("</head>");
		pw.write("<body>");
		pw.write("<h2>GuGuDan</h2>");
		pw.write("<Table>");
		for(int i = 1; i < 10; i++){
			pw.write("<tr>");
			for(int j = 1; j < 10; j++){
				pw.write("<td>"+i+"*"+j+"="+i*j+"</td>");
				
			}
			pw.write("</tr>");
		}
		pw.write("</Table>");
		pw.write("</body>");
		pw.write("</head>");
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
