package com.dxmlk.persistence;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import com.dxmlk.domain.Course;

public class CourseStorage {
    private static final String FILE_NAME = "courses.dat";

    // 강의 목록 저장하기
    public static void saveCourses(List<Course> courses) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(courses);
            System.out.println("강의 정보가 저장되었습니다!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 강의 목록 불러오기
    public static List<Course> loadCourses() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return new ArrayList<>(); // 파일이 없으면 빈 리스트 반환

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Course>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
