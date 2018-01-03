package digital.domain;

import java.util.List;

public class Board {
  // 게시글 번호
  private int boardNo;
  // 게시판 분류 (게시판 관리 페이지 참조 키)
  private int boardTypeNO;
  // 게시판 타입
  private String boardType;
  // 게시글 제목
  private String boardSubject;
  // 게시글 작성자
  private String boardWriter;
  // 게시글 내용
  private String boardContent;
  // 게시글 조회수
  private String boardHit;
  // 게시글 등록일
  private String boardDate;
  // 게시글 변경일
  private String boardUpdateDate;
  // 게시글 첨부파일 목록
  private List<String> boardFileList;
  // 게시글의 댓글 수
  private int reCount;
  // 작성, 수정 권한
  private String permission;
  
  @Override
  public String toString() {
    return "Board [boardNo=" + boardNo + ", boardTypeNO=" + boardTypeNO + ", boardType=" + boardType + ", boardSubject="
        + boardSubject + ", boardWriter=" + boardWriter + ", boardContent=" + boardContent + ", boardHit=" + boardHit
        + ", boardDate=" + boardDate + ", boardUpdateDate=" + boardUpdateDate + ", boardFileList=" + boardFileList + ", reCount="
        + reCount + ", permission=" + permission + "]";
  }

  public int getBoardNo() {
    return boardNo;
  }

  public void setBoardNo(int boardNo) {
    this.boardNo = boardNo;
  }

  public int getBoardTypeNO() {
    return boardTypeNO;
  }

  public void setBoardTypeNO(int boardTypeNO) {
    this.boardTypeNO = boardTypeNO;
  }

  public String getBoardType() {
    return boardType;
  }

  public void setBoardType(String boardType) {
    this.boardType = boardType;
  }

  public String getBoardSubject() {
    return boardSubject;
  }

  public void setBoardSubject(String boardSubject) {
    this.boardSubject = boardSubject;
  }

  public String getBoardWriter() {
    return boardWriter;
  }

  public void setBoardWriter(String boardWriter) {
    this.boardWriter = boardWriter;
  }

  public String getBoardContent() {
    return boardContent;
  }

  public void setBoardContent(String boardContent) {
    this.boardContent = boardContent;
  }

  public String getBoardHit() {
    return boardHit;
  }

  public void setBoardHit(String boardHit) {
    this.boardHit = boardHit;
  }

  public String getBoardDate() {
    return boardDate;
  }

  public void setBoardDate(String boardDate) {
    this.boardDate = boardDate;
  }

  public String getBoardUpdateDate() {
    return boardUpdateDate;
  }

  public void setBoardUpdateDate(String boardUpdateDate) {
    this.boardUpdateDate = boardUpdateDate;
  }

  public List<String> getBoardFileList() {
    return boardFileList;
  }

  public void setBoardFileList(List<String> boardFileList) {
    this.boardFileList = boardFileList;
  }

  public int getReCount() {
    return reCount;
  }

  public void setReCount(int reCount) {
    this.reCount = reCount;
  }

  public String getPermission() {
    return permission;
  }

  public void setPermission(String permission) {
    this.permission = permission;
  }

}