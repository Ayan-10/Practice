package mymethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountingSort {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            String[] st = reader.readLine().trim().split("\\s+");
            int n = Integer.parseInt(st[0]);
            int[] a = new int[n];
            String[] s = reader.readLine().trim().split("\\s+");
            int p=0;
            for (int i=0; i<n; i++){
                a[i] = Integer.parseInt(s[p++]);
            }
            countSort(a);
            for (int i=0; i<n; i++){
                System.out.print(a[i]+" ");
            }
            System.out.println();
        }
    }

    private static void countSort(int[] a) {
        int n = a.length;
        int m = largestnum(a);
        int[] output = new int[n];
        int[] c= new int[m+1];
        for(int i=0; i<=m; i++){
            c[i]=0;
        }
        for (int j : a) {
            ++c[j];
        }
        for(int i=1; i<=m; i++){
            c[i]+=c[i-1];
        }
        for (int i = n - 1; i >= 0; i--) {
            output[c[a[i]] - 1] = a[i];
            --c[a[i]];
        }
        System.arraycopy(output, 0, a, 0, n);
    }

    private static int largestnum(int[] a) {
        int max = Integer.MIN_VALUE;
        for (int i:
             a) {
            max = Math.max(max,i);
        }
        return max;
    }
}