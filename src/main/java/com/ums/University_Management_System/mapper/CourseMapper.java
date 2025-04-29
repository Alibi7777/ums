package com.ums.University_Management_System.mapper;


import com.ums.University_Management_System.dto.CourseDTO;
import com.ums.University_Management_System.entity.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public CourseDTO toDTO(Course entity) {
        CourseDTO dto = new CourseDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setStudentCount(entity.getStudentCount());
        return dto;
    }

    public static Course toEntity(CourseDTO dto) {
        Course entity = new Course();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setStudentCount(dto.getStudentCount());
        return entity;
    }
}
