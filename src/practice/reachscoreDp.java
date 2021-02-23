package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class reachscoreDp {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        count(n);
    }
    static long count(int n) {
        long c = 0;
        vv(n,c);
        return c;
    }
    static void vv(int n, long c){
        if(n==1 || n==2){
            return;
        }
        if(n==0){
            ++c;
            System.out.println(c);
            return;
        }
        if(n>=3){
            System.out.println(c+"FS");
            vv(n - 3, c);
        }
        if(n>=5){
            System.out.println(c+"HNFGE");
            vv(n-5,c);
        }
        if(n>=10){
            vv(n-10,c);
        }

    }
}
