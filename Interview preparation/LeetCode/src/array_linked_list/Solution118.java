package array_linked_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 118. Pascal's Triangle
public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(1));
        for (int i = 1; i < numRows; i++) {
            int eleNum = i + 1;
            List<Integer> list = new ArrayList<>();
            List<Integer> lastList = res.get(res.size() - 1);
            for (int j  =0; j < eleNum; j++) {
                int a = ((j - 1 < 0) ? 0 : lastList.get(j - 1));
                int b = ((j == lastList.size()) ? 0 : lastList.get(j));
                list.add(a + b);
            }

            res.add(list);
        }

        return res;
    }
}
