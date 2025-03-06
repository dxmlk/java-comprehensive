package com.dxmlk.service;

import com.dxmlk.domain.Course;
import com.dxmlk.persistence.CourseStorage;

import java.util.List;

public class CourseService {
    private final CourseStorage courseStorage;

    public CourseService(CourseStorage courseStorage) {
        this.courseStorage = courseStorage;
    }

    public List<Course> getAllCourses() {
        return courseStorage.loadCourses();
    }

    public void addCourse(Course course) {
        List<Course> courses = courseStorage.loadCourses();
        courses.add(course);
        courseStorage.saveCourses(courses);
    }

    public void removeCourse(String courseName) {
        List<Course> courses = courseStorage.loadCourses();
        courses.removeIf(course -> course.getCourseName().equals(courseName));
        courseStorage.saveCourses(courses);
    }

    public Course findCourseByName(String courseName) {
        return courseStorage.loadCourses().stream()
                .filter(course -> course.getCourseName().equals(courseName))
                .findFirst()
                .orElse(null);
    }
}
