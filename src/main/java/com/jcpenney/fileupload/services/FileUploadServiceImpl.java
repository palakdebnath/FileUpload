package com.jcpenney.fileupload.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadServiceImpl implements FileUploadService{
	
	private Path location ;
	
	@Autowired
	public FileUploadServiceImpl(@Value("${uploadDirPath}") String uploadDirPath) {
		location = Paths.get(uploadDirPath);
	}
	
	@Override
	public void upload(MultipartFile file) {
		try {
            if (file.isEmpty()) {
                System.out.println("Failed to store empty file " + file.getOriginalFilename());
            }            
            //Delete file if it already exists            
            Files.deleteIfExists(this.location.resolve(file.getOriginalFilename()));
            Files.copy(file.getInputStream(), this.location.resolve(file.getOriginalFilename()));
        } catch (IOException e) {
        	//TODO : Remove 
        	e.printStackTrace();
        }		
	}

}
