package com.dxmlk.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Course implements Serializable {
    private static final long serialVersionUID = 1L; // 직렬화 버전
    private String courseName;  // 과목명
    private String professor;   // 교수
    private String[] days;      // 요일
    private String time;        // 강의 시간
    private int capacity;       // 정원
    private int credit;         // 학점

    public Course(String courseName, String professor, String[] days, String time, int capacity, int credit) {
        this.courseName = courseName;
        this.professor = professor;
        this.days = days;
        this.time = time;
        this.capacity = capacity;
        this.credit = credit;
    }

//    public Course update(String courseName, String professor, String[] days, String time, int capacity, int credit) {
//        return new Course(courseName, professor, days, time, capacity, credit);
//    }

    public String getCourseName() {
        return courseName;
    }

    public String getProfessor() {
        return professor;
    }

    public String[] getDays() {
        return days;
    }

    public String getTime() {
        return time;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCredit() {
        return credit;
    }

//    // equals() 오버라이드: 같은 강의인지 비교
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Course course = (Course) o;
//        return capacity == course.capacity &&
//                credit == course.credit &&
//                Objects.equals(courseName, course.courseName) &&
//                Objects.equals(professor, course.professor) &&
//                Objects.equals(time, course.time) &&
//                Arrays.equals(days, course.days);
//    }
//
//    // hashCode() 오버라이드: `days`는 배열이라 따로 처리
//    @Override
//    public int hashCode() {
//        int result = Objects.hash(courseName, professor, time, capacity, credit);
//        result = 31 * result + Arrays.hashCode(days);
//        return result;
//    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", professor='" + professor + '\'' +
                ", days=" + Arrays.toString(days) +
                ", time='" + time + '\'' +
                ", capacity=" + capacity +
                ", credit=" + credit +
                '}';
    }

}
