package com.dxmlk.persistence;

import com.dxmlk.domain.Schedule;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ScheduleStorage {
    private static final String FILE_NAME = "scheduleDB.dat";

    public void saveSchedules(List<Schedule> schedules) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(schedules);
        } catch (IOException e) {
            System.err.println("시간표 데이터를 저장하는 중 오류 발생: " + e.getMessage());
        }
    }

    public List<Schedule> loadSchedules() {
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
