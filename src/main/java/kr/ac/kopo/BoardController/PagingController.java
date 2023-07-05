package kr.ac.kopo.BoardController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.Board.BoardDAO;
import kr.ac.kopo.Board.BoardVO;
import kr.ac.kopo.framework.Controller;

public class PagingController implements Controller {

   

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

    	BoardDAO boardDAO = new BoardDAO();
        int page = Integer.parseInt(request.getParameter("page")); // 현재 페이지 번호
        int totalCount = boardDAO.getTotalBoardCount(); // 전체 게시글 수

        int numPerPage = 10; // 페이지당 보여줄 게시글 수
  
        int startNum = (page - 1) * 10 + 1; // 시작 게시글 번호
        int endNum = startNum + 9; // 끝 게시글 번호

        List<BoardVO> boardList = boardDAO.getBoardListPaging(startNum, endNum);

        request.setAttribute("boardList", boardList);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPage", (totalCount - 1) / numPerPage + 1);
        
       return "/jsp/board/boardList.jsp";
    }
}
