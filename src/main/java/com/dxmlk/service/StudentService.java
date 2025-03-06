package com.dxmlk.service;

import com.dxmlk.domain.Student;
import com.dxmlk.persistence.StudentStorage;

import java.util.List;
import java.util.Optional;

public class StudentService {
    private final StudentStorage studentStorage;

    public StudentService() {
        this.studentStorage = new StudentStorage();
    }

    public void addStudent(Student student) {
        List<Student> students = studentStorage.loadStudents();
        students.add(student);
        studentStorage.saveStudents(students);
    }

    public void removeStudent(int studentId) {
        List<Student> students = studentStorage.loadStudents();
        students.removeIf(student -> student.getStudentId().equals(studentId));
        studentStorage.saveStudents(students);
    }

    public Optional<Student> getStudentById(int studentId) {
        List<Student> students = studentStorage.loadStudents();
        return students.stream()
                .filter(student -> student.getStudentId().equals(studentId))
                .findFirst();
    }

    public List<Student> getAllStudents() {
        return studentStorage.loadStudents();
    }
}
