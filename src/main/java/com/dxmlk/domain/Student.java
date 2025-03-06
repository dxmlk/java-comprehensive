package com.dxmlk.domain;

import java.io.Serializable;
import java.util.List;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String studentId;
    private String name;
    private int year;
    private List<Schedule> scheduleList; // 수강 신청된 강의 목록

    public Student(String studentId, String name, int year, List<Schedule> scheduleList) {
        this.studentId = studentId;
        this.name = name;
        this.year = year;
        this.scheduleList = scheduleList;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void addCourse(Schedule schedule) {
        scheduleList.add(schedule);
    }

    public void removeCourse(Schedule schedule) {
        scheduleList.remove(schedule);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", scheduleList=" + scheduleList +
                '}';
    }
}