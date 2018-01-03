package digital.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import digital.domain.BoardManage;
import digital.service.BoardManageService;

@Controller
@RequestMapping("/boardmanage")
public class BoardManageController {

	@Autowired
	BoardManageService boardManageService;
	
	// 게시판 추가 생성 페이지
	@RequestMapping("add")
	public String boardManageAddForm() {
		return "게시판 추가 생성 페이지 URL";
	}
	
	// 생성된 게시판 정보 수정 페이지
	@RequestMapping("modify")
	public String boardManageModifyForm() {
		return "생성된 게시판 정보 수정 페이지 URL";
	}

	// 생성된 게시판 목록
	@RequestMapping("info")
	public String boardManagerList(@RequestParam(defaultValue = "1") int start, @RequestParam(defaultValue="10") int end,  Model model) throws Exception {

		List<BoardManage> boardInfo = boardManageService.curBoardList(start, end);

		model.addAttribute("boardInfo", boardInfo);

		return "board/boardmanage";
	}
	
	// 게시판 추가 생성
	@RequestMapping("insert")
	public String insert(BoardManage boardManage, HttpSession session) {
		session.getAttribute("boardManager");
		boardManage.getBoardManager();
		boardManageService.insert(boardManage);
		return "redirect: board/boardmanage";
	}
	
	// 생성된 게시판 정보 수정(사용 권한, 타입 등..)
	@RequestMapping("update")
	public String update(BoardManage boardManage) {
		boardManageService.update(boardManage);
		return "redirect: board/boardmanage";
	}
	
	// 생성된 게시판 삭제(삭제시 완전 삭제는 아니고 업데이트 방식으로)
	@RequestMapping("delete")
	public String delete(int boardManageNo) {
		boardManageService.delete(boardManageNo);
		return "redirect: board/boardmanage";
	}
}
