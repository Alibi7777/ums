package com.ums.University_Management_System.factory;


import com.ums.University_Management_System.dto.StudentDTO;
import com.ums.University_Management_System.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentFactory {
    public Student createFromDTO(StudentDTO dto) {
        Student student = new Student();
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        return student;
    }
}
