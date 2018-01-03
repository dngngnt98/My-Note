package digital.domain;

import java.util.Date;

public class Upload {
  private int uploadNo;
  // 게시판 참조
  private int boardNo;
  // 지점 참조
  private int branchNo;
  // 메뉴 참조
  private int menuNo;
  // 원본 파일명
  private String fileName;
  // 새로운 파일명
  private String newFileName;
  private String filePath;
  // 업로드 날짜
  private Date uploadDate;
  // 수정 날짜
  private Date updateDate;
  // 파일 삭제 여부
  private String delCheck;

  @Override
  public String toString() {
    return "Upload [uploadNo=" + uploadNo + ", boardNo=" + boardNo + ", branchNo=" + branchNo + ", menuNo=" + menuNo
        + ", fileName=" + fileName + ", newFileName=" + newFileName + ", filePath=" + filePath + ", uploadDate="
        + uploadDate + ", updateDate=" + updateDate + ", delCheck=" + delCheck + "]";
  }

  public int getUploadNo() {
    return uploadNo;
  }

  public void setUploadNo(int uploadNo) {
    this.uploadNo = uploadNo;
  }

  public int getBoardNo() {
    return boardNo;
  }

  public void setBoardNo(int boardNo) {
    this.boardNo = boardNo;
  }

  public int getMenuNo() {
    return menuNo;
  }

  public void setMenuNo(int menuNo) {
    this.menuNo = menuNo;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getNewFileName() {
    return newFileName;
  }

  public void setNewFileName(String newFileName) {
    this.newFileName = newFileName;
  }

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public Date getUploadDate() {
    return uploadDate;
  }

  public void setUploadDate(Date uploadDate) {
    this.uploadDate = uploadDate;
  }

  public Date getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }

  public String getDelCheck() {
    return delCheck;
  }

  public void setDelCheck(String delCheck) {
    this.delCheck = delCheck;
  }

  public int getBranchNo() {
    return branchNo;
  }

  public void setBranchNo(int branchNo) {
    this.branchNo = branchNo;
  }

}
