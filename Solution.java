import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Result {
    private static final int MOD = 1_000_000_007;

    public static int getWorkflowReplacements(String config) {
        int length = config.length();
        long[] previousWays = new long[10];

        char firstChar = config.charAt(0);
        if (firstChar == '?') {
            Arrays.fill(previousWays, 1L);
        } else {
            previousWays[firstChar - '0'] = 1L;
        }

        for (int index = 1; index < length; index++) {
            long totalPreviousWays = 0L;
            for (long ways : previousWays) {
                totalPreviousWays += ways;
                if (totalPreviousWays >= MOD) {
                    totalPreviousWays -= MOD;
                }
            }

            long[] currentWays = new long[10];
            char currentChar = config.charAt(index);

            if (currentChar == '?') {
                for (int digit = 0; digit < 10; digit++) {
                    long validWays = totalPreviousWays - previousWays[digit];
                    if (validWays < 0) {
                        validWays += MOD;
                    }
                    currentWays[digit] = validWays;
                }
            } else {
                int fixedDigit = currentChar - '0';
                long validWays = totalPreviousWays - previousWays[fixedDigit];
                if (validWays < 0) {
                    validWays += MOD;
                }
                currentWays[fixedDigit] = validWays;
            }

            previousWays = currentWays;
        }

        long answer = 0L;
        for (long ways : previousWays) {
            answer += ways;
            if (answer >= MOD) {
                answer -= MOD;
            }
        }

        return (int) answer;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String config = reader.readLine();

        if (config == null) {
            return;
        }

        config = config.trim();
        if (config.isEmpty()) {
            System.out.println(0);
            return;
        }

        System.out.println(Result.getWorkflowReplacements(config));
    }
}
