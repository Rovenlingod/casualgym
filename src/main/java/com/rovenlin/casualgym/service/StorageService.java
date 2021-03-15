package com.rovenlin.casualgym.service;

import com.rovenlin.casualgym.dtos.FileResponseDTO;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

    FileResponseDTO store(MultipartFile multipartFile);
    Resource loadAsResource(String filename);
}
