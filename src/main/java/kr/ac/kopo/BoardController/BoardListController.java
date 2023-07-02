package kr.ac.kopo.BoardController;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.Board.BoardDAO;
import kr.ac.kopo.Board.BoardVO;
import kr.ac.kopo.Member.MemberVO;
import kr.ac.kopo.framework.Controller;

public class BoardListController implements Controller {
	
	  @Override
	    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
	        // 게시글 목록 조회 및 처리하는 로직을 작성
	        HttpSession session = request.getSession();
	        MemberVO login = (MemberVO) session.getAttribute("loginUser");
	        String userID = login.getId();
	        
	        
	        boolean isLoggedIn = (login != null);
	        request.setAttribute("isLoggedIn", isLoggedIn);

	        // 페이지 번호와 페이지당 게시글 수를 설정합니다.
	        int pageNo = 1; // 기본값은 1
	        int numPerPage = 10; // 페이지당 10개의 게시글 표시

	        String searchType = request.getParameter("searchType");
	        String keyword = request.getParameter("keyword");
	        // 파라미터로 전달된 페이지 번호가 있다면 설정합니다.
	        String pageNoStr = request.getParameter("pageNo");
	        if (pageNoStr != null && !pageNoStr.isEmpty()) {
	            pageNo = Integer.parseInt(pageNoStr);
	        }
	        
	        // 게시글 목록을 조회합니다.
	        BoardDAO dao = new BoardDAO();
	        List<BoardVO> boardList;
	        
	        if (searchType != null && searchType.equals("id") && keyword != null && !keyword.isEmpty()) {
	            // 아이디 검색 조건이 있는 경우 해당 아이디를 작성자로 가지는 게시글만 조회합니다.
	            boardList = dao.getBoardListByUserId(keyword, pageNo, numPerPage);
	        } else {
	            // 일반적인 게시글 목록 조회
	            boardList = dao.getBoardListPaging(pageNo, numPerPage);
	        }
	        
	        // 각 게시글의 댓글 수를 가져와서 BoardVO 객체에 추가적인 필드로 저장합니다.
	        for (BoardVO board : boardList) {
	            int commentCount = dao.getCommentCount(board.getBoardNo());
	            board.setCommentCount(commentCount);
	        }
	        
	        // 전체 게시글 수를 조회합니다.
	        int totalCount = dao.getTotalBoardCount();

	        // 전체 페이지 수를 계산합니다.
	        int totalPages = (int) Math.ceil((double) totalCount / numPerPage);

	        // 마지막 페이지 번호를 설정합니다.
	       // int lastPage = Math.max(totalPages, 1);
	        int lastPage = 0;
	        if (totalPages > 0) {
	            lastPage = totalPages;
	        }

	        // 조회된 게시글 목록을 request 속성에 저장합니다.
	        request.setAttribute("boardList", boardList);
	        request.setAttribute("pageNo", pageNo);
	        request.setAttribute("lastPage", lastPage);

	        // 게시글 목록을 보여주는 JSP 페이지로 포워딩합니다.
	        return "/jsp/board/boardList.jsp";
	    }
	}
