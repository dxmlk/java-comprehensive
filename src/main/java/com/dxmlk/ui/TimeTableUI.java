package com.dxmlk.ui;

import com.dxmlk.domain.Schedule;
import com.dxmlk.service.ScheduleService;
import com.dxmlk.persistence.ScheduleStorage;

import java.util.List;

public class TimeTableUI {
    private final ScheduleService scheduleService;

    public TimeTableUI() {
        this.scheduleService = new ScheduleService(new ScheduleStorage()); // ScheduleStorage 추가
    }

    public void displayTimeTable(String studentId) {
        try {
            int studentIdInt = Integer.parseInt(studentId);  // String → int 변환
            List<Schedule> schedules = scheduleService.getScheduleByStudentId(studentIdInt);

            if (schedules.isEmpty()) {
                System.out.println("⚠️ 등록된 강의가 없습니다.");
                return;
            }

            System.out.println("\n===== " + studentId + "의 시간표 =====");

            // 표 형식 출력
            System.out.println("+-----------------+------------+------------+");
            System.out.println("|  과목명          |  강의 시간  |  강의 요일  |");
            System.out.println("+-----------------+------------+------------+");

            for (Schedule schedule : schedules) {
                System.out.printf("| %-15s | %-10s | %-10s |\n",
                        schedule.getCourseName(),
                        schedule.getTime(),
                        schedule.getDay());        // getDays() → getDay()로 수정
            }

            System.out.println("+-----------------+------------+------------+");

            // 도트 형식(블록) 시간표 표시
            printDotTimeTable(schedules);
        } catch (NumberFormatException e) {
            System.out.println("⚠️ 학생 ID는 숫자로 입력해야 합니다!");
        }
    }

    private void printDotTimeTable(List<Schedule> schedules) {
        System.out.println("\n📌 블록 시간표");

        String[] timeSlots = {"09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00"};
        String[] days = {"월", "화", "수", "목", "금"};

        for (String time : timeSlots) {
            System.out.printf("%-5s", time);
            for (String day : days) {
                boolean hasClass = schedules.stream()
                        .anyMatch(s -> s.getTime().equals(time) && s.getDay().contains(day));  // 🔥 getDays() → getDay()
                System.out.print(hasClass ? " ■ " : " □ ");
            }
            System.out.println();
        }

        System.out.println("\n'■' = 수강 강의 | '□' = 빈 시간");
    }
}
