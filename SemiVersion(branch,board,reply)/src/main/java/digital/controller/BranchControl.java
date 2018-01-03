package digital.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import digital.domain.Branch;
import digital.domain.Upload;
import digital.service.BranchService;
import digital.service.UploadService;
import digital.utils.FileSystem;
import digital.utils.Paging;

@Controller
@RequestMapping("/branch")
public class BranchControl {

  @Autowired
  BranchService branchService;
  @Autowired
  ServletContext servletContext;
  @Autowired
  UploadService uploadService;

  @RequestMapping("list")
  public String list(@RequestParam(defaultValue = "1") int curPage, Model model) throws Exception {

    Branch branch = new Branch();
    // 게시물 수 계산
    int count = branchService.count(branch);
    // 처음에 지점이 단 하나도 등록 되지 않았으므로 
    if(count == 0) {
    	return "branch/list2";
    }
    // 페이지 처리관련 객체 생성 (생성자 활용)
    Paging paging = new Paging(curPage, count);
    // 게시물의 시작과 끝
    int start = paging.getStart();
    int end = paging.getEnd();
    
    List<Branch> branchList = branchService.list(start, end);
    
    model.addAttribute("branchList", branchList);
    model.addAttribute("count", count);
    model.addAttribute("paging", paging);

    return "branch/list2";
  }
  
  @RequestMapping("registpage")
  public String registPage() {
	  return "branch/add";
  }
  
  @RequestMapping("add")
  public String add(Branch branch, MultipartFile[] photo) throws Exception {
    FileSystem fileSystem = new FileSystem();
    Upload upload = new Upload();
    int branchNo = branch.getNo();
    upload.setBranchNo(branchNo);
    ArrayList<String> photoList = new ArrayList<>();
    for (MultipartFile fileItem : photo) {
      if (fileItem != null) {
        String fileName = fileItem.getOriginalFilename();
        String newFileName = fileSystem.newFileName();
        upload.setFileName(fileName);
        upload.setNewFileName(newFileName);
        uploadService.insert(upload);
        uploadService.fileUpload(fileItem, newFileName);
      }
    }
    branch.setPhotoList(photoList);
    branchService.add(branch);
    return "redirect:branch/list2";
  }

  @RequestMapping("update")
  public String update(Branch branch, MultipartFile[] photo) throws Exception {
    FileSystem fileSystem = new FileSystem();
    Upload upload = new Upload();
    int branchNo = branch.getNo();
    upload.setBranchNo(branchNo);

    ArrayList<String> photoList = new ArrayList<>();
    for (MultipartFile fileItem : photo) {
      if (fileItem != null) {
        String fileName = fileItem.getOriginalFilename();
        String newFileName = fileSystem.newFileName();
        upload.setFileName(fileName);
        upload.setNewFileName(newFileName);
        uploadService.insert(upload);
        uploadService.fileUpload(fileItem, newFileName);
      }
    }
    branch.setPhotoList(photoList); // 업로드 한 사진 파일명을 저장한다.

    branchService.update(branch);
    return "redirect:branch/list2";
  }

  @RequestMapping("detail")
  public String detail(int no, Model model) throws Exception {
    Branch branch = branchService.get(no);
    if (branch == null) {
      throw new Exception(no + "번 회원이 없습니다.");
    }
    model.addAttribute("branch", branch);
    return "branch/detail";
  }

  @RequestMapping("delete")
  public String delete(int no) throws Exception {
    branchService.remove(no);
    return "redirect:branch/list2";
  }

}
