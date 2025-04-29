package com.ums.University_Management_System.repository;

import com.ums.University_Management_System.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByCourseId(Long id);

    List<Enrollment> findByStudentId(Long id);
}
