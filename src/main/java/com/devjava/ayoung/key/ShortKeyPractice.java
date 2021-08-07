package com.devjava.ayoung.key;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class ShortKeyPractice {
    public static final String ALGORITHM = "RSA";

    public static void generateKey() {
        try {
            final KeyPairGenerator keyGen = KeyPairGenerator.getInstance(ALGORITHM);
            // RSA 키 길이를 1024 비트로 짧게 설정하는 경우 안전하지 않다.
            keyGen.initialize(1024); // 2048 비트로 바꾸자.
            final KeyPair key = keyGen.generateKeyPair();
            System.out.println(key.getPrivate().toString());
            System.out.println(key.getPublic().toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        generateKey();
    }
}


