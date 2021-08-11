package practice;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class frequentNum {
    
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            int[] arr = new int[n];
            String[] s = reader.readLine().trim().split("\\s+");
            for(int i = 0; i<n ; i++){
                arr[i] = Integer.parseInt(s[i]);
            }
            int ans = LargButMinFreq(arr,n);
            System.out.println(ans);

        }
    }

    private static int LargButMinFreq(int[] arr, int n) {
        Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i<n ; i++){
                if(!map.containsKey(arr[i])){
                    map.put(arr[i], 1);
                }else{
                    int tmp = map.get(arr[i]);
                    map.put(arr[i], ++tmp);
                }
            }
            int minFreq = Integer.MAX_VALUE;
            int maxValue = Integer.MIN_VALUE;

            for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
                if(freq < minFreq) {
                   minFreq = freq;
                   maxValue = num;
                } else if(freq == minFreq && maxValue < num) {
                   maxValue = num;
                }
            }
        return maxValue;
    }
}
