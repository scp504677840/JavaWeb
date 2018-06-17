package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class ServiceUtils {

    private ServiceUtils() {
    }

    /**
     * MD5算法
     *
     * @param message 需要加密的消息
     * @return 加密后的消息
     */
    public static String md5(String message) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            byte[] digest = md5.digest(message.getBytes());
            return Arrays.toString(Base64.getEncoder().encode(digest));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
