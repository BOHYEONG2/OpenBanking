package kr.ac.kopo.BoardController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.Board.BoardDAO;
import kr.ac.kopo.framework.Controller;

public class DeleteBoardController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		int boardNo = Integer.parseInt(request.getParameter("boardNo"));

        BoardDAO boardDAO = new BoardDAO();
        boardDAO.deleteBoard(boardNo);

		return "/jsp/board/boardList.jsp";
	}
}
