package data_structure_design_to_satisfy;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

// 460. LFU Cache
public class Solution460 {

    public static class LFUCache {
        private class Tuple {
            int value;
            int count;
        }

        private int leastCount = 0;
        private Map<Integer, Tuple> cache = new HashMap<>();
        private Map<Integer, LinkedHashSet<Integer>> countToKeyList = new HashMap<>();
        private int capacity = 0;

        public LFUCache(int capacity) {
            this.capacity = capacity;
        }
        public int get(int key) {
            if (cache.containsKey(key)) {
                Tuple tuple = cache.get(key);
                int oldCount = tuple.count;
                int newCount = oldCount + 1;
                tuple.count = newCount;

                LinkedHashSet<Integer> oldList = countToKeyList.get(oldCount);
                oldList.remove(Integer.valueOf(key));
                if (oldList.isEmpty()) {
                    countToKeyList.remove(oldCount);
                    if (leastCount == oldCount) {
                        leastCount++;
                    }
                }
                LinkedHashSet<Integer> newList = countToKeyList.get(newCount);
                if (newList == null) {
                    newList = new LinkedHashSet<>();
                    countToKeyList.put(newCount, newList);
                }
                newList.add(key);

                return tuple.value;
            } else {
                return -1;
            }
        }
        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            if(cache.containsKey(key)) {
                get(key);
                Tuple tuple = cache.get(key);
                tuple.value= value;
            } else {
                if(cache.size() == capacity) {
                    LinkedHashSet<Integer> list = countToKeyList.get(leastCount);
                    int oldkey = list.iterator().next();
                    list.remove(oldkey);
                    cache.remove(oldkey);
                    if (list.isEmpty()) {
                        countToKeyList.remove(leastCount);
                    }
                }
                leastCount = 1;
                LinkedHashSet<Integer> newList = countToKeyList.get(leastCount);
                if (newList == null) {
                    newList = new LinkedHashSet<>();
                    countToKeyList.put(leastCount, newList);
                }
                newList.add(key);
                Tuple tuple = new Tuple();
                tuple.count = 1;
                tuple.value = value;
                cache.put(key, tuple);
            }
        }
    }
}

class Solution460_attempt1{
    class LFUCache {

        private final int capacity;
        private int currentCapacity = 0;
        private Map<Integer, Set<Integer>> counterToKeySetMap = new HashMap<>();
        private Map<Integer, int[]> data = new HashMap<>();
        private int smallestCounter = 1;

        public LFUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            int[] tuple = data.get(key);
            if(tuple == null){
                return -1;
            }

            int value = tuple[0];
            int counter = tuple[1];


            Set<Integer> keySet = counterToKeySetMap.get(counter);
            keySet.remove(key);
            if(keySet.isEmpty()){
                counterToKeySetMap.remove(counter);
                if(smallestCounter == counter){
                    smallestCounter = counter + 1;
                }
            }

            counter++;
            tuple[1] = counter;

            Set<Integer> newKeySet = counterToKeySetMap.get(counter);
            if(newKeySet == null){
                newKeySet = new LinkedHashSet<>();
                counterToKeySetMap.put(counter, newKeySet);
            }
            newKeySet.add(key);

            return value;
        }

        public void put(int key, int value) {
            if(capacity == 0){
                return;
            }
            int counter = 1;
            if(data.containsKey(key)) {
                int[] tuple = data.get(key);
                counter = tuple[1];

                Set<Integer> keySet = counterToKeySetMap.get(counter);
                keySet.remove(key);
                if (keySet.isEmpty()) {
                    counterToKeySetMap.remove(counter);
                    if (smallestCounter == counter) {
                        smallestCounter = counter + 1;
                    }
                }

                counter++;
            } else {
                if(currentCapacity == capacity){
                    removeLeastUsedKey();
                }
                currentCapacity++;
            }

            data.put(key, new int[]{value, counter});
            Set<Integer> newKeySet = counterToKeySetMap.get(counter);
            if(newKeySet == null){
                newKeySet = new LinkedHashSet<>();
                counterToKeySetMap.put(counter, newKeySet);
            }
            newKeySet.add(key);

            if(counter == 1){
                smallestCounter  = 1;
            }
        }

        private void removeLeastUsedKey(){
            Set<Integer> keySet = counterToKeySetMap.get(smallestCounter);
            int key = keySet.iterator().next();
            keySet.remove(key);
            data.remove(key);

            if(keySet.isEmpty()){
                counterToKeySetMap.remove(smallestCounter);
            }

            currentCapacity--;
        }
    }

}