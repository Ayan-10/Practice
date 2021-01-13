package ntest;


import java.io.*;
import java.util.*;

public class main {

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        try {
            int t = sc.nextInt();
            while (t-- > 0) {

                int d1= sc.nextInt();
                int v1 = sc.nextInt();
                int d2 = sc.nextInt();
                int v2 = sc.nextInt();
                int p = sc.nextInt();
                int c=0;
                int ans=0;
                if(d1==d2 && d1==1){
                    while (ans<p){
                        c++;
                        ans+=(v1+v2);
                    }
                    System.out.println(c);
                }else{
                    c=Math.min(d1,d2)-1;
                    while (ans<p){
                        if(d1>d2){
                            ans+=v2;
                            d2++;
                        }else if(d2>d1){
                            ans+=v1;
                            d1++;
                        }else if(d1==d2){
                            ans+=(v1+v2);
                        }
                        c++;
                    }
                    System.out.println(c);
                }
            }
        } catch(Exception e) {
        }finally{

        }
    }
}