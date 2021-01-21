package practice;

import java.util.Scanner;

public class anti90degree {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        try {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int a[][] = new int[n][n];
                for(int i=0; i<n; i++){
                    for(int j=0; j<n ;j++){
                        a[i][j]= sc.nextInt();
                    }
                }
                rotate(a);
                for(int i=0; i<n; i++){
                    for(int j=0; j<n ;j++){
                        System.out.print(a[i][j]+" ");
                    }
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void rotate(int a[][])
    {
        int n = a.length-1;
        for(int i=0; i<=n; i++){
            for(int j=0; j<=n-i; j++){
                int temp = a[i][j];
                a[i][j] = a[n-j][n-i];
                a[n-j][n-i] = temp;
            }
        }
          int i=0;
          int j=n;
          while(i<j){
              for(int p=0; p<n+1; p++){
                  int temp = a[p][i];
                  a[p][i]=a[p][j];
                  a[p][j]=temp;
              }
              i++;
              j--;
          }
    }
}