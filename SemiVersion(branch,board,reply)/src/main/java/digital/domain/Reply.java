package digital.domain;

import java.sql.Date;

public class Reply extends Board {
	// 댓글 번호
	private int replyNo;
	// 댓글 작성된 해당 게시글 번호(게시판 테이블 참조)
	private int boardNo;
	// 댓글 내용
	private String replyContent;
	// 댓글 작성자 
	private String replyer;
	// 댓글 작성일
	private Date replyDate;
	// 댓글 수정일
	private Date replyUpDate;

	@Override
	public String toString() {
		return "Reply [replyNo=" + replyNo + ", boardNo=" + boardNo + ", replyContent=" + replyContent + ", replyer="
				+ replyer + ", replyDate=" + replyDate + ", replyUpDate=" + replyUpDate + "]";
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getReplyer() {
		return replyer;
	}

	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}

	public Date getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}

	public Date getReplyUpDate() {
		return replyUpDate;
	}

	public void setReplyUpDate(Date replyUpDate) {
		this.replyUpDate = replyUpDate;
	}

}
