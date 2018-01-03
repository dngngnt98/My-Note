package digital.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import digital.dao.BoardManageDao;
import digital.domain.BoardManage;
import digital.service.BoardManageService;

@Service
public class BoardManageServiceImpl implements BoardManageService {
	@Autowired
	BoardManageDao boardManageDao;

	@Override
	public void insert(BoardManage boardManage) {
		boardManageDao.insert(boardManage);
	}

	@Override
	public List<BoardManage> curBoardList(int start, int end) throws Exception {
		HashMap<String, Object> boardMap = new HashMap<>();
		boardMap.put("start", start);
		boardMap.put("end", end);
		return boardManageDao.curBoardList(boardMap);
	}

	@Override
	public int curBoardCount(BoardManage boardManage) {
		return boardManageDao.curBoardCount(boardManage);
	}

	@Override
	public void update(BoardManage boardManage) {
		boardManageDao.update(boardManage);
	}

	@Override
	public void delete(int boardManageNo) {
		boardManageDao.delete(boardManageNo);
	}

}
