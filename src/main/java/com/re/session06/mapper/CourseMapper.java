package com.re.session06.mapper;

import com.re.session06.dto.response.CourseResponse;
import com.re.session06.entity.Course;
import com.re.session06.dto.request.CourseRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public CourseResponse toResponse(Course course){
        CourseResponse courseResponse = new CourseResponse();
        BeanUtils.copyProperties(course, courseResponse);
        return courseResponse;
    }
}
