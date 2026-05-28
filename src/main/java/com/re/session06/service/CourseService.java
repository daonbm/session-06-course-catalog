package com.re.session06.service;

import com.re.session06.dto.response.CourseResponse;
import org.springframework.data.domain.Page;

import java.util.List;


public interface CourseService {
    Page<CourseResponse> getCourses(int page,int size);
}
