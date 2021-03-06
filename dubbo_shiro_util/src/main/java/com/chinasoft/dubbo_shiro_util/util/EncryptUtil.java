package com.chinasoft.dubbo_shiro_util.util;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import sun.misc.BASE64Decoder;

import java.security.SecureRandom;

/**
 * Created with IntelliJ IDEA.
 * User: gaopeng
 * Date: 2018/9/17 0017
 * Time: 17:30
 * Description:
 */
public class EncryptUtil {
    private static final String KEY = "abcdefgabcdefg12";
    private static final String ALGORITHMSTR = "AES/ECB/PKCS5Padding";
    public static String base64Encode(byte[] bytes){
        return Base64.encodeBase64String(bytes);
    }
    public static byte[] base64Decode(String base64Code) throws Exception{
        return new BASE64Decoder().decodeBuffer(base64Code);
    }
    public static byte[] aesEncryptToBytes(String content, String encryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);
        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptKey.getBytes(), "AES"));

        return cipher.doFinal(content.getBytes("utf-8"));
    }
    public static String aesEncrypt(String content, String encryptKey) throws Exception {
        return base64Encode(aesEncryptToBytes(content, encryptKey));
    }
    public static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG" );
        secureRandom.setSeed(decryptKey.getBytes());
        kgen.init(128,secureRandom);

        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decryptKey.getBytes(), "AES"));
        byte[] decryptBytes = cipher.doFinal(encryptBytes);

        return new String(decryptBytes);
    }
    public static String aesDecrypt(String encryptStr, String decryptKey) throws Exception {
        return aesDecryptByBytes(base64Decode(encryptStr), decryptKey);
    }


    /**
     * ??????
     *
     */
    public static void main(String[] args) throws Exception {

        String content = "Test String?????????";  //0gqIDaFNAAmwvv3tKsFOFf9P9m/6MWlmtB8SspgxqpWKYnELb/lXkyXm7P4sMf3e
        System.out.println("????????????" + content);

        System.out.println("??????????????????????????????" + KEY);

        String encrypt = aesEncrypt(content, KEY);
        System.out.println(encrypt.length()+":????????????" + encrypt);

        String decrypt = aesDecrypt(encrypt, KEY);
        System.out.println("????????????" + decrypt);
    }
}
