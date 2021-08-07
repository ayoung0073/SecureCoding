package com.devjava.ayoung.random;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class RandomPractice {
    public static void getRandomValue(int maxValue) {
        // 고정된 시드값을 사용하면 동일한 난수값이 생성되어 안전하지 않다.
        Random random = new Random(100); // 고정된 seed(100)
        System.out.println(random.nextInt(maxValue));
    }

    public static void getAuthKey() {
        // 매번 변경되는 시드값을 사용하여 다른 난수값이 생성되지만 보안결정을 위한 난수로는 안전하지 않다.
        Random random = new Random();
        String authKey = Integer.toString(random.nextInt());
        System.out.println(authKey);
    }

    public static void getAuthKeySecure() {
        try {
            // 보안 결정을 위한 난수로는 예측이 거의 불가능하게 암호학적으로 보호된 SecureRandom 을 사용한다
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            secureRandom.setSeed(secureRandom.generateSeed(128));
            String authKey = new String(digest.digest((secureRandom.nextLong() + "").getBytes()));
            System.out.println(authKey);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        getRandomValue(100);
        getAuthKey();
        getAuthKeySecure();
    }

}
