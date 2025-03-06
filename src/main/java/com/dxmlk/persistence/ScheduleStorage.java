package com.dxmlk.persistence;

import com.dxmlk.domain.Schedule;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ScheduleStorage {
    private static final String FILE_NAME = "scheduleDB.dat";
    private List<Schedule> schedules; // 메모리에서 관리할 리스트

    public ScheduleStorage() {
        this.schedules = loadSchedules(); // 파일에서 로드
    }

    public void addSchedule(Schedule schedule) {
        schedules.add(schedule);
        saveSchedules(); // 변경된 데이터 저장
    }

    public void removeSchedule(int studentId) {
        schedules.removeIf(schedule -> schedule.getStudentId() == studentId);
        saveSchedules(); // 변경된 데이터 저장
    }

    public List<Schedule> getScheduleByStudentId(int studentId) {
        List<Schedule> studentSchedules = new ArrayList<>();
        for (Schedule schedule : schedules) {
            if (schedule.getStudentId() == studentId) {
                studentSchedules.add(schedule);
            }
        }
        return studentSchedules;
    }


    public List<Schedule> getAllSchedules() {
        return new ArrayList<>(schedules);
    }

    private void saveSchedules() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(schedules);
        } catch (IOException e) {
            System.err.println("시간표 데이터를 저장하는 중 오류 발생: " + e.getMessage());
        }
    }

    private List<Schedule> loadSchedules() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Schedule>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("시간표 데이터를 불러오는 중 오류 발생: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
