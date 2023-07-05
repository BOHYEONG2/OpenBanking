package kr.ac.kopo.BoardController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.Board.BoardDAO;
import kr.ac.kopo.framework.Controller;

public class GetCommentCountController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        // 게시글의 댓글 수를 가져오는 로직을 작성
        
        // 게시글 번호를 파라미터로 받아옵니다.
        int boardNo = Integer.parseInt(request.getParameter("boardNo"));
        
        // 게시글의 댓글 수를 가져옵니다.
        BoardDAO boardDAO = new BoardDAO();
        int commentCount = boardDAO.getCommentCount(boardNo);
        
        // 조회된 댓글 수를 request 속성에 저장합니다.
        request.setAttribute("commentCount", commentCount);
        
        // 가져온 댓글 수를 활용하는 다른 작업을 진행
        
        return "redirect:/MyBanking/boardList.do"; // 댓글 수 표시를 위한 JSP 페이지로 이동
    }
}