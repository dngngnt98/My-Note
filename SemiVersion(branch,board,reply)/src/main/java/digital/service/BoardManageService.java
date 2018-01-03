package digital.service;

import java.util.List;

import digital.domain.BoardManage;

public interface BoardManageService {
	// 게시판 추가 생성
	public void insert(BoardManage boardManage);
	// 등록된 게시판 관리
	public List<BoardManage> curBoardList(int start, int end) throws Exception;
	// 등록된 게시판 수
	public int curBoardCount(BoardManage boardManage);
	// 등록된 게시판 정보 수정
	public void update(BoardManage boardManage);
	// 등록된 게시판 삭제
	public void delete(int boardManageNo);
}
