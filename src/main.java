import base64.base64converter;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        String test = "Bonjour";
        byte[] testing = test.getBytes(StandardCharsets.UTF_8);
        System.out.println(test);
        byte[] encodedString = base64converter.encodeString(test);
        /*for (byte bit : testing) {
            System.out.println(bit);
        }*/
        int[] testint = base64converter.bytea2inta(encodedString);
        //System.out.println(Arrays.toString(encodedString));
        byte[] decodedString = base64converter.decodeBytes(encodedString);
        for (int bit : testint) {
            System.out.println(bit);
        }
        //System.out.println(Arrays.toString(decodedString));
        String testEncoded = base64converter.btaTstr(encodedString);
        //System.out.println(testEncoded);
        String result = base64converter.btaTstr(decodedString);
        //System.out.println(result);
        System.out.println(test.equals(result));
    }
}
