package graph.topological_sort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// 210. Course Schedule II
public class Solution210 {
    private List<Integer>[] graph;
    private LinkedList<Integer> res = new LinkedList<>();
    private boolean hasCycle = false;
    private boolean[] visited;
    private Set<Integer> path = new HashSet<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        buildGraph(numCourses, prerequisites);
        visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                dfs(i);
                if (hasCycle) {
                    return new int[] {};
                }
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }

    private void buildGraph(int n, int[][] prerequisites) {
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[1];
            int to = prerequisite[0];
            graph[from].add(to);
        }
    }

    private void dfs(int v) {
        if (hasCycle) {
            return;
        }
        if (path.contains(v)) {
            hasCycle = true;
            return;
        }
        if (visited[v]) {
            return;
        }
        visited[v] = true;

        path.add(v);
        for (int nextNode : graph[v]) {
            dfs(nextNode);
        }
        
        path.remove(v);
        res.addFirst(v);
    }
}
