package algorithms.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSets {
    //All possible subsets of superset

    public static List<List<Integer>> getSubSets(List<Integer> superSet) {
        List<List<Integer>> subSets = new ArrayList<>();
        getSubSets(superSet, 0, new ArrayList<>(), subSets);
        return subSets;
    }

    private static void getSubSets(List<Integer> superSet, int i, List<Integer> subSet, List<List<Integer>> subSets) {
        if (i == superSet.size()) subSets.add(new ArrayList<>(subSet));
        else {
            getSubSets(superSet, i + 1, subSet, subSets); //exclusion

            //inclusion - sandwich code pattern
            subSet.add(superSet.get(i));
            getSubSets(superSet, i + 1, subSet, subSets);
            subSet.remove(subSet.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(getSubSets(Arrays.asList(1,2,3)));
    }
}
