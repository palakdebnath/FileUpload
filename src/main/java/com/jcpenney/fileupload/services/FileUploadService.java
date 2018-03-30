package com.jcpenney.fileupload.services;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

	void upload(MultipartFile file);
}
