package base64;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

public class base64converter {

    public static byte[] encodeString(String baseString) {
        return Base64.getEncoder().encode(baseString.getBytes(StandardCharsets.UTF_8));
    }

    public static byte[] decodeBytes(byte[] encodedString) {
        return Base64.getDecoder().decode(encodedString);
    }

    public static String btaTstr(byte[] decodedString) {
        return new String(decodedString);
    }

    public static int[] btaTinta(byte[] byteArray) {
        
    }
}
