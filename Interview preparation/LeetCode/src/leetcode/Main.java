package leetcode;

import dp.Solution1125;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Solution1125 solution1125 = new Solution1125();

        String[][] lists = new String[][]{
        {},{},{},{},{"jgpzzicdvgxlfix"},{"jgpzzicdvgxlfix", "k"},{"jgpzzicdvgxlfix", "kqcrfwerywbwi"},{"gvp"},{
        "jzukdzrfgvdbrunw"},{"gvp", "kqcrfwerywbwi"}
        };

        List<List<String>> people = new ArrayList<>();
        for(String[] list : lists){
            people.add(Arrays.asList(list));
        }

        solution1125.smallestSufficientTeam(new String[]{
                "gvp", "jgpzzicdvgxlfix", "kqcrfwerywbwi", "jzukdzrfgvdbrunw", "k"
        }, people);
    }
}
