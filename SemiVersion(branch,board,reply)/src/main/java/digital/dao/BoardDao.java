package digital.dao;

import java.util.List;
import java.util.Map;

import digital.domain.Board;

public interface BoardDao {
  // 게시판 리스트
  public List<Board> boardList(Map<String,Object> branchMap);
  // 관리 페이지 게시판 목록
  public List<Board> adminBoard(Map<String,Object> boardMap);
  // 게시판 개시글 총 갯수
  public int boardCount(Board baord);
  // 상세 보기
  public Board boardSelectOne(Integer boardNo);
  // 게시글 수정
  public void update(Board board);
  // 게시글 삭제
  public void delete(int boardNo);
  // 게시글 작성
  public void insert(Board board);
  // 조회수 증가
  public void increaseHit(int boardNo);
}
