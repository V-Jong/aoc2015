import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        String key = "<insert key>";
        int number = 1;
        boolean notFound = true;

        while (notFound) {
            String combined = key + number;
//            System.out.println("To hash: " + combined);

            String hashtext = getMd5(combined);
//            System.out.println("Hash: " + hashtext);

            String firstChars = hashtext.substring(0, 6);
//            System.out.println("Checking first chars: " + firstChars);
            if (Arrays.stream(firstChars.split("")).allMatch(s -> s.equals("0"))) {
                notFound = false;
                System.out.println("Found hash with 5 leading zeros: " + hashtext + ", stopping at number: " + number);
            }
            number++;
        }
    }

    private static String getMd5(String input) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] bytesOfMessage = input.getBytes("UTF-8");

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] theMD5digest = md.digest(bytesOfMessage);
        // Convert byte array into signum representation
        BigInteger no = new BigInteger(1, theMD5digest);

        // Convert message digest into hex value
        String hashtext = no.toString(16);
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        return hashtext;
    }

}
