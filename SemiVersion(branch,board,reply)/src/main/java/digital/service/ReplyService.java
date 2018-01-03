package digital.service;

import java.util.List;

import digital.domain.Reply;

public interface ReplyService {
	// 댓글 목록
	public List<Reply> replylist(int boardNo, int start, int end);
	// 댓글 작성
	public void insert(Reply reply);
	// 댓글 수정
	public void update(Reply reply);
	// 댓글 삭제
	public void delete(int replyNo);
	
	public Integer count(int boardNo);
}
