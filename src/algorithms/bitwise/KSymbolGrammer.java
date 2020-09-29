package algorithms.bitwise;

/*
    On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01,
    and each occurrence of 1 with 10.

    Given row N and index K, return the K-th indexed symbol in row N.
    (The values of K are 1-indexed.) (1 indexed).

    Solution:-
    We see that, for any level N, the first half of the string is the same as the string in N-1,
    the next half is just complement of it. The total number of items in level N is 2^N.
    The half mark of the string is marked by [2^(N-1)]-th item. So, for any level N:

    if K is in the first half, it is same as the Kth element in level N-1
    if K is in the second half, it is the complement of the number in [K-2^(N-1)]-th position in level N-1

 */

public class KSymbolGrammer {
    public static int kthGrammar(int N, int K) {
        if (N == 1) {
            if (K == 1) return 0;
            else return 1;
        }
        double half = Math.pow(2 , N - 1);
        if (K <= (int) half) return kthGrammar(N - 1, K);
        else {
            int result = kthGrammar(N - 1, K - (int) half);
            if (result == 0) return 1;
            else return 0;
        }
    }

    /*
    Updates: (all index discussed below are 0-based)
    Observation 1: N does not matter as long as "K will be an integer in the range [1, 2^(N-1)]". We can ignore N.

    Observation 2: let f(k) be the value of kth position (0-based), then:
    f(2 * k) = 0 {if f(k) = 0} or, 1 {if f(k) = 1} => f(2 * k) = f(k) xor 0
    f(2 * k + 1) = 0 {if f(k) = 1} or 1 {if f(k) = 0} => f(2 * k + 1) = f(k) xor 1

    Observation 3: if binary string of k is used, let k = 1001010, then we have:
    f(1001010) = f(100101) ^ 0 = f(10010) ^ 1 ^ 0 = f(1001) ^ 0 ^ 1 ^ 0 = ... = f(0) ^ 1 ^ 0 ^ 0 ^1 ^ 0 ^ 1 ^ 0 = 1 ^ 0 ^ 0 ^1 ^ 0 ^ 1 ^ 0
    So, the result is the xor operation on all bits of k. Since 0 does not change xor result, we can ignore all 0s.
    f(1001010) = 1 ^ 1 ^ 1 = (1^1) ^ 1 = 0 ^ 1 = 1
    f(11110011) = 1 ^ 1^ 1 ^ 1 ^ 1 ^1 = (1 ^ 1) ^ (1 ^ 1) ^ (1 ^1) = 0
    Now, it's easy to tell f(k) = 0 if k has even number of 1s in binary representation, and f(k) = 1 when k has odd number of 1s

    public int kthGrammar(int N, int K) {
        return Integer.bitCount(K - 1) & 1;
    }
     */

    public static void main(String[] args) {
        System.out.println(kthGrammar(30, 434991989));
    }
}
