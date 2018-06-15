import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Random;

public class Token {

    private Token() {
    }

    public static String generate() {

        String token = String.valueOf(System.currentTimeMillis() + new Random().nextInt());

        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            byte[] digest = md5.digest(token.getBytes());
            return new String(Base64.getEncoder().encode(digest));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("generate NoSuchAlgorithmException");
        }

    }

}