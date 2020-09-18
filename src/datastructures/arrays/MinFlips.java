package datastructures.arrays;

public class MinFlips {
    //  Utility method to flip num
    public static int flip(int num)
    {
        return (num == 0) ? 1 : 0;
    }

    //  Utility method to get minimum flips when
    //  alternate num starts with expected num
    public static int getFlipWithStartingNum(int[] nums,
                                             int expected)
    {
        int flipCount = 0;
        for (int i = 0; i < nums.length; i++)
        {
            //  if current num is not expected,
            // increase flip count
            if (nums[i] != expected)
                flipCount++;

            //  flip expected num each time
            expected = flip(expected);
        }
        return flipCount;
    }

    // method return minimum flip to make binary
    // string alternate
    public static int minFlipToMakeArrayAlternate(int[] nums)
    {
        //  return minimum of following two
        //  1) flips when alternate string starts with 0
        //  2) flips when alternate string starts with 1
        return Math.min(getFlipWithStartingNum(nums, 0),
                getFlipWithStartingNum(nums, 1));
    }

    //  Driver code to test above method
    public static void main(String args[])
    {
        int[] nums = {0, 0, 0, 1, 0, 1, 0, 1, 1, 1};
        System.out.println(minFlipToMakeArrayAlternate(nums));
    }
}
