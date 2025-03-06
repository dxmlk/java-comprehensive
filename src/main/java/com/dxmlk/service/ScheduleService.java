package com.dxmlk.service;

import com.dxmlk.domain.Schedule;
import com.dxmlk.persistence.ScheduleStorage;

import java.util.List;

public class ScheduleService {
    private final ScheduleStorage scheduleStorage;

    public ScheduleService(ScheduleStorage scheduleStorage) {
        this.scheduleStorage = scheduleStorage;
    }

    public void addSchedule(Schedule schedule) {
        scheduleStorage.addSchedule(schedule);
    }

    public void removeSchedule(int studentId) {
        scheduleStorage.removeSchedule(studentId);
    }

    public Schedule getScheduleByStudentId(int studentId) {
        return scheduleStorage.getScheduleByStudentId(studentId);
    }

    public List<Schedule> getAllSchedules() {
        return scheduleStorage.getAllSchedules();
    }
}
