package com.may.os;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class OsInjectionTest {

    @Test
    void injectionTest() throws IOException {
        String input = " > hi.txt";
        String command = "echo test"; // "test" 파일 생성하는 명령어
        Runtime.getRuntime().exec(command + input);
    }
}
