package com.devjava.ayoung.resource;

import org.springframework.util.FileCopyUtils;

import java.io.*;

public class ResourcePractice {
    public static void main(String[] args) {

        InputStream in = null;
        OutputStream out = null;

        String inputFile = "./src/main/java/com/devjava/ayoung/resource/input.txt";
        String outputFile = "./src/main/java/com/devjava/ayoung/resource/output.txt";

        try {
            in = new FileInputStream(inputFile);
            out = new FileOutputStream(outputFile);
            FileCopyUtils.copy(in, out);
            // 자원 반환 실행 전에 오류가 발생할 경우 자원이 반환되지 않으며, 할당된 모든 자원을 반환해야 한다.
            in.close();
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            // 예외상황이 발생하여 함수가 종료될 때, 예외의 발생 여부와 상관없이 항상 실행되는 finally 블록에서 할당받은 모든 자원을 반드시 반환하도록 한다
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
