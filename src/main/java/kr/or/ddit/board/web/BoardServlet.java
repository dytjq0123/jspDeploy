package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet(urlPatterns={"/boardList","/boardInsert"})
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시글 조회
		BoardServiceInf boardService = new BoardService();
		List<BoardVo> boardList = boardService.getBoardList();
		
		HttpSession session = request.getSession();
		
		request.setAttribute("boardList", boardList);
//		for(BoardVo boardVo : boardList){
//			request.setAttribute("boardVo", boardVo);
//		}
		
		// 게시글 화면을 담당할 jsp로 역할을 위임 (/board/boardList.jsp)
		// forward
		RequestDispatcher rd = request.getRequestDispatcher("/board/boardList.jsp");
		rd.forward(request, response);
	}


}
