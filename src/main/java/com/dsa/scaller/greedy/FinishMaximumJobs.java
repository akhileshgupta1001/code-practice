package com.dsa.scaller.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public int solve(int[] A, int[] B) {
        List<Jobs> jobs = new ArrayList<>();
        for(int i=0;i<A.length;i++){
            jobs.add(new Jobs(A[i],B[i]));
        }
        Collections.sort(jobs,(a,b)->a.endTime-b.endTime);
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
}
