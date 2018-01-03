package digital.dao;

import java.util.List;
import java.util.Map;

import digital.domain.Reply;

public interface ReplyDao {
  // 댓글 목록
  public List<Reply> list(Map<String, Object> replyMap);
  // 댓글 작성
  public void create(Reply reply);
  // 댓글 수정
  public void update(Reply reply);
  // 댓글 삭제
  public void delete(int replyNo);
  
  public Integer count(int boardNo);
}
