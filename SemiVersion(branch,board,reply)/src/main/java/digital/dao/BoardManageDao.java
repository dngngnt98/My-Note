package digital.dao;

import java.util.List;
import java.util.Map;

import digital.domain.BoardManage;

public interface BoardManageDao {
	// 게시판 종류 생성
	public void insert(BoardManage boardManage);
	// 관리 게시판 목록
	public List<BoardManage> curBoardList(Map<String, Object> boardMap);
	// 현재 생성된 게시판 수
	public int curBoardCount(BoardManage boardManage);
	// 생성된 게시판 정보 수정
	public void update(BoardManage boardManage);
	// 생성된 게시판 삭제
	public void delete(int boardManageNo);
}
