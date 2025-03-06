package com.dxmlk.ui;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TimeTableUI timeTableUI = new TimeTableUI();

        while (true) {
            System.out.println("\n=== 시간표 조회 시스템 ===");
            System.out.print("학생 ID를 입력하세요 (종료: exit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            timeTableUI.displayTimeTable(input);
        }

        scanner.close();
    }
}
