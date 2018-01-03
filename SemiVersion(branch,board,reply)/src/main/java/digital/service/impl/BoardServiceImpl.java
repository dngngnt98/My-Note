package digital.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import digital.dao.BoardDao;
import digital.domain.Board;
import digital.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDao boardDao;

	@Override
	public List<Board> boardList(int start, int end) throws Exception {
		HashMap<String, Object> boardMap = new HashMap<>();
		boardMap.put("start", start);
		boardMap.put("end", end);
		// 확인
		System.out.println(boardMap);
		return boardDao.boardList(boardMap);
	}

	@Override
	public int boardCount(Board board) throws Exception {
		return boardDao.boardCount(board);
	}
	

	@Override
	public Board detail(Integer boardNo) throws Exception {
		System.out.println(boardNo);
		return boardDao.boardSelectOne(boardNo);
	}

	@Override
	public void insert(Board board) throws Exception {
		boardDao.insert(board);
	}
	
	@Override
	public void update(Board board) throws Exception {
		boardDao.update(board);
	}

	@Override
	public void delete(int boardNo) throws Exception {
		boardDao.delete(boardNo);
	}

	@Override
	public void increaseHit(int boardNo, HttpSession session) {
		// 조회를 시작한 시간 변수
		long clickTime = 0;
		// 첫 조회시 세션에는 아무런 조회 시간이 없기때문에 한번 걸러준다.
		if(session.getAttribute("clickTime_" + boardNo) != null) {
			clickTime = (long)session.getAttribute("clickTime_" + boardNo);
		}
		// 현재 시간을 구한다.
		long curTime = System.currentTimeMillis();
		// 열람 시간이 지나면 카운트 업!
		if(curTime - clickTime > 1 * 1000) {
			boardDao.increaseHit(boardNo);
			session.setAttribute("clickTime"+boardNo, curTime);
		}
	}
	
}