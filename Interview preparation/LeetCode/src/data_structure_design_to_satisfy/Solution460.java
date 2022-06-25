package data_structure_design_to_satisfy;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

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
