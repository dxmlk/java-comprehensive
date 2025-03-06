package com.dxmlk.domain;

import java.io.Serializable;

public class Schedule implements Serializable {
    private String courseName;  // 과목명
    private String time;        // 강의 시간 (예: "10:00")
    private String day;         // 강의 요일 (예: "월수")
    private int studentId;      // 수강하는 학생의 ID

    public Schedule(String courseName, String time, String day, int studentId) {
        this.courseName = courseName;
        this.time = time;
        this.day = day;
        this.studentId = studentId;
    }
    
    public String getCourseName() {
        return courseName;
    }

    public String getTime() {
        return time;
    }

    public String getDay() {
        return day;
    }

    public int getStudentId() {
        return studentId;
    }
}
