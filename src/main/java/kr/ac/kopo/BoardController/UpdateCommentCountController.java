package kr.ac.kopo.BoardController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.Board.BoardDAO;
import kr.ac.kopo.framework.Controller;

public class UpdateCommentCountController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        // 게시글에 댓글 수를 업데이트하는 로직을 작성
        
        // 게시글 번호와 댓글 수를 파라미터로 받아옵니다.
        int boardNo = Integer.parseInt(request.getParameter("boardNo"));
        int commentCount = Integer.parseInt(request.getParameter("commentCount"));
        
        // 게시글에 댓글 수를 업데이트합니다.
        BoardDAO boardDAO = new BoardDAO();
        boardDAO.updateCommentCount(boardNo, commentCount);
        
        // 업데이트 후에는 다른 작업이 필요한 경우에 진행
        
        return "redirect:/MyBanking/boardList.do"; // 업데이트 성공 페이지로 이동
    }
}