package digital.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import digital.domain.Board;


public interface BoardService {
	// 작성된 게시글 목록 
	public List<Board> boardList(int start, int end) throws Exception;
	// 작성된 게시글 카운트(페이징용)
	public int boardCount(Board board) throws Exception;
	// 게시글 상세 보기
	public Board detail(Integer boardNo) throws Exception;
	// 게시글 작성
	public void insert(Board board) throws Exception;
	// 게시글 수정
	public void update(Board board) throws Exception;
	// 게시글 삭제
	public void delete(int boardNo) throws Exception;
	// 조회수 증가
	public void increaseHit(int boardNo, HttpSession session);
}
