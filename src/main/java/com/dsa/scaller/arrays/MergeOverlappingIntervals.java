package com.dsa.scaller.arrays;

import InterviewQuestion.A;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

 class MergeOverlappingIntervals {
    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return Integer.compare(a.start, b.start);
            }
        });
        ArrayList<Interval> ans = new ArrayList<>();
        int left = intervals.get(0).start;
        int right = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {

            if (intervals.get(i).start <= right) {
                right = Math.max(right, intervals.get(i).end);
                // ans.add(new Interval(left,right));
            } else {
                ans.add(new Interval(left, right));
                left = intervals.get(i).start;
                right = intervals.get(i).end;
                //  ans.add(new Interval(left,right));
            }

        }
        ans.add(new Interval(left, right));
        //List<Interval> ans1= ans.stream().distinct().collect(Collectors.toList());
        return ans;
    }


        public static void main (String[]args){
            ArrayList<Interval> input = new ArrayList<>();
            input.add(new Interval(1, 3));
            input.add(new Interval(2, 6));
            input.add(new Interval(8, 10));
            input.add(new Interval(15, 18));
            System.out.println(merge(input));
        }
    }

    class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
