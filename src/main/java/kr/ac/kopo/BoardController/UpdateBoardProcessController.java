package kr.ac.kopo.BoardController;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.Board.BoardDAO;
import kr.ac.kopo.Board.BoardVO;
import kr.ac.kopo.framework.Controller;

public class UpdateBoardProcessController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        int boardNo = Integer.parseInt(request.getParameter("boardNo"));
        String title = request.getParameter("title");
        String contents = request.getParameter("contents");

        BoardVO vo = new BoardVO();
        vo.setBoardNo(boardNo);
        vo.setTitle(title);
        vo.setContents(contents);

        BoardDAO dao = new BoardDAO();
        dao.updateBoard(vo);
        
        // 게시글 수정 후에 게시글 목록을 업데이트하여 boardList 속성 설정
        List<BoardVO> boardList = dao.getAllBoards();
        request.setAttribute("boardList", boardList);
        // 이거 안해줘서 계속 제목이 사라졌음 null이 나오거나 

        // 수정 후에 필요한 처리나 페이지로 리다이렉트 등을 수행

        return "redirect:/MyBanking/boardList.do";
    }
}