package practice;

import java.util.*;

public class MaxConsecutiveBagsMoney {

    private static final long MOD = 1_000_000_007L;

    /**
     * Finds the maximum total money across any k consecutive bags.
     *
     * Key insight: since all money values are non-negative, the optimal window
     * of size k must either start at a segment boundary or end at a segment boundary.
     * This gives O(n) candidates instead of scanning 10^9 positions.
     */
    public static long calculateMaximumConsecutiveSum(int k, List<List<Integer>> segments) {

        int totalSegments = segments.size();                                         // 1
        long[][] segmentData = new long[totalSegments][3];                           // 2
        for (int i = 0; i < totalSegments; i++) {                                   // 3
            segmentData[i][0] = segments.get(i).get(0);                             // 3
            segmentData[i][1] = segments.get(i).get(1);                             // 3
            segmentData[i][2] = segments.get(i).get(2);                             // 3
        }
        Arrays.sort(segmentData, (a, b) -> Long.compare(a[0], b[0]));              // 4

        // Coordinate compression: each segment contributes two boundary points
        TreeSet<Long> boundarySet = new TreeSet<>();                                  // 5
        for (long[] seg : segmentData) {                                             // 6
            boundarySet.add(seg[0]);                                                 // 6
            boundarySet.add(seg[1] + 1);                                             // 6
        }

        List<Long> coordList = new ArrayList<>(boundarySet);                         // 7
        int totalCoords = coordList.size();                                          // 8

        // Assign per-bag money to each compressed interval via linear sweep
        long[] bagValue = new long[totalCoords];                                     // 9
        int segIdx = 0;                                                              // 10
        for (int i = 0; i < totalCoords; i++) {                                     // 11
            long pos = coordList.get(i);                                             // 11
            while (segIdx < totalSegments && segmentData[segIdx][1] < pos) {        // 11
                segIdx++;                                                             // 11
            }
            if (segIdx < totalSegments && segmentData[segIdx][0] <= pos) {          // 11
                bagValue[i] = segmentData[segIdx][2];                               // 11
            }
        }

        // prefixMoney[i] = total money in bags [coordList[0], coordList[i] - 1]
        long[] prefixMoney = new long[totalCoords + 1];                              // 12
        for (int i = 0; i < totalCoords - 1; i++) {                                // 13
            long intervalWidth = coordList.get(i + 1) - coordList.get(i);          // 13
            prefixMoney[i + 1] = prefixMoney[i] + bagValue[i] * intervalWidth;     // 13
        }

        // Candidate window starts: align left edge to segment start OR right edge to segment end
        List<Long> candidateStarts = new ArrayList<>();                               // 14
        for (long[] seg : segmentData) {                                             // 15
            candidateStarts.add(seg[0]);                                             // 15
            long rightAligned = seg[1] - (long) k + 1;                              // 15
            if (rightAligned >= 1) candidateStarts.add(rightAligned);               // 15
        }

        long maxMoney = 0;                                                           // 16
        for (long winStart : candidateStarts) {                                      // 17
            long winEnd = winStart + (long) k - 1;                                   // 17
            long windowTotal = rangeSum(coordList, prefixMoney, bagValue,            // 17
                                        winStart, winEnd);                           // 17
            if (windowTotal > maxMoney) maxMoney = windowTotal;                      // 17
        }

        return maxMoney % MOD;                                                       // 18
    }

    private static long rangeSum(List<Long> coords, long[] prefix,
                                  long[] val, long lo, long hi) {
        return prefixUpTo(coords, prefix, val, hi + 1)
             - prefixUpTo(coords, prefix, val, lo);
    }

    // Returns total money in bags [coords[0], pos - 1]
    private static long prefixUpTo(List<Long> coords, long[] prefix,
                                    long[] val, long pos) {
        int lo = 0, hi = coords.size() - 1, idx = -1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (coords.get(mid) < pos) { idx = mid; lo = mid + 1; }
            else hi = mid - 1;
        }
        if (idx < 0) return 0;
        return prefix[idx] + val[idx] * (pos - coords.get(idx));
    }

    public static void main(String[] args) {
        List<List<Integer>> segs = new ArrayList<>();
        segs.add(Arrays.asList(1, 4, 2));
        segs.add(Arrays.asList(6, 6, 5));
        segs.add(Arrays.asList(7, 7, 7));
        segs.add(Arrays.asList(9, 10, 1));
        System.out.println(calculateMaximumConsecutiveSum(5, segs)); // Expected: 16
    }
}
