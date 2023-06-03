package com.dsa.scaller.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeIntervals {
    //Problem Description
    //Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
    //
    //You may assume that the intervals were initially sorted according to their start times.
    //
    //
    //
    //Problem Constraints
    //0 <= |intervals| <= 105
    //
    //
    //
    //Input Format
    //First argument is the vector of intervals
    //
    //second argument is the new interval to be merged
    //
    //
    //
    //Output Format
    //Return the vector of intervals after merging
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
    //Input 2:
    //
    //Given intervals [1, 3], [6, 9] insert and merge [2, 6] .
    //
    //
    //Example Output
    //Output 1:
    //
    // [ [1, 5], [6, 9] ]
    //Output 2:
    //
    // [ [1, 9] ]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //(2,5) does not completely merge the given intervals
    //Explanation 2:
    //
    //(2,6) completely merges the given intervals
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
     intervals.add(newInterval);
        Collections.sort(intervals,new Comparator<Interval>() {
        public int compare(Interval a, Interval b) {
            return Integer.compare(a.start, b.start);
        }
    });
    ArrayList<Interval> ans = new ArrayList<>();
    int left = intervals.get(0).start;
    int right = intervals.get(0).end;
        for(int i=1;i<intervals.size();i++){
        if(intervals.get(i).start<= right){
            right = Math.max(right,intervals.get(i).end);
        }else{
            ans.add(new Interval(left,right));
            left = intervals.get(i).start;
            right = intervals.get(i).end;
        }

    }
      ans.add(new Interval(left,right));
      return ans;
}
}
