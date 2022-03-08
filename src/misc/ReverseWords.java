package misc;

public class ReverseWords {
    public static void main(String[] args) {
        char[] a = {'H', 'e', 'l', 'l', 'o', 'o',' ',
                'J', 'a', 'v', 'a', ' ',
                'W', 'o', 'r', 'l', 'd'};
        //char[] a = {'H', 'e', 'l', 'l', 'o', 'o'};
        System.out.println(String.valueOf(a));

        int n = a.length;
        // reverse whole sentence array
        reverse(a, 0, n - 1);

        //reverse each word in sentence array
        int ws = 0, we = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == ' ') {
                we = i - 1;
                reverse(a, ws, we);
                ws = i + 1;
            }
        }
        if (ws > 0) reverse(a, ws, n - 1);

        System.out.println(String.valueOf(a));
    }


    private static void reverse(char[] s, int start, int end) {
        if (end - start < 2) return;
        int i = start, j = end;
        char temp;
        while (i < j) {
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++; j--;
        }
    }

}
