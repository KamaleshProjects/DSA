package com.dsa.network.nodes;

import com.dsa.vec.Vec;
import com.dsa.vec.VecArr;

import java.util.*;

/**
 * You are given a network of n nodes labeled from 1 to n. You are also given times a list of travel times as
 * directed edges times[i] = (ui, vi, wi) where ui is the source node, vi is the target node, and wi the time it takes
 * for a signal to travel from source to target
 *
 * We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal.
 * If it is impossible for all the n nodes to receive the signal return -1.
 */
public class NetworkNodes {

    /**
     *
     * @param weights weighted edges from which a graph can be constructed
     * @param n       no of nodes in the graph
     * @param k       node from which we need to check connectivity
     * @return        time it takes for n nodes to receive the signal that originates from node k
     */
    public int solve(Vec<Vec<Integer>> weights, int n, int k) {
        Map<Integer, Vec<Vec<Integer>>> adjacencyList = this.buildAdjacencyList(weights);
        Map<Integer, Integer> distMap = new HashMap<>();
        PriorityQueue<Vec<Integer>> pq = new PriorityQueue<>(Comparator.comparing(o -> o.get(0)));
        Vec<Integer> firstNodeReach = new VecArr<>();
        firstNodeReach.append(0); firstNodeReach.append(k);
        pq.add(firstNodeReach);
        this.timeTakenToReachAllNodes(adjacencyList, distMap, pq);

        int maxTime = -1;
        boolean allNodesVisited = (n == distMap.size());
        if (!allNodesVisited) return maxTime;

        for (int node: distMap.keySet()) {
            System.out.println("node:: " + node + " time taken:: " + distMap.get(node));
            maxTime = Math.max(maxTime, distMap.get(node));
        }
        return maxTime;
    }

    /**
     *
     * @param adjacencyList a weighted graph that is represented as an adjacency list
     * @param visited       a map of nodes visited and the shortest time taken to visit that node
     * @param pq            priority queue of time based nodes
     */
    public void timeTakenToReachAllNodes(
            Map<Integer, Vec<Vec<Integer>>> adjacencyList, Map<Integer, Integer> visited,
            PriorityQueue<Vec<Integer>> pq) {

        while (!pq.isEmpty()) {
            Vec<Integer> timeNode = pq.poll();
            if (timeNode == null || timeNode.length() == 0) continue;

            int time = timeNode.get(0);
            int node = timeNode.get(1);
            if (visited.containsKey(node)) continue;

            visited.put(node, time);

            if (!adjacencyList.containsKey(node)) continue;
            Vec<Vec<Integer>> neighborEdges = adjacencyList.get(node);
            int neighborsCount = neighborEdges.length();
            for (int i = 0; i < neighborsCount; i++) {
                Vec<Integer> neighborEdge = neighborEdges.get(i);
                int neighborNode = neighborEdge.get(0);
                int neighborTime = neighborEdge.get(1);
                Vec<Integer> weigtedEdge = new VecArr<>();
                weigtedEdge.append(time + neighborTime);
                weigtedEdge.append(neighborNode);
                pq.add(weigtedEdge);
            }
        }
    }

    /**
     *
     * @param weights weighted edges from which a graph can be constructed
     * @return a graph that is constructed from the weighted edges passed represented as an adjacency list
     */
    public Map<Integer, Vec<Vec<Integer>>> buildAdjacencyList(Vec<Vec<Integer>> weights) {
        Map<Integer, Vec<Vec<Integer>>> adjacencyList = new HashMap<>();
        int edgesCount = weights.length();
        for (int i = 0; i < edgesCount; i++) {
            Vec<Integer> weightedEdge = weights.get(i);
            int startNode = weightedEdge.get(0);
            int endNode = weightedEdge.get(1);
            int weight = weightedEdge.get(2);
            if (adjacencyList.containsKey(startNode)) {
                Vec<Vec<Integer>> neighborNodes = adjacencyList.get(startNode);
                Vec<Integer> newNeighborNode = new VecArr<>();
                newNeighborNode.append(endNode);
                newNeighborNode.append(weight);
                neighborNodes.append(newNeighborNode);
            } else {
                Vec<Integer> newNeighborNode = new VecArr<>();
                newNeighborNode.append(endNode);
                newNeighborNode.append(weight);
                Vec<Vec<Integer>> neighborNodes = new VecArr<>();
                neighborNodes.append(newNeighborNode);
                adjacencyList.put(startNode, neighborNodes);
            }
        }
        return adjacencyList;
    }
}
