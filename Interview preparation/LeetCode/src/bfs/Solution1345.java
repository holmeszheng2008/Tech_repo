package bfs;

import java.util.*;

// 1345. Jump Game IV
class Solution1345_bfs {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            int value = arr[i];
            List<Integer> list = map.get(value);
            if(list == null){
                list = new ArrayList<>();
                map.put(value, list);
            }
            list.add(i);
        }

        int step = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while(!queue.isEmpty()){
            int size = queue.size();
            Set<Integer> nextLevelSet = new HashSet<>();
            for(int i = 0; i < size; i++){
                int index = queue.poll();
                if(index == arr.length - 1){
                    return step;
                }
                List<Integer> nextIndices = nextIndices(index, arr, map);
                nextLevelSet.addAll(nextIndices);
            }

            step++;
            queue.addAll(nextLevelSet);
        }

        return -1;
    }

    private List<Integer> nextIndices(int index, int[] arr, Map<Integer, List<Integer>> map){
        List<Integer> list = new ArrayList<>();
        if(index != 0){
            list.add(index - 1);
        }
        if(index != arr.length - 1){
            list.add(index + 1);
        }
        List<Integer> indexList = map.get(arr[index]);
        if(indexList == null){
            return list;
        }
        for(int nextIndex : indexList){
            if(nextIndex == index){
                continue;
            }
            list.add(nextIndex);
        }

        map.remove(arr[index]);

        return list;
    }
}

public class Solution1345 {
    private static class State {
        public int index;
        public int dist;

        public State(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }
    }
    public int minJumps(int[] arr) {
        int[] distToFromStart = new int[arr.length];
        Arrays.fill(distToFromStart, Integer.MAX_VALUE);

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            int value = arr[i];
            List<Integer> list = map.get(value);
            if(list == null){
                list = new ArrayList<>();
                map.put(value, list);
            }
            list.add(i);
        }

        PriorityQueue<State> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
        pq.add(new State(0, 0));
        distToFromStart[0] = 0;

        while(!pq.isEmpty()){
            State currentSate = pq.poll();
            int index = currentSate.index;
            int dist = currentSate.dist;
            if(dist > distToFromStart[index]){
                continue;
            }
            if(index == arr.length - 1){
                return dist;
            }

            List<Integer> nextIndices = nextIndices(index, arr, map);
            for(int nextIndex : nextIndices){
                int nextDist = dist + 1;
                if(nextDist < distToFromStart[nextIndex]){
                    distToFromStart[nextIndex] = nextDist;
                    pq.add(new State(nextIndex, nextDist));
                }
            }
        }

        return -1;
    }

    private List<Integer> nextIndices(int index, int[] arr, Map<Integer, List<Integer>> map){
        List<Integer> list = new ArrayList<>();
        if(index != 0){
            list.add(index - 1);
        }
        if(index != arr.length - 1){
            list.add(index + 1);
        }
        List<Integer> indexList = map.get(arr[index]);
        if(indexList == null){
            return list;
        }
        for(int nextIndex : indexList){
            if(nextIndex == index){
                continue;
            }
            list.add(nextIndex);
        }

        map.remove(arr[index]);

        return list;
    }
}