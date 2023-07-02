package kr.ac.kopo.BoardController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.Board.BoardDAO;
import kr.ac.kopo.Board.BoardVO;
import kr.ac.kopo.Comment.CommentDAO;
import kr.ac.kopo.Comment.CommentVO;
import kr.ac.kopo.framework.Controller;

public class GetBoardController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

			int boardNo = Integer.parseInt(request.getParameter("boardNo"));

	        // 게시글 조회
	        BoardDAO boardDAO = new BoardDAO();
	        BoardVO board = boardDAO.getBoardByNo(boardNo);
	        request.setAttribute("board", board);

	        boardDAO.updateViewCount(boardNo);
	        
	        // 댓글 조회
	        CommentDAO commentDAO = new CommentDAO();
	        List<CommentVO> commentList = commentDAO.getCommentListByBoardNo(boardNo);
	        request.setAttribute("commentList", commentList);

	        return "/jsp/board/getBoard.jsp";
	    }
}
