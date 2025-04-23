package config;

import java.io.*;
import java.net.*;

public class TextbeltSMS {

    public static void sendSMS(String phone, String otp) {
        try {
            URL url = new URL("https://textbelt.com/text");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            String postData = "phone=" + phone +
                              "&message=Your OTP is " + otp +
                              "&key=textbelt"; // Free trial key

            OutputStream os = conn.getOutputStream();
            os.write(postData.getBytes());
            os.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String response;
            while ((response = br.readLine()) != null) {
                System.out.println(response);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
