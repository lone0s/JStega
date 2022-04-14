import base64.base64converter;

import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        String test = "Bonjour";
        System.out.println(test);
        byte[] encodedString = base64converter.encodeString(test);
        System.out.println(Arrays.toString(encodedString));
        byte[] decodedString = base64converter.decodeBytes(encodedString);
        System.out.println(Arrays.toString(decodedString));
        String testEncoded = base64converter.btaTstr(encodedString);
        System.out.println(testEncoded);
        String result = base64converter.btaTstr(decodedString);
        System.out.println(result);
        System.out.println(test.equals(result));
    }
}
