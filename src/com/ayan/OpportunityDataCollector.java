package com.ayan;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class OpportunityDataCollector {

    /**
     * Returns the minimum number of edge traversals needed to collect all
     * opportunity data when data within distance <= 2 from current branch
     * can be collected, and the route must start and end at the same branch.
     */
    public static int minEdgesToCollectData(
            int[] opportunityData,
            int branchNodes,
            int[] branchFrom,
            int[] branchTo
    ) {
        if (branchNodes <= 1) {
            return 0;
        }

        List<List<Integer>> network = new ArrayList<>(branchNodes);
        for (int i = 0; i < branchNodes; i++) {
            network.add(new ArrayList<>());
        }

        int[] degree = new int[branchNodes];
        for (int i = 0; i < branchNodes - 1; i++) {
            int u = branchFrom[i];
            int v = branchTo[i];
            network.get(u).add(v);
            network.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }

        int remainingEdges = branchNodes - 1;

        // Phase 1: Remove leaf branches that do not contain required data.
        ArrayDeque<Integer> trimQueue = new ArrayDeque<>();
        for (int node = 0; node < branchNodes; node++) {
            if (degree[node] == 1 && opportunityData[node] == 0) {
                trimQueue.offer(node);
            }
        }

        while (!trimQueue.isEmpty()) {
            int leaf = trimQueue.poll();
            if (degree[leaf] != 1) {
                continue;
            }

            degree[leaf] = 0;
            for (int neighbor : network.get(leaf)) {
                if (degree[neighbor] == 0) {
                    continue;
                }

                degree[neighbor]--;
                remainingEdges--;
                if (degree[neighbor] == 1 && opportunityData[neighbor] == 0) {
                    trimQueue.offer(neighbor);
                }
                break;
            }
        }

        // Phase 2: Remove two outer layers of leaves.
        // Those data points can be collected from distance 2, so entering
        // those edges is unnecessary.
        ArrayDeque<Integer> leaves = new ArrayDeque<>();
        for (int node = 0; node < branchNodes; node++) {
            if (degree[node] == 1) {
                leaves.offer(node);
            }
        }

        for (int round = 0; round < 2 && !leaves.isEmpty(); round++) {
            int layerSize = leaves.size();
            for (int i = 0; i < layerSize; i++) {
                int leaf = leaves.poll();
                if (degree[leaf] != 1) {
                    continue;
                }

                degree[leaf] = 0;
                for (int neighbor : network.get(leaf)) {
                    if (degree[neighbor] == 0) {
                        continue;
                    }

                    degree[neighbor]--;
                    remainingEdges--;
                    if (degree[neighbor] == 1) {
                        leaves.offer(neighbor);
                    }
                    break;
                }
            }
        }

        return Math.max(0, remainingEdges * 2);
    }
}
