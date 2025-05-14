
package config;


import java.util.Random;

public class OTPGenerator {
    public static String generateOTP(int length) {
        String numbers = "0123456789";
        StringBuilder otp = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            otp.append(numbers.charAt(rand.nextInt(numbers.length())));
        }
        return otp.toString();
    }

}
