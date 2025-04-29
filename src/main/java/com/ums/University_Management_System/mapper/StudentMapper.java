package com.ums.University_Management_System.mapper;

import com.ums.University_Management_System.dto.StudentDTO;
import com.ums.University_Management_System.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public StudentDTO studentDTO(Student student){
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        return dto;
    }

}
