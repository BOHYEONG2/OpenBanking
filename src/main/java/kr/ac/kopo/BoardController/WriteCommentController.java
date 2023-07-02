package kr.ac.kopo.BoardController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.Board.BoardDAO;
import kr.ac.kopo.Comment.CommentDAO;
import kr.ac.kopo.Comment.CommentVO;
import kr.ac.kopo.Member.MemberVO;
import kr.ac.kopo.framework.Controller;

public class WriteCommentController implements Controller {

	  @Override
	    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
	        // 요청으로부터 게시글 번호와 댓글 내용을 가져옵니다.
	        int boardNo = Integer.parseInt(request.getParameter("boardNo"));
	        String contents = request.getParameter("contents");

	        HttpSession session = request.getSession();
	     //   String userId = (String) session.getAttribute("id");
	        MemberVO login = (MemberVO) session.getAttribute("loginUser");
	        String userID = login.getId();
	        
	        System.out.println("user : " + userID);
	        // CommentVO 객체를 생성하고 게시글 번호와 댓글 내용을 설정합니다.
	        CommentVO comment = new CommentVO();
	        comment.setBoardNo(boardNo);
	        comment.setUserId(userID);
	        System.out.println(userID);
	        comment.setContents(contents);

	        // CommentDAO 객체를 생성하고 writeComment 메서드를 호출하여 댓글을 등록합니다.
	        CommentDAO commentDAO = new CommentDAO();
	        commentDAO.writeComment(comment);
	        System.out.println(comment);
	        // 댓글 등록 후 게시글의 댓글 수를 업데이트합니다.
	        BoardDAO boardDAO = new BoardDAO();
	        int commentCount = commentDAO.getCommentCountByBoardNo(boardNo);
	        boardDAO.updateCommentCount(boardNo, commentCount);

	        // 댓글 등록 후 게시글 상세 페이지로 이동합니다.
	        return "redirect:/MyBanking/getBoard.do?boardNo=" + boardNo;
	    }
	}