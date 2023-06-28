package kr.ac.kopo.Comment;

import java.util.Date;

public class CommentVO {
	
	private int commentNo;
	private int boardNo;
	private String userId;
	private String contents;
	private Date commentTime;
	    
	public CommentVO(int commentNo, int boardNo, String userId, String contents, Date commentTime) {
		super();
		this.commentNo = commentNo;
		this.boardNo = boardNo;
		this.userId = userId;
		this.contents = contents;
		this.commentTime = commentTime;
	}
	    
	

	public CommentVO() {
		super();
	}



	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

	@Override
	public String toString() {
		return "CommentVO [commentNo=" + commentNo + ", boardNo=" + boardNo + ", userId=" + userId + ", contents="
				+ contents + ", commentTime=" + commentTime + "]";
	}
}