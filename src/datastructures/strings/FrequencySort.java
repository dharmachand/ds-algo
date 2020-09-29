package datastructures.strings;

import java.util.*;

public class FrequencySort {
    public static String sortByFrequency(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            charMap.put(s.charAt(i), charMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        List<Map.Entry<Character, Integer>> charEntryList =
                new ArrayList<>(charMap.entrySet());
        Collections.sort(charEntryList,
                (o1, o2) -> (o2.getValue().compareTo(o1.getValue())));

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> charEntry : charEntryList) {
            for (int i = 0; i < charEntry.getValue(); i++) {
                sb.append(charEntry.getKey());
            }
        }

        return sb.toString();
    }

    public static String sortByFrequencyPq(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            charMap.put(s.charAt(i), charMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>( (a, b) ->
                charMap.get(b) - charMap.get(a) );
        pq.addAll(charMap.keySet());

        StringBuilder sb = new StringBuilder();
        Character current;
        while (!pq.isEmpty()) {
            current = pq.remove();
            for (int i = 0; i < charMap.get(current); i++)
                sb.append(current);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(sortByFrequency("tree"));
        System.out.println(sortByFrequency("applllllleeeeeeee"));

        System.out.println(sortByFrequencyPq("tree"));
        System.out.println(sortByFrequencyPq("applllllleeeeeeee"));
    }
}
