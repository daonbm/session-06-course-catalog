package com.re.session06.dto.response;

import lombok.Data;

@Data
public class CourseResponse {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imageUrl;
}
