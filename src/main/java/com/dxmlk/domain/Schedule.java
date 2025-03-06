package com.dxmlk.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Schedule implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Course> courses;

    public Schedule() {
        this.courses = new ArrayList<>();
    }

    public boolean addCourse(Course course) {
        if (isConflict(course)) {
            return false; // 시간이 겹치면 추가 불가
        }
        courses.add(course);
        return true;
    }

    public boolean removeCourse(String courseName) {
        return courses.removeIf(course -> course.getCourseName().equals(courseName));
    }

    public List<Course> getCourses() {
        return new ArrayList<>(courses);
    }

    private boolean isConflict(Course newCourse) {
        for (Course existingCourse : courses) {
            for (String day : newCourse.getDays()) {
                if (List.of(existingCourse.getDays()).contains(day) && existingCourse.getTime().equals(newCourse.getTime())) {
                    return true; // 요일과 시간이 겹치면 충돌 발생
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[수강 신청 목록]\n");
        for (Course course : courses) {
            sb.append(course).append("\n");
        }
        return sb.toString();
    }
}
