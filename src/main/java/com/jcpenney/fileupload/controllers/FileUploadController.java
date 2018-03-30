package com.jcpenney.fileupload.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jcpenney.fileupload.services.FileUploadService;

@Controller
public class FileUploadController {
	private FileUploadService fileUploadService;
	
	@Autowired
    public FileUploadController(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }
	
	@GetMapping("/home")
	public String homepage(){
		return "home";
	}

	@PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
		
		fileUploadService.upload(file);

        return "success";
    }

}
