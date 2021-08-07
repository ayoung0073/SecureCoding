package com.devjava.ayoung.password;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeakPassword {
    public static void main(String[] args) {

        // 비밀번호에 자릿수, 특수문자 포함 여부 등의 복잡도를 체크하고 등록하게 한다.
        Pattern pattern = Pattern.compile("((?=.*[a-zA-Z])(?=.*[0-9@#$%]))");

        String inputPassword = "Password1234";
        Matcher matcher = pattern.matcher(inputPassword);
        if (!matcher.matches()) {
            System.out.println("비밀번호 조합 규칙 오류");
        }
        else {
            System.out.println("비밀번호 조합 규칙 통과");
        }

    }
}
