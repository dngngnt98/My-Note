package digital.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import digital.domain.Branch;
import digital.domain.BranchMaster;
import digital.service.BranchMasterService;
import digital.service.BranchService;

@Controller
@RequestMapping("/auth")
public class AuthControl {
	@Autowired
	BranchMasterService branchMasterService;
	BranchService branchService;

	@RequestMapping("form")
	public String form() {
	  return "auth/form";
	}

	@RequestMapping("index")
	public void index() {
	}

	@RequestMapping("login")
	public String login(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String userType = req.getParameter("userType");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		BranchMaster branchMaster = null;
		if (userType.equals("branchMaster")) {
			branchMaster = branchMasterService.getByEmailPassword(email, password);
		}

		if (branchMaster != null) { // 현재 상태 : 아이디는 저장되지만 로그인할때마다 기억하기 체크박스 눌러줘야 다음 로그인때 저장됨.
			HttpSession session = req.getSession();
			session.setAttribute("loginBranchMaster", branchMaster);
			String saveEmail = req.getParameter("saveEmail");
			if (saveEmail != null) {
				Cookie cookie2 = new Cookie("email", email);
				cookie2.setMaxAge(60 * 60 * 24 * 7);
				resp.addCookie(cookie2);
			} else {
				Cookie cookie2 = new Cookie("email", "");
				cookie2.setMaxAge(0);
				resp.addCookie(cookie2);
			}

			return "redirect:../auth/index";

		} else {
			return "auth/fail";
		}
	}

	@RequestMapping("logout")
	public String logout(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.getSession().invalidate();
		return "redirect:../auth/form";
	}

	@RequestMapping("mypage")
	public String mypage(int no, Model model) throws Exception {
		BranchMaster branchMaster = branchMasterService.get(no);
		Branch branch = branchService.get(no);
		if (branchMaster == null) {
			throw new Exception(no + "번 회원이 없습니다.");
		}
		model.addAttribute("branchMaster", branchMaster);
		model.addAttribute("branch", branch);
		return "auth/mypage";

	}

	@RequestMapping("signup")
	public void signup() {
	}

	@RequestMapping("add")
	public String add(BranchMaster branchMaster) throws Exception {

		branchMasterService.add(branchMaster);
		return "/auth/form";
	}

	@RequestMapping("update")
	public String update(BranchMaster branchMaster) throws Exception {

		branchMasterService.update(branchMaster);
		return "/auth/mypage";
	}

}
