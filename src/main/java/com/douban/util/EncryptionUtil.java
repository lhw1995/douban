package com.douban.util;

/**
 * Created by lidey on 2017/5/9.
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionUtil {
    public static String getHash(String source, String hashType) {
        StringBuilder sb = new StringBuilder();
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance(hashType);
            md5.update(source.getBytes());
            for (byte b : md5.digest()) {
                sb.append(String.format("%02X", b)); // 10进制转16进制，X 表示以十六进制形式输出，02 表示不足两位前面补0输出
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getHash2(String source, String hashType) {
        StringBuilder sb = new StringBuilder();
        MessageDigest md5;
        String source2 = EncryptionUtil.getHash(source, "MD5");
        //再次连接加密
        source2 = source.toUpperCase() + source2.toLowerCase() + source;

        try {
            md5 = MessageDigest.getInstance(hashType);
            md5.update(source2.getBytes());
            for (byte b : md5.digest()) {
                sb.append(String.format("%02X", b)); // 10进制转16进制，X 表示以十六进制形式输出，02 表示不足两位前面补0输出
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
