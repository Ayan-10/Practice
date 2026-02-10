import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;

public class Solution {

    private static final long MOD = 1_000_000_007L;
    private static final int ALPHABET_SIZE = 26;

    /*
     * Counts valid lowercase passwords of length n where
     * no character appears k or more times consecutively.
     */
    public static int countValidPasswords(int n, int k) {
        if (n <= 0) {
            return 0;
        }
        if (k <= 1) {
            return 0;
        }

        ArrayDeque<Long> firstRunValues = new ArrayDeque<>();
        long validCountForCurrentLength = ALPHABET_SIZE;
        firstRunValues.addLast((long) ALPHABET_SIZE); // Length 1, run length = 1

        int maxTrackedRuns = k - 1;

        for (int length = 2; length <= n; length++) {
            long startNewRunWays = (validCountForCurrentLength * (ALPHABET_SIZE - 1)) % MOD;
            firstRunValues.addLast(startNewRunWays);
            validCountForCurrentLength = (validCountForCurrentLength + startNewRunWays) % MOD;

            if (firstRunValues.size() > maxTrackedRuns) {
                long removed = firstRunValues.removeFirst();
                validCountForCurrentLength = (validCountForCurrentLength - removed + MOD) % MOD;
            }
        }

        return (int) (validCountForCurrentLength % MOD);
    }

    public static void main(String[] args) throws Exception {
        FastInput input = new FastInput(System.in);
        int n = input.nextInt();
        int k = input.nextInt();

        if (n == Integer.MIN_VALUE || k == Integer.MIN_VALUE) {
            return;
        }

        System.out.println(countValidPasswords(n, k));
    }

    private static class FastInput {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0;
        private int len = 0;

        FastInput(InputStream in) {
            this.in = new BufferedInputStream(in);
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) {
                    return -1;
                }
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do {
                c = read();
                if (c == -1) {
                    return Integer.MIN_VALUE;
                }
            } while (c <= ' ');

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            int value = 0;
            while (c > ' ') {
                value = value * 10 + (c - '0');
                c = read();
            }
            return value * sign;
        }
    }
}
