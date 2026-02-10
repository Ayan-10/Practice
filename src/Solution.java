import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Result {
    private static final int DIGIT_OPTIONS = 10;
    private static final long MODULO = 1_000_000_007L;

    public static int getWorkflowReplacements(String config) {
        int length = config.length();
        long[] waysByLastDigit = new long[DIGIT_OPTIONS];

        char firstCharacter = config.charAt(0);
        if (firstCharacter == '?') {
            Arrays.fill(waysByLastDigit, 1L);
        } else {
            waysByLastDigit[firstCharacter - '0'] = 1L;
        }

        for (int index = 1; index < length; index++) {
            long previousTotalWays = 0L;
            for (long count : waysByLastDigit) {
                previousTotalWays += count;
                if (previousTotalWays >= MODULO) {
                    previousTotalWays %= MODULO;
                }
            }

            long[] updatedWays = new long[DIGIT_OPTIONS];
            char currentCharacter = config.charAt(index);

            if (currentCharacter == '?') {
                for (int digit = 0; digit < DIGIT_OPTIONS; digit++) {
                    updatedWays[digit] = (previousTotalWays - waysByLastDigit[digit] + MODULO) % MODULO;
                }
            } else {
                int fixedDigit = currentCharacter - '0';
                updatedWays[fixedDigit] = (previousTotalWays - waysByLastDigit[fixedDigit] + MODULO) % MODULO;
            }

            waysByLastDigit = updatedWays;
        }

        long validConfigurations = 0L;
        for (long count : waysByLastDigit) {
            validConfigurations += count;
            if (validConfigurations >= MODULO) {
                validConfigurations %= MODULO;
            }
        }

        return (int) validConfigurations;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String config = reader.readLine();
        while (config != null && config.trim().isEmpty()) {
            config = reader.readLine();
        }

        if (config == null || config.isEmpty()) {
            writer.write("0");
        } else {
            writer.write(String.valueOf(Result.getWorkflowReplacements(config.trim())));
        }
        writer.newLine();
        writer.flush();
    }
}
