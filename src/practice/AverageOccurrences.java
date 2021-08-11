package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AverageOccurrences {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testcases = Integer.parseInt(reader.readLine());
        while (testcases-- > 0) {
            int arrayLength = Integer.parseInt(reader.readLine());
            int[] arr = new int[arrayLength];
            String[] s = reader.readLine().trim().split("\\s+");
            for (int i = 0; i < arrayLength; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }

            int answer = averageOccurrences(arr);
            System.out.println(answer);
        }
    }

    private static int averageOccurrences(int[] arr) {
        int average = foundAverage(arr);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==average){
                count++;
            }
        }
        return count;
    }

    private static int foundAverage(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++)
            sum += arr[i];

        return (sum / arr.length);
    }
}
