package kr.ac.kopo.BoardController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.Board.BoardDAO;
import kr.ac.kopo.Board.BoardVO;
import kr.ac.kopo.framework.Controller;

public class BoardListController implements Controller {

		@Override
		public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		     // 게시글 목록 조회 및 처리하는 로직을 작성
	        
	        // 예시로 게시글 목록을 가져오는 코드를 작성합니다.
	        BoardDAO dao = new BoardDAO();
	        List<BoardVO> boardList = dao.getBoardList();
	        
	        // 조회된 게시글 목록을 request 속성에 저장합니다.
	        request.setAttribute("boardList", boardList);
	        
	        // 게시글 목록을 보여주는 JSP 페이지로 포워딩합니다.
	        return "/jsp/board/boardList.jsp";
	    }
	}