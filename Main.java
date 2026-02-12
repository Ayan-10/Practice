import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Main {

    private static final long MOD = 998244353L;
    private static final long INV_TWO = (MOD + 1L) / 2L;

    public static int maxFriendshipPower(int cityCount, int roadCount, int[][] roads, int[] groupSizes) {
        DisjointSetUnion dsu = new DisjointSetUnion(cityCount);

        for (int i = 0; i < roadCount; i++) {
            int u = roads[i][0] - 1; // input is 1-based
            int v = roads[i][1] - 1;
            dsu.union(u, v);
        }

        int[] rootToSize = new int[cityCount];
        for (int city = 0; city < cityCount; city++) {
            int root = dsu.find(city);
            rootToSize[root]++;
        }

        int componentCount = 0;
        int[] kingdomSizes = new int[cityCount];
        for (int city = 0; city < cityCount; city++) {
            if (rootToSize[city] > 0) {
                kingdomSizes[componentCount++] = rootToSize[city];
            }
        }
        kingdomSizes = Arrays.copyOf(kingdomSizes, componentCount);

        int[] sortedGroups = Arrays.copyOf(groupSizes, cityCount);
        Arrays.sort(sortedGroups);
        Arrays.sort(kingdomSizes);

        long[] prefixPeople = new long[cityCount + 1];
        for (int i = 0; i < cityCount; i++) {
            prefixPeople[i + 1] = prefixPeople[i] + sortedGroups[i];
        }

        int index = 0;
        long answer = 0L;
        for (int size : kingdomSizes) {
            long totalPeopleInKingdom = prefixPeople[index + size] - prefixPeople[index];
            index += size;
            answer += pairCountModulo(totalPeopleInKingdom);
            if (answer >= MOD) {
                answer %= MOD;
            }
        }

        return (int) (answer % MOD);
    }

    private static long pairCountModulo(long people) {
        if (people <= 1) {
            return 0L;
        }
        long a = people % MOD;
        long b = (people - 1L) % MOD;
        return ((a * b) % MOD) * INV_TWO % MOD;
    }

    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder output = new StringBuilder();

        int testCases = scanner.nextInt();
        for (int tc = 0; tc < testCases; tc++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            int[][] roads = new int[m][2];
            for (int i = 0; i < m; i++) {
                roads[i][0] = scanner.nextInt();
                roads[i][1] = scanner.nextInt();
            }

            int[] groups = new int[n];
            for (int i = 0; i < n; i++) {
                groups[i] = scanner.nextInt();
            }

            int bestPower = maxFriendshipPower(n, m, roads, groups);
            output.append(bestPower);
            if (tc + 1 < testCases) {
                output.append('\n');
            }
        }

        System.out.print(output);
    }

    private static final class DisjointSetUnion {
        private final int[] parent;
        private final int[] rank;

        DisjointSetUnion(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int node) {
            int current = node;
            while (current != parent[current]) {
                current = parent[current];
            }
            while (node != current) {
                int next = parent[node];
                parent[node] = current;
                node = next;
            }
            return current;
        }

        void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) {
                return;
            }

            if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            } else if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            } else {
                parent[rootB] = rootA;
                rank[rootA]++;
            }
        }
    }

    private static final class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0;
        private int len = 0;

        FastScanner(InputStream input) {
            this.in = new BufferedInputStream(input);
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
            } while (c <= ' ' && c != -1);

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
