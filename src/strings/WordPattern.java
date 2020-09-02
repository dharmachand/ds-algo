package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class WordPattern {
    public static boolean wordPattern(String pattern, String str) {
        Map<String, Character> wordMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(str);
        int i = 0;
        char c;
        String word;
        while (st.hasMoreTokens()) {
            if (i == pattern.length()) return false;
            word = st.nextToken();
            c = pattern.charAt(i++);
            if (!wordMap.containsKey(word)) {
                if (wordMap.containsValue(c)) return false;
                wordMap.put(word, c);
            } else {
                if (wordMap.get(word).equals(c)) continue;
                else return false;
            }
        }
        if (i < pattern.length()) return false;
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog cat cat dog";
        System.out.println(wordPattern(pattern, str));
    }
}
