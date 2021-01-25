package com.ayan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class patt {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine());
           for(int i=0; i<n; i++){
               for(int j=0; j<(n-i-1); j++){
                   System.out.print("  ");
               }
               for(int j=0; j<i+1; j++){
                   System.out.print("* ");
               }
               System.out.println();
           }
        }
    }
}