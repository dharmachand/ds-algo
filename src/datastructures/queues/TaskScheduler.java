package datastructures.queues;

import java.util.*;

public class TaskScheduler {
    public static int leastInterval(char[] tasks, int n) {
        //count instances of each type of task
        int[] taskAry = new int [26];
        for (char c : tasks) {
            taskAry[ c - 'A']++;
        }
        Arrays.sort(taskAry); //sort the array by task instance count

        int time = 0, i;
        //sorting when time crosses cooling period sorts non zero highest instance tasks to the end
        while (taskAry[25] > 0) {
            i = 0;
            while (i <= n) {
                if (taskAry[25] == 0) break;
                if (i < 26 && taskAry[25 - i] > 0) taskAry[25 - i]--;
                time++;
                i++;
            }
            Arrays.sort(taskAry);
        }
        return time;
    }

    public static void main(String[] args) {
        //char[] tasks = {'A','A','A','B','B','B'};
        //int coolingPeriod = 2;
        //Expected: 8

        //char[] tasks = {'A','B','C','D','E','A','B','C','D','E'};
        //int coolingPeriod = 4;
        //Expected: 10

        char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        int coolingPeriod = 2;
        System.out.println("Least Interval: " + leastInterval(tasks, coolingPeriod) );
    }
}
