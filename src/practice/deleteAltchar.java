package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class deleteAltchar {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            String st = reader.readLine();
            StringBuilder str = new StringBuilder();
            for(int i=0; i<st.length();i+=2){
                str.append(st.charAt(i));
            }
            System.out.println(str);
        }
    }
}