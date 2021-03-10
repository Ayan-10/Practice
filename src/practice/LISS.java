package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LISS {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        System.out.println(breakSum(t));
    }

    private static int liss(int n) {
        if(n==0 || n==1){ 
            return n;
        }
        return Math.max(liss(n/2)+liss(n/3)+liss(n/4),n);
    }
    static int breakSum(int n)
    {
        int dp[] = new int[n+1];

        // base conditions
        dp[0] = 0;  dp[1] = 1;

        // Fill in bottom-up manner using recursive
        // formula.
        for (int i=2; i<=n; i++)
            dp[i] = Math.max(dp[i/2] + dp[i/3] + dp[i/4], i);
        for (int e :
                dp) {
            System.out.print(e+" ");
        }

        return dp[n];
    }
}
