package com.re.session06.mapper;

import com.re.session06.dto.response.CourseResponse;
import com.re.session06.entity.Course;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class CourseMapper {

    public static CourseResponse toResponse(Course course){
        CourseResponse courseResponse = new CourseResponse();
        BeanUtils.copyProperties(course, courseResponse);
        return courseResponse;
    }

    public static Page<CourseResponse> convertListToPage(List<Course> list, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("name").ascending());

//        int start = (int) pageable.getOffset();
//        int end = Math.min((start + pageable.getPageSize()), list.size());

        // Safely create a sublist for the current page
        List<CourseResponse> courseResponses = list.stream().map(CourseMapper::toResponse).toList();

        return new PageImpl<>(courseResponses, pageable, list.size());
    }
}
