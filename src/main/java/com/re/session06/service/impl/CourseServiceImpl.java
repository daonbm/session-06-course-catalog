package com.re.session06.service.impl;

import com.re.session06.dto.response.CourseResponse;
import com.re.session06.entity.Course;
import com.re.session06.mapper.CourseMapper;
import com.re.session06.repository.CourseRepository;
import com.re.session06.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public Page<CourseResponse> getCourses(int page, int size) {
        List<Course> courses = courseRepository.findAll();

//        Page<Course> courses = courseRepository.findAll(pageable);

        return CourseMapper.convertListToPage(courses, page, size);
    }
}
