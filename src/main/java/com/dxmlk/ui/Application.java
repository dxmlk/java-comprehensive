package com.dxmlk.ui;

import com.dxmlk.domain.Course;
import com.dxmlk.domain.Student;
import com.dxmlk.service.CourseService;
import com.dxmlk.service.ScheduleService;
import com.dxmlk.service.StudentService;

import java.util.List;
import java.util.Scanner;

public class Application {
    private final Scanner scanner = new Scanner(System.in);
    private final CourseService courseService = new CourseService();
    private final StudentService studentService = new StudentService();
    private final ScheduleService scheduleService = new ScheduleService();
    private final TimeTableUI timeTableUI = new TimeTableUI();

    public void start() {
        while (true) {
            System.out.println("\n===== 수강신청 시스템 =====");
            System.out.println("1. 강의 목록 보기");
            System.out.println("2. 학생 목록 보기");
            System.out.println("3. 수강신청");
            System.out.println("4. 시간표 확인");
            System.out.println("5. 종료");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // 개행 문자 제거

            switch (choice) {
                case 1 -> showCourses();
                case 2 -> showStudents();
                case 3 -> registerCourse();
                case 4 -> showTimeTable();
                case 5 -> {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }
                default -> System.out.println("잘못된 입력입니다. 다시 시도하세요.");
            }
        }
    }

    private void showCourses() {
        List<Course> courses = courseService.getAllCourses();
        System.out.println("\n===== 개설 강의 목록 =====");
        courses.forEach(System.out::println);
    }

    private void showStudents() {
        List<Student> students = studentService.getAllStudents();
        System.out.println("\n===== 학생 목록 =====");
        students.forEach(System.out::println);
    }

    private void registerCourse() {
        System.out
