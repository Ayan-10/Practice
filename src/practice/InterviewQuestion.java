package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InterviewQuestion {

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

            double answer = averageOfLargestAndSmallest(arr);
            System.out.println(answer);
        }
    }

    private static double averageOfLargestAndSmallest(int[] arr) {
        int sumOfLargest = arr[0];
        int sumOfSmallest = arr[0];
        int countLargest = 1;
        int countsSmallest = 1;
        int prevLargest = arr[0];
        int prevSmallest = arr[0];

        if(arr.length>1) {
            for (int i = 1; i < arr.length; i++) {
                if(arr[i] > prevLargest){
                    sumOfLargest = arr[i];
                    countLargest = 1;
                    prevLargest = arr[i];
                } else if (arr[i] == prevLargest){
                    sumOfLargest += arr[i];
                    countLargest += 1;
                    prevLargest = arr[i];
                }
                if(arr[i] < prevSmallest) {
                    sumOfSmallest = arr[i];
                    countsSmallest = 1;
                    prevSmallest = arr[i];
                }  else if (arr[i] == prevSmallest){
                    sumOfSmallest += arr[i];
                    countsSmallest += 1;
                    prevSmallest = arr[i];
                }
            }
        }
        double average = (double) (sumOfLargest + sumOfSmallest)/(countLargest+countsSmallest);
        return average;
    }
}
