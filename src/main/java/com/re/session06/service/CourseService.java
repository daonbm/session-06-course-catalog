package com.re.session06.service;

import com.re.session06.dto.request.CourseRequest;
import com.re.session06.dto.response.CourseResponse;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

public interface CourseService {
    Page<CourseResponse> getCourses(int page,int size);
    CourseResponse uploadImage(Long id, MultipartFile file);
    void deleteImage(Long id);
}
