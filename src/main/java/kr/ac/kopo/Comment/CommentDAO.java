package kr.ac.kopo.Comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.ConnectionFactory;

public class CommentDAO {

    public void writeComment(CommentVO vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO COMMENTS(comment_No, BOARD_NO, user_Id, contents, comment_Time) ");
        sql.append("VALUES(comment_seq.nextval, ?, ?, ?, SYSDATE)");

        try (
        	Connection conn = new ConnectionFactory().getConnection();
    		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
        	) {
            pstmt.setInt(1, vo.getBoardNo());
            pstmt.setString(2, vo.getUserId());
            pstmt.setString(3, vo.getContents());

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<CommentVO> getCommentListByBoardNo(int boardNo) {
        List<CommentVO> commentList = new ArrayList<>();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT COMMENT_NO, BOARD_NO, USER_ID, CONTENTS, COMMENT_TIME ");
        sql.append("FROM COMMENTS ");
        sql.append("WHERE BOARD_NO = ? ");
        sql.append("ORDER BY COMMENT_TIME DESC");

        try (Connection conn = new ConnectionFactory().getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
               pstmt.setInt(1, boardNo);

               try (ResultSet rs = pstmt.executeQuery()) {
                   while (rs.next()) {
                       int commentNo = rs.getInt("comment_No");
                       String userId = rs.getString("user_Id");
                       String contents = rs.getString("contents");
                       Date commentTime = rs.getTimestamp("comment_Time");

                       CommentVO comment = new CommentVO(commentNo, boardNo, userId, contents, commentTime);

                       commentList.add(comment);
                   }
               }
           } catch (Exception e) {
               e.printStackTrace();
           }

           return commentList;
       }
    
    public void updateComment(CommentVO vo) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE COMMENTS ");
        sql.append("SET CONTENTS = ?, COMMENT_TIME = SYSDATE ");
        sql.append("WHERE COMMENT_NO = ?");

        try (
            Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
        ) {
            pstmt.setString(1, vo.getContents());
            pstmt.setInt(2, vo.getCommentNo());

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteComment(int commentNo) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM COMMENTS ");
        sql.append("WHERE COMMENT_NO = ?");

        try (
            Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
        ) {
            pstmt.setInt(1, commentNo);

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}