package test;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            String s1= reader.readLine();
            String s2= reader.readLine();
            int s11=0;
            int s10=0;
            int s21=0;
            int s20=0;
            for (int i=0; i<n; i++){
                if(s1.charAt(i) == '1'){
                    s11++;
                }else {
                    s10++;
                }
            }
            for (int i=0; i<n; i++){
                if(s2.charAt(i) == '1'){
                    s21++;
                }else {
                    s20++;
                }
            }
            if(s11==s21 && s10==s20){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }
    }
