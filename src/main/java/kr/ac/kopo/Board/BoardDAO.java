package kr.ac.kopo.Board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.ConnectionFactory;

public class BoardDAO {

	public void writeBoard(BoardVO vo) {
	    StringBuilder sql = new StringBuilder();
	    sql.append("INSERT INTO board(board_No, USER_ID, title, contents, viewCnt, board_Time) ");
	    sql.append("VALUES(board_seq.nextval, ?, ?, ?, 0, SYSDATE)");

	    try (Connection conn = new ConnectionFactory().getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
	        pstmt.setString(1, vo.getUserId());
	        pstmt.setString(2, vo.getTitle());
	        pstmt.setString(3, vo.getContents());

	        pstmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public List<BoardVO> getBoardList() {
		List<BoardVO> boardList = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT BOARD_NO, USER_ID, TITLE, CONTENTS, BOARD_TIME, VIEWCNT FROM board ORDER BY BOARD_TIME ASC");
		
		try (Connection conn = new ConnectionFactory().getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			 ResultSet rs = pstmt.executeQuery()) {
			
			while (rs.next()) {
			    int boardNo = rs.getInt("board_No");
			    String userId = rs.getString("user_Id");
			    String title = rs.getString("title");
			    String contents = rs.getString("contents");
			    java.sql.Date boardTime = rs.getDate("board_Time");
			    int viewCnt = rs.getInt("viewCnt");

			    BoardVO board = new BoardVO(boardNo, userId, title, contents, boardTime, viewCnt);
			    boardList.add(board);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return boardList;
	}
	public BoardVO getBoardByNo(int boardNo) {
        BoardVO board = null;

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT BOARD_NO, USER_ID, TITLE, CONTENTS, BOARD_TIME, VIEWCNT ");
        sql.append("FROM board ");
        sql.append("WHERE BOARD_NO = ?");

        try (Connection conn = new ConnectionFactory().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
            pstmt.setInt(1, boardNo);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int no = rs.getInt("board_No");
                    String userId = rs.getString("user_Id");
                    String title = rs.getString("title");
                    String contents = rs.getString("contents");
                    Date boardTime = rs.getDate("board_Time");
                    int viewCnt = rs.getInt("VIEWCNT");
                    
                    board = new BoardVO();
                    board.setBoardNo(no);
                    board.setUserId(userId);
                    board.setTitle(title);
                    board.setContents(contents);
                    board.setBoardTime(boardTime);
                    board.setViewCnt(viewCnt);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return board;
    }

	  public void updateBoard(BoardVO vo) {
	        StringBuilder sql = new StringBuilder();
	        sql.append("UPDATE board SET title = ?, contents = ? WHERE  BOARD_NO = ?");

	        try (
	            Connection conn = new ConnectionFactory().getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	        ) {
	            pstmt.setString(1, vo.getTitle());
	            pstmt.setString(2, vo.getContents());
	            pstmt.setInt(3, vo.getBoardNo());

	            pstmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	  public void deleteBoard(int boardNo) {
	        StringBuilder sql = new StringBuilder();
	        sql.append("DELETE FROM board WHERE  BOARD_NO = ?");

	        try (
	            Connection conn = new ConnectionFactory().getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	        ) {
	            pstmt.setInt(1, boardNo);

	            pstmt.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	  public List<BoardVO> getAllBoards() {
	        List<BoardVO> boardList = new ArrayList<>();

	        try (
	            Connection conn = new ConnectionFactory().getConnection();
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery("SELECT * FROM board");
	        ) {
	            while (rs.next()) {
	                int boardNo = rs.getInt("boardNo");
	                String title = rs.getString("title");
	                String contents = rs.getString("contents");

	                BoardVO board = new BoardVO();
	                board.setBoardNo(boardNo);
	                board.setTitle(title);
	                board.setContents(contents);

	                boardList.add(board);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return boardList;
	    }
	
	
}