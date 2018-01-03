/** 게시판 관련 흐름 처리 **/
package digital.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import digital.domain.Board;
import digital.domain.Upload;
import digital.service.BoardService;
import digital.service.UploadService;
import digital.utils.FileSystem;
import digital.utils.Paging;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService boardService;
	@Autowired
	UploadService uploadService;

	// 게시글 작성 페이지
	@RequestMapping("write")
	public String boardWriteForm() {
		return "게시글 작성 URL";
	}
	
	// 게시글 수정 페이지
	@RequestMapping("upadte")
	public String updateForm() {
		return "게시글 수정 URL";
	}
	
	// 게시글 목록
	@RequestMapping("list")
	public String boardList(@RequestParam(defaultValue = "1") int curPage, Model model) throws Exception {
		Board board = new Board();
		// 게시물 수 계산
		int count = boardService.boardCount(board);
		// 페이지 처리관련 객체 생성 (생성자 활용)
		Paging paging = new Paging(curPage, count);
		// 게시물의 시작과 끝
		int start = paging.getStart();
		int end = paging.getEnd();
		
		List<Board> boardList = boardService.boardList(start, end);
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("count", count);
		model.addAttribute("paging", paging);
		
		return "게시글 목록 URL";
	}
	
	// 게시글 상세
	@RequestMapping("detail")
	public String detail(Integer boardNo, Model model, HttpSession session) throws Exception {
		// 해당 게시번호의 게시물의 상세 정보 model에 추가
		Board board = boardService.detail(boardNo);
		// 조회수 증가
		boardService.increaseHit(boardNo, session);
		// 게시글 정보가 없으면
		if (board == null) {
		      throw new Exception(boardNo+"게시물 없음");
		}
		// 모델 객체에 게시글 정보 추가
		model.addAttribute("board", board);
		return "게시글 상세 URL";
	}
	
	// 게시글 수정()
	@RequestMapping("update")
	public String update(Board board) throws Exception {
		boardService.update(board);
		return "redirect: 게시글 목록 URL";
	}
	
	// 게시글 작성(작성자: 현재 세션에 저장된 로그인 사용자)
	// 다중 업로드 끝!!!
	// 여기선 뷰에서 넘어온 파일에 대한 정보들을 파일 관리 테이블에 보내는 처리도 겸한다.
	// 각 기능마다 따로 처리를 해줘야해서
	// 이 부분을 하나도 따로 빼주어 통합할 계획이다.
	@RequestMapping("insert")
	public String insert(Board board, HttpSession session, MultipartFile[] file) throws Exception {
		
		Upload upload = new Upload();
		FileSystem fileSystem = new FileSystem();
		
		ArrayList<String> fileList = new ArrayList<>();
		
		for(MultipartFile fileItem : file) {
			if(fileItem != null) {
				// 원본파일 이름을 얻어온다.
				String fileName = fileItem.getOriginalFilename();
				// 새로운 파일 이름을 얻어온다.
				String newFileName = fileSystem.newFileName();
				// 저장될 파일 경로를 가져온다.
				String filePath = uploadService.fileUpload(fileItem, newFileName);
				upload.setFileName(fileName);
				upload.setNewFileName(newFileName);
				upload.setFilePath(filePath);
				// 이 부분은... 음.. 따로 컨트롤러에서 처리를 해줘야하나 고민중... 
				uploadService.insert(upload);
				fileList.add(filePath);
			}
		}
		// 업로드된 파일 목록 
		board.setBoardFileList(fileList);
		// 로그인 된 사용자의 아이디 
		String boardWriter = (String)session.getAttribute("bmasterEmail");
		// 작성자 프로퍼티 값에 넣어준다.
		board.setBoardWriter(boardWriter);
		boardService.insert(board);
		return "redirect: 게시글 목록 URL";
	}
	
	// 게시글 삭제(삭제 조건: 들어간 게시글 상세페이지의 해당 게시글 번호)
	@RequestMapping("delete")
	public String delete(int boardNo) throws Exception {
		boardService.delete(boardNo);
		return "redirect: 게시글 목록 URL";
	}
}
