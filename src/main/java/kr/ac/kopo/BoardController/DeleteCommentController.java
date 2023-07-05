package kr.ac.kopo.BoardController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.Comment.CommentDAO;
import kr.ac.kopo.framework.Controller;

public class DeleteCommentController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
/*        int commentNo = Integer.parseInt(request.getParameter("commentNo"));

        CommentDAO commentDAO = new CommentDAO();
        commentDAO.deleteComment(commentNo);

        // 댓글 삭제 후의 동작을 정의하고 리턴할 페이지를 설정합니다.
        // 예를 들어, 게시글 상세 페이지로 리다이렉트할 수 있습니다.
 */
    	String[] commentNos = request.getParameterValues("commentNo");

        CommentDAO commentDAO = new CommentDAO();
        for (String commentNo : commentNos) {
            int num = Integer.parseInt(commentNo);
            commentDAO.deleteComment(num);
            System.out.println("commentNo: " + commentNo);
        }
        return "/jsp/board/getBoard.jsp";
       
    }
}