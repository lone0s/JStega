package base64;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
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

    public static int[] bytea2inta(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN);
        int[] res = new int[bytes.length/4];
        buffer.asIntBuffer().put(res);
        return res;
    }

    public static byte[] inta2bytea(int[] ints) {
        ByteBuffer buffer = ByteBuffer.allocate(ints.length * 4).order(ByteOrder.LITTLE_ENDIAN);
        buffer.asIntBuffer().put(ints);
        return buffer.array();
    }
    /*public static int[] btaTinta(byte[] byteArray) {
        
    }*/
}
