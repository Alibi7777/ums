package com.ums.University_Management_System.mapper;

import com.ums.University_Management_System.dto.EnrollmentDTO;
import com.ums.University_Management_System.entity.Enrollment;
import org.springframework.stereotype.Component;

@Component
public class EnrollmentMapper {
    public EnrollmentDTO enrollmentDTO(Enrollment enrollment){
        EnrollmentDTO dto = new EnrollmentDTO();
        dto.setId(enrollment.getId());
        dto.setStudentId(enrollment.getStudent().getId());
        dto.setCourseId(enrollment.getCourse().getId());
        return dto;
    }
}
