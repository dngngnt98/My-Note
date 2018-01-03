package digital.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import digital.dao.ReplyDao;
import digital.domain.Reply;
import digital.service.ReplyService;

@Service
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	ReplyDao replyDao;

	@Override
	public List<Reply> replylist(int boardNo, int start, int end) {
		Map<String, Object> replyMap = new HashMap<>();
		replyMap.put("boardNo", boardNo);
		replyMap.put("start", start);
		replyMap.put("end", end);
		return replyDao.list(replyMap);
	}

	@Override
	public void insert(Reply reply) {
		replyDao.create(reply);
	}

	@Override
	public void update(Reply reply) {
		replyDao.update(reply);
	}

	@Override
	public void delete(int replyNo) {
		replyDao.delete(replyNo);
	}

	@Override
	public Integer count(int boardNo) {
		return replyDao.count(boardNo);
	}

}
