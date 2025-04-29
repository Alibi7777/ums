package com.ums.University_Management_System.service;


import com.ums.University_Management_System.dto.StudentDTO;
import com.ums.University_Management_System.entity.Enrollment;
import com.ums.University_Management_System.entity.Student;
import com.ums.University_Management_System.exception.ResourceNotFoundException;
import com.ums.University_Management_System.factory.StudentFactory;
import com.ums.University_Management_System.mapper.StudentMapper;
import com.ums.University_Management_System.repository.EnrollmentRepository;
import com.ums.University_Management_System.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final EnrollmentRepository enrollmentRepository;
    private final StudentFactory studentFactory;
    private final StudentMapper studentMapper;

    public StudentDTO createStudent(StudentDTO dto) {
        Student student = studentFactory.createFromDTO(dto);
        Student saved = studentRepository.save(student);
        return studentMapper.studentDTO(saved);
    }

    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::studentDTO)
                .collect(Collectors.toList());
    }

    public StudentDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        return studentMapper.studentDTO(student);
    }

    @Transactional
    public void deleteStudent(Long id) {
        List<Enrollment> enrollments = enrollmentRepository.findByStudentId(id);
        enrollmentRepository.deleteAll(enrollments);
        studentRepository.deleteById(id);
    }

}

