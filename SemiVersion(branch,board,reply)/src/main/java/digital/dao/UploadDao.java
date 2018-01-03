package digital.dao;

import java.util.List;
import java.util.Map;

import digital.domain.Upload;

public interface UploadDao {
	// 업로드 파일 목록(관리 페이지에서 보여질 파일 목록)
	public List<Upload> list(Map<String, Object> fileMap);
	// 파일 업로드 
	public void insert(Upload upload);
	// 파일 수정
	public void update(Upload upload);
	// 파일 삭제
	public void delete(int uploadNo);
}
