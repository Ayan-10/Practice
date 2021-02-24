package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ypattren {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            String[] s = yShapedPattern(n);
            for(int i=0; i<n; i++){
                System.out.println(s[i]);
            }

        }
    }
    static String[] yShapedPattern(int N) {
        String[] s = new String[N];
        int sp = N-1;
        int i = 0;
        for(; i<N/2; i++,sp-=2){
            String sb = " ".repeat(Math.max(0, i)) +
                    "*" +
                    " ".repeat(Math.max(0, sp)) +
                    "*";
            s[i]= sb;
        }
        for(; i<N; i++){
            String sb = " ".repeat(N / 2) +
                    "*";
            s[i]= sb;
        }
        return s;
    }
}
