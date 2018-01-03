package digital.domain;

import java.util.Date;

public class BoardManage {
	// 관리 게시판 분류 번호
	private int boardManageNo;
	// 관리자 번호
	private int adminNo;
	// 게시판 생성자
	private String boardManager;
	// 게시판 분류(현재 공지, 일반, 질의)
	private String boardType;
	// 게시판 생성일
	private Date createDate;
	// 게시판 정보 수정일
	private Date createUpDate;
	// 게시판 제거 유무 확인
	private String deleteCheck;
	private String manageContent;

	@Override
	public String toString() {
		return "BoardManage [boardManageNo=" + boardManageNo + ", adminNo=" + adminNo + ", boardManager=" + boardManager
				+ ", boardType=" + boardType + ", createDate=" + createDate + ", createUpDate=" + createUpDate
				+ ", deleteCheck=" + deleteCheck + ", manageContent=" + manageContent + "]";
	}

	public int getBoardManageNo() {
		return boardManageNo;
	}

	public void setBoardManageNo(int boardManageNo) {
		this.boardManageNo = boardManageNo;
	}

	public int getAdminNo() {
		return adminNo;
	}

	public void setAdminNo(int adminNo) {
		this.adminNo = adminNo;
	}

	public String getBoardManager() {
		return boardManager;
	}

	public void setBoardManager(String boardManager) {
		this.boardManager = boardManager;
	}

	public String getBoardType() {
		return boardType;
	}

	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getCreateUpDate() {
		return createUpDate;
	}

	public void setCreateUpDate(Date createUpDate) {
		this.createUpDate = createUpDate;
	}

	public String getDeleteCheck() {
		return deleteCheck;
	}

	public void setDeleteCheck(String deleteCheck) {
		this.deleteCheck = deleteCheck;
	}

	public String getManageContent() {
		return manageContent;
	}

	public void setManageContent(String manageContent) {
		this.manageContent = manageContent;
	}

}
