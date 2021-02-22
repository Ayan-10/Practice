package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountCamelcase {
        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String n = reader.readLine();
            System.out.println(countCamelCase(n));
        }
    static int countCamelCase (String s)
    {
        int c = 0;
        for(int i = 0; i<s.length(); i++){
            if(Character.isUpperCase(s.charAt(i))){
                c++;
            }
        }
        return c;
    }
}