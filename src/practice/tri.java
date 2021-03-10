package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class tri {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int p = 1;
        for(int i=1; i<=4; i++){
            for(int j=1; j<=4-i;j++){
                System.out.print("  ");
            }

            for(int j=1; j<=i; j++){
                System.out.print(j+" ");
            }
            for(int j=i-1; j>=1; j--){
                System.out.print(j+" ");
            }

            System.out.println();
        }
    }}