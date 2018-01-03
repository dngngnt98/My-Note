package digital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import digital.domain.Upload;
import digital.service.UploadService;
import digital.utils.FileSystem;

@Controller
@RequestMapping("/file")
public class FileController {

	@Autowired
	UploadService uploadService;
	
	@RequestMapping("form")
	public String form() {
		return "test/filetest";
	}
	
	@RequestMapping("insert")
	public void insert(MultipartFile file) throws Exception {
		
		Upload upload = new Upload();
		FileSystem fileSystem = new FileSystem();
		
		if(file != null) {
			String fileName = file.getOriginalFilename();
			String newFileName = fileSystem.newFileName();
			upload.setFileName(fileName);
			upload.setNewFileName(newFileName);
			uploadService.insert(upload);
			uploadService.fileUpload(file, newFileName);
		}
	}
}
