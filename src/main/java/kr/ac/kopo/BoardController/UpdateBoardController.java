package kr.ac.kopo.BoardController;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.Board.BoardDAO;
import kr.ac.kopo.Board.BoardVO;
import kr.ac.kopo.framework.Controller;

public class UpdateBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
			 try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			 int boardNo = Integer.parseInt(request.getParameter("boardNo"));

		        BoardDAO dao = new BoardDAO();
		        BoardVO board = dao.getBoardByNo(boardNo);

		        request.setAttribute("board", board);

		        return "/jsp/board/updateBoard.jsp";
	}
}
