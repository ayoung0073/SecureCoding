package com.devjava.ayoung.password;

import java.util.Scanner;

public class PasswordTryCheck {

    /*
        5번 실패 시 해당 계정 계정 잠김
     */
    public static void main(String[] args) {
        final String password = "password";

        final int MAX_ATTEMPTS = 5;
        int tryCount = 0; // 시도 횟수

        Scanner scanner = new Scanner(System.in);
        System.out.print("비밀번호를 입력해주세요 : ");
        while ((tryCount < MAX_ATTEMPTS)) {
            String input = scanner.next();
            if (!input.equals(password)) {
                tryCount += 1;
                System.out.print("로그인 실패, 비밀번호를 다시 입력해주세요 : ");
            } else {
                break;
            }
        }

        if (tryCount < MAX_ATTEMPTS) {
            System.out.println("로그인 성공하였습니다.");
        }
        else {
            System.out.println("계정이 잠겼습니다.");
        }
    }
}
