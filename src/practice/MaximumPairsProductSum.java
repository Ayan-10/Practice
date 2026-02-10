package practice;

import java.util.Arrays;

/**
 * Computes the maximum sum of products formed by choosing exactly k ordered index pairs
 * from two arrays.
 */
public class MaximumPairsProductSum {

    /**
     * Returns the best achievable score.
     *
     * Time complexity: O(n * m * k)
     * Space complexity: O(m * k)
     */
    public long getMaximumScore(int[] firstArray, int[] secondArray, int pairsToPick) {
        int firstLength = firstArray.length;
        int secondLength = secondArray.length;

        long impossibleState = Long.MIN_VALUE / 4;

        long[][] previousRow = new long[secondLength + 1][pairsToPick + 1];
        for (int secondUsed = 0; secondUsed <= secondLength; secondUsed++) {
            Arrays.fill(previousRow[secondUsed], impossibleState);
            previousRow[secondUsed][0] = 0L;
        }

        for (int firstUsed = 1; firstUsed <= firstLength; firstUsed++) {
            long[][] currentRow = new long[secondLength + 1][pairsToPick + 1];
            for (int secondUsed = 0; secondUsed <= secondLength; secondUsed++) {
                Arrays.fill(currentRow[secondUsed], impossibleState);
                currentRow[secondUsed][0] = 0L;
            }

            for (int secondUsed = 1; secondUsed <= secondLength; secondUsed++) {
                int maxPairsAtThisPoint = Math.min(pairsToPick, Math.min(firstUsed, secondUsed));

                for (int usedPairs = 1; usedPairs <= maxPairsAtThisPoint; usedPairs++) {
                    long skipCurrentFromFirst = previousRow[secondUsed][usedPairs];
                    long skipCurrentFromSecond = currentRow[secondUsed - 1][usedPairs];
                    long bestScore = Math.max(skipCurrentFromFirst, skipCurrentFromSecond);

                    long previousDiagonal = previousRow[secondUsed - 1][usedPairs - 1];
                    if (previousDiagonal != impossibleState) {
                        long pairProduct = (long) firstArray[firstUsed - 1] * secondArray[secondUsed - 1];
                        long useThisPair = previousDiagonal + pairProduct;
                        bestScore = Math.max(bestScore, useThisPair);
                    }

                    currentRow[secondUsed][usedPairs] = bestScore;
                }
            }

            previousRow = currentRow;
        }

        return previousRow[secondLength][pairsToPick];
    }

    public static void main(String[] args) {
        MaximumPairsProductSum solver = new MaximumPairsProductSum();

        System.out.println(solver.getMaximumScore(
                new int[]{1, 3, 2},
                new int[]{4, 5, 1},
                2)); // 22

        System.out.println(solver.getMaximumScore(
                new int[]{-2, 0, 5},
                new int[]{-3, 4, -1, 2},
                2)); // 26

        System.out.println(solver.getMaximumScore(
                new int[]{-3, -2},
                new int[]{1, 2},
                2)); // -7
    }
}
