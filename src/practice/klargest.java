package practice;

import java.io.*;
import java.util.*;

public class klargest {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            String[] st = reader.readLine().trim().split("\\s+");
            int n = Integer.parseInt(st[0]);
            int k = Integer.parseInt(st[1]);
            int[] arr = new int[n];
            String[] s = reader.readLine().trim().split("\\s+");
            for(int i = 0; i<n ; i++){
                arr[i] = Integer.parseInt(s[i]);
            }
            int[] ans = kLargest(arr, n, k);
            for (int e : ans) {
                System.out.print(e);
            }
        }
    }
    static int[] kLargest(int[] arr, int n, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < k; i++)
        {
            minHeap.add(arr[i]);
        }
         
        // Loop For each element in array
        // after the kth element
        for(int i = k; i < n; i++)
        {
             
            // If current element is smaller
            // than minimum ((top element of
            // the minHeap) element, do nothing
            // and continue to next element
            if (minHeap.peek() > arr[i])
                continue;
             
            // Otherwise Change minimum element
            // (top element of the minHeap) to
            // current element by polling out
            // the top element of the minHeap
            else
            {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }
        int[] ans = new int[k];
         int p = k-1;
        while (!minHeap.isEmpty())
        {
            ans[p--] = minHeap.poll();
        }
        return ans;
        }
}
