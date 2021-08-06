package com.devjava.ayoung.password;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

public class SaltHash {

    // 안전하지 않은 코드
    public static String getPasswordHash(String password) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        // 해쉬에 솔트를 적용하지 않아 안전하지 않다.
        md.update(password.getBytes());
        byte[] byteData = md.digest();
        StringBuilder hexString = new StringBuilder();
        for (byte byteDatum : byteData) {
            String hex = Integer.toHexString(0xff & byteDatum);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    // 안전한 코드 (파라미터에 솔트가 추가되었다.)
    public static String getPasswordHash(String password, String salt) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(salt.getBytes());
        md.update(password.getBytes());

        String hex = String.format("%064x", new BigInteger(1, md.digest()));

        return hex;
    }

    public static void main(String[] args) throws Exception {
        String enPassword = getPasswordHash("password");
        System.out.println(enPassword);

        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        byte[] bytes = new byte[16];
        random.nextBytes(bytes);
        String salt = new String(Base64.getEncoder().encode(bytes));
        String saltPassword = getPasswordHash("password", salt);

        System.out.println(saltPassword);
    }

}
