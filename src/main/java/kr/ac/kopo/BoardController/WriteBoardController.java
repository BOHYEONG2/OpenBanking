package kr.ac.kopo.BoardController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.Board.BoardDAO;
import kr.ac.kopo.Board.BoardVO;
import kr.ac.kopo.Member.MemberVO;
import kr.ac.kopo.framework.Controller;

public class WriteBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
			HttpSession session = request.getSession();
	        MemberVO login = (MemberVO) session.getAttribute("loginUser");
	        String writerID = login.getId();

	        String title = request.getParameter("title");
	        String contents = request.getParameter("contents");

	        BoardVO vo = new BoardVO();
	        vo.setTitle(title);
	        vo.setUserId(writerID);
	        vo.setContents(contents);

	        BoardDAO dao = new BoardDAO();
	        dao.writeBoard(vo);

	        return "/jsp/board/boardList.jsp";
	    }
	}