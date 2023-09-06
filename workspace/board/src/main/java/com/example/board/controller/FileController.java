package com.example.board.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.board.domain.vo.FileVO;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class FileController {
	
	@PostMapping(value="/upload",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody // 일반 컨트롤러에서 REST로 사용해야할 떄 작성
	public ResponseEntity<List<FileVO>> upload(MultipartFile[] uploadFiles){
		log.info("upload............................");
		
		List<FileVO> files = new ArrayList<FileVO>();
		String uploadDirectory = "C:\\upload";
		String uploadDatePath =getDirectoryForm();
		
		File uploadPath = new File(uploadDirectory, uploadDatePath);
		log.info("upload path : " + uploadPath);
		
		if(uploadPath.exists()) {
			uploadPath.mkdirs();
		}
		
		for(MultipartFile mutipartFile : mutipartFiles) {
			log.info("Upload File Name)
		}
		
	}
	
	public String getDirectoryForm() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy\\MM\\dd");
		Date today = new Date();
		return simpleDateFormat.format(today);
		
				
	}
}