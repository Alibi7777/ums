package com.ums.University_Management_System.service;


import com.ums.University_Management_System.entity.Course;
import com.ums.University_Management_System.entity.Enrollment;
import com.ums.University_Management_System.entity.Student;
import com.ums.University_Management_System.exception.ResourceNotFoundException;
import com.ums.University_Management_System.factory.EnrollmentFactory;
import com.ums.University_Management_System.repository.CourseRepository;
import com.ums.University_Management_System.repository.EnrollmentRepository;
import com.ums.University_Management_System.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentFactory enrollmentFactory;

    public Enrollment enrollStudent(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));

        Enrollment enrollment = enrollmentFactory.createEnrollment(student, course);
        return enrollmentRepository.save(enrollment);
    }
}

