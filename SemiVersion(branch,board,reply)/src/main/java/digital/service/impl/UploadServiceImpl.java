package digital.service.impl;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import digital.dao.UploadDao;
import digital.domain.Upload;
import digital.service.UploadService;
import digital.utils.FileSystem;

@Service
public class UploadServiceImpl implements UploadService {

	@Autowired
	UploadDao uploadDao;
	
	// 파일 디렉토리에 관련된 모든 경로(아 이거 어떻게 처리해주냐 ㅡㅡ;; 깔금하게 ㅁㄴ;이ㅏ럼;닝라ㅏㅓ)
	private final static String PATH = "/upload";
	private final static String PATH2 = "/upload/branch";
	private final static String PATH3 = "/upload/menu";
	private final static String PATH4 = "/upload/user";
	private final static String PATH5 = "/upload/docs";
	private final static String PATH6 = "/upload/iot";
	private final static String DIR = "c:/webupload/";

	@Override
	public String fileUpload(MultipartFile file, String newFileName) throws Exception {
		FileSystem fileSystem = new FileSystem();
		if (file.isEmpty()) {
			return null;
		}
		// 프로젝트 파일의 경로
		// String realPath = session.getServletContext().getRealPath(PATH3);
		String fileName = file.getOriginalFilename();
		String type = fileSystem.fileFormat(fileName);
		File filePath = new File(DIR + newFileName);
		// 자 디렉토리 별 처리를 한번 해봅시다!!
		// 예상되는 경로는 위의 경로들 자 이 디렉토리들을 케이스문으로 처리하느냐
		// 아니면 걍 이프문으로 처리 하느냐....

		// 파일의 경로로 파일 날려줌
		file.transferTo(filePath);
		// 확장자가 이미지 파일이면
		if (fileSystem.getMediaType(type) != null) {
			// 썸네일 파일 생성
			BufferedImage sourceImg = ImageIO.read(new File(DIR + newFileName));
			BufferedImage thumbImg = new BufferedImage(300, 300, BufferedImage.TYPE_3BYTE_BGR);
			Graphics2D graphic = thumbImg.createGraphics();
			graphic.drawImage(sourceImg, 0, 0, 300, 300, null);
			String thumbName = DIR + fileSystem.thumbName() + "." + type;
			File thumbNail = new File(thumbName);
			ImageIO.write(thumbImg, type.toUpperCase(), thumbNail);
			return thumbName;
		}
		return newFileName;
	}

	public void insert(Upload upload) {
		uploadDao.insert(upload);
	}
	
	@Override
	public List<Upload> uploadList(int start, int end) {
		// 새로운 맵 객체를 생성
		Map<String, Object> fileMap = new HashMap<>();
		// 맴에 행의 시작과 끝 put
		fileMap.put("start", start);
		fileMap.put("end", end);
		// Dao 객체에 맵 리턴
		return uploadDao.list(fileMap);
	}
	
	@Override
	public void update(Upload upload) {
		uploadDao.update(upload);
	}

	@Override
	public void delete(int uploadNo) {
		uploadDao.delete(uploadNo);
	}

}
