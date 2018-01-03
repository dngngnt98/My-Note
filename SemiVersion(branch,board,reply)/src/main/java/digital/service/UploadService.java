package digital.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import digital.domain.Upload;

public interface UploadService {
	// 실제 파일 업로드 처리
	public String fileUpload(MultipartFile file, String newFileName) throws Exception;
	// 파일 목록(모든 리스트 형식은 페이징 처리를 해주자!!!)
	public List<Upload> uploadList(int start, int end);
	// 파일 데이터 추가
	public void insert(Upload upload);
	// 파일 수정
	public void update(Upload upload);
	// 파일 삭제
	public void delete(int uploadNo);
}
