package com.re.session06.service.impl;

import com.re.session06.dto.response.CourseResponse;
import com.re.session06.entity.Course;
import com.re.session06.mapper.CourseMapper;
import com.re.session06.repository.CourseRepository;
import com.re.session06.service.CourseService;
import com.re.session06.service.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final FileStorageService fileStorageService;

    @Override
    public Page<CourseResponse> getCourses(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size, Sort.by("name").ascending());
        return courseRepository.findAll(pageable).map(courseMapper::toResponse);
    }

    @Override
    public CourseResponse uploadImage(Long id, MultipartFile file) {
        Course course = findCourseById(id);
        fileStorageService.deleteFileByUrl(course.getImageUrl());
        String imageUrl = fileStorageService.storeImage(file);
        course.setImageUrl(imageUrl);
        Course updated = courseRepository.save(course);
        return courseMapper.toResponse(updated);
    }

    @Override
    public void deleteImage(Long id) {
        Course course = findCourseById(id);
        if (course.getImageUrl() == null || course.getImageUrl().isBlank()) {
            throw new RuntimeException("Course image not found");
        }
        fileStorageService.deleteFileByUrl(course.getImageUrl());
        course.setImageUrl(null);
        courseRepository.save(course);
    }

    private Course findCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
    }
}
