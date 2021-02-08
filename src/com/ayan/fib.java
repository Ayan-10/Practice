package com.ayan;

import java.util.Scanner;

public class fib {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a= new int[n];
        a[0]=0;
        a[1]=1;
        if(n>2){
            for (int i=2; i<n; i++){
                a[i]=a[i-1]+a[i-2];
            }
        }
        for (int i=0; i<n; i++){
            System.out.print(a[i]);
        }
    }
}
