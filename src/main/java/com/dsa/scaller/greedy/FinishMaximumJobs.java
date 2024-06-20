package com.dsa.scaller.greedy;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//There are N jobs to be done, but you can do only one job at a time.
//
//Given an array A denoting the start time of the jobs and an array B denoting the finish time of the jobs.
//
//Your aim is to select jobs in such a way so that you can finish the maximum number of jobs.
//
//Return the maximum number of jobs you can finish.
//
//
//
//Problem Constraints
//1 <= N <= 105
//
//1 <= A[i] < B[i] <= 109
//
//
//
//Input Format
//The first argument is an integer array A of size N, denoting the start time of the jobs.
//The second argument is an integer array B of size N, denoting the finish time of the jobs.
//
//
//
//Output Format
//Return an integer denoting the maximum number of jobs you can finish.
//
//
//
//Example Input
//Input 1:
//
// A = [1, 5, 7, 1]
// B = [7, 8, 8, 8]
//Input 2:
//
// A = [3, 2, 6]
// B = [9, 8, 9]
//
//
//Example Output
//Output 1:
//
// 2
//Output 2:
//
// 1
//
//
//Example Explanation
//Explanation 1:
//
// We can finish the job in the period of time: (1, 7) and (7, 8).
//Explanation 2:
//
// Since all three jobs collide with each other. We can do only 1 job.
class Jobs {
    int startTime;
    int endTime;

    Jobs(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Jobs{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}

public class FinishMaximumJobs {

    public static int solve(int[] A, int[] B) {
        List<Jobs> jobs = new ArrayList<>();
        for(int i=0;i<A.length;i++){
            jobs.add(new Jobs(A[i],B[i]));
        }
        Collections.sort(jobs,(a,b)->a.endTime-b.endTime);
        System.out.println("Jobs : "+jobs);
        int ans=1;
        int end = jobs.get(0).endTime;

        for(int i=1;i<B.length;i++){
            if(jobs.get(i).startTime>=end){
                ans++;
                end = jobs.get(i).endTime;
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[]{1, 5, 7, 1}, new int[]{7, 8, 8, 8}));
        //[1,0,1,0,1,0,1,0,1,0,0,1,0,1,0,1]
    }
}
