package com.ayan;


import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.IntStream;


public class Main {

    public static void main(String[] args) throws IOException {

        //buffer
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            String[] st = reader.readLine().trim().split("\\s+");
            int n = Integer.parseInt(st[0]);
            int k = Integer.parseInt(st[1]);
            int[] a = new int[n];
            int count;
            if(n%2==0) count = n / 2;
            else count = (n / 2) + 1;
            int d = Math.abs(k-count);
            if(n%2==0){
                for(int i = n - 1; i >= 0; i--){
                    if(i%2==0){
                       a[i] = -1*(i+1);
                        if (count<k && d>0){
                            a[i]=-1*a[i];
                            d--;
                        }
                    }else {
                        a[i] = i+1;
                        if (count>k && d>0){
                            a[i]=-1*a[i];
                            d--;
                        }
                    }
                }
            }else{
                for(int i = n - 1; i >= 0; i--){
                    if(i%2==0){
                        a[i] = i+1;
                        if (count>k && d>0){
                            a[i]=-1*a[i];
                            d--;
                        }
                    }else {
                        a[i] = -1*(i+1);
                        if (count<k && d>0){
                            a[i]=-1*a[i];
                            d--;
                        }
                    }
                }
            }
            IntStream.range(0, n).mapToObj(i -> a[i] + " ").forEach(System.out::print);

            System.out.println();
        }
    }
}