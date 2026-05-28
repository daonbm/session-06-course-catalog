package com.re.session06.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
    String storeImage(MultipartFile file);
    void deleteFileByUrl(String imageUrl);
}
