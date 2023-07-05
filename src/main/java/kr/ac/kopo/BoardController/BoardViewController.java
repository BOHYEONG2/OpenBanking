package kr.ac.kopo.BoardController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.Board.BoardDAO;
import kr.ac.kopo.Board.BoardVO;
import kr.ac.kopo.framework.Controller;

public class BoardViewController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        // 게시글 번호를 파라미터로 받아옵니다.
        int boardNo = Integer.parseInt(request.getParameter("boardNo"));

        // 예시로 게시글 정보를 가져오는 코드를 작성합니다.
        BoardDAO dao = new BoardDAO();
        BoardVO board = dao.getBoardByNo(boardNo);

        // 게시글을 조회할 때마다 조회수를 증가시킵니다.
        dao.updateViewCount(boardNo);

        // 조회된 게시글 정보를 request 속성에 저장합니다.
        request.setAttribute("board", board);

        // 게시글을 보여주는 JSP 페이지로 포워딩합니다.
        return "/jsp/board/boardList.jsp";
    }
}