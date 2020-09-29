package datastructures.strings;

public class CharOccurrences {
    //'a' should before 'b'
    public static void main(String[] args) {
        //String s = "abba";
        String s = "aabbb";
        //String s = "aaaaaa";
        //String s = "bbb";
        //String s = "ba";
        System.out.println(occurrences(s));
    }

    private static boolean occurrences(String s) {
        int bFirstIdx = s.indexOf('b');
        int aLastIdx = s.lastIndexOf('a');

        if (bFirstIdx == -1 || aLastIdx == -1 || aLastIdx < bFirstIdx) return true;
        else return false;
    }
}
