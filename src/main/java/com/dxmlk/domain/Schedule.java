package com.dxmlk.domain;

import java.io.Serializable;
import java.util.List;

public class Schedule implements Serializable {
    private static final long serialVersionUID = 1L;

    private int studentId;  // 학생 ID (추가)
    private List<String> courseNames; // 수강한 과목 리스트

    public Schedule(int studentId, List<String> courseNames) {
        this.studentId = studentId;
        this.courseNames = courseNames;
    }

    public int getStudentId() { // 이거 추가!
        return studentId;
    }

    public List<String> getCourseNames() {
        return courseNames;
    }

    public void addCourse(String courseName) {
        courseNames.add(courseName);
    }

    public void removeCourse(String courseName) {
        courseNames.remove(courseName);
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "studentId=" + studentId +
                ", courseNames=" + courseNames +
                '}';
    }
}
