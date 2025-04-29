package com.ums.University_Management_System.service;


import com.ums.University_Management_System.dto.CourseDTO;
import com.ums.University_Management_System.entity.Course;
import com.ums.University_Management_System.entity.Enrollment;
import com.ums.University_Management_System.exception.ResourceNotFoundException;
import com.ums.University_Management_System.factory.CourseFactory;
import com.ums.University_Management_System.mapper.CourseMapper;
import com.ums.University_Management_System.repository.CourseRepository;
import com.ums.University_Management_System.repository.EnrollmentRepository;
import com.ums.University_Management_System.strategy.CourseSortStrategy;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;
    private final CourseFactory courseFactory;
    private final CourseMapper courseMapper;
    private final Map<String, CourseSortStrategy> courseSortStrategies;

    public CourseDTO createCourse(CourseDTO dto) {
        Course course = courseFactory.createFromDTO(dto);
        Course saved = courseRepository.save(course);
        return courseMapper.toDTO(saved);
    }

    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(courseMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<CourseDTO> getSortedCourses(String sortType) {
        CourseSortStrategy strategy = courseSortStrategies.getOrDefault(sortType, courseSortStrategies.get("sortByDate"));
        List<Course> sorted = strategy.sort(courseRepository.findAll());
        return sorted.stream()
                .map(courseMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CourseDTO getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));
        return courseMapper.toDTO(course);
    }

    @Transactional
    public void deleteCourse(Long id) {
        List<Enrollment> enrollments = enrollmentRepository.findByCourseId(id);
        enrollmentRepository.deleteAll(enrollments);
        courseRepository.deleteById(id);
    }


    public CourseDTO updateCourse(Long id, CourseDTO dto) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));

        course.setTitle(dto.getTitle());
        course.setDescription(dto.getDescription());
        course.setStudentCount(dto.getStudentCount());

        Course updatedCourse = courseRepository.save(course);
        return courseMapper.toDTO(updatedCourse);
    }

}

