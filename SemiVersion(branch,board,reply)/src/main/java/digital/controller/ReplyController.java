package digital.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import digital.domain.Reply;
import digital.service.ReplyService;
import digital.utils.Paging;

@Controller
@RequestMapping("/reply")
public class ReplyController {

	@Autowired
	ReplyService replyService;
	
	// 댓글 목록(조건: 해당 게시글의 번호)
	// 페이징 처리를 합시다
	@RequestMapping("list")
	public String replyList(@RequestParam(defaultValue = "1") int curPage, @RequestParam int boardNo, Model model) throws Exception {
		// 게시물 수 계산
		int count = replyService.count(boardNo);
		// 페이지 처리관련 객체 생성 (생성자 활용)
		Paging paging = new Paging(curPage, count);
		// 게시물의 시작과 끝
		int start = paging.getStart();
		int end = paging.getEnd();
		
		List<Reply> replyList = replyService.replylist(boardNo, start, end);
		
		model.addAttribute("replyList", replyList);
		model.addAttribute("paging", paging);
		
		return "reply/list";
	}
	
	// 댓글 작성(작성자: 현재 세션에 저장된 사용자)
	@RequestMapping("insert")
	public void insert(Reply reply, HttpSession session) {
		// 현재 세션에 담겨져 있는 로그인 사용자
		String replyer = (String) session.getAttribute("bmasterEmail");
		// domain 객체에 댓글 작성자 넘겨줌
		reply.setReplyer(replyer);
		// 댓글 추가
		replyService.insert(reply);
	}
	
	// 댓글 수정
	@RequestMapping("update")
	public void update(Reply reply, HttpSession session) {
		// 현재 세션에 담겨져 있는 로그인 사용자
		String replyer = (String) session.getAttribute("bmasterEmail");
		// domain 객체에 댓글 작성자 넘겨줌
		reply.setReplyer(replyer);
		replyService.update(reply);
	}
	
	// 댓글 삭제
	@RequestMapping("delete")
	public void delete(int replyNo) {
		replyService.delete(replyNo);
	}
}
