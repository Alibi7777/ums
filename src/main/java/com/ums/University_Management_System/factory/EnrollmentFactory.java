package com.ums.University_Management_System.factory;


import com.ums.University_Management_System.entity.Course;
import com.ums.University_Management_System.entity.Enrollment;
import com.ums.University_Management_System.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class EnrollmentFactory {

    public Enrollment createEnrollment(Student student, Course course) {
        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        return enrollment;
    }
}

