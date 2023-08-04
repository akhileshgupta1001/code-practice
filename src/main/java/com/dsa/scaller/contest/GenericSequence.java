package com.dsa.scaller.contest;

public class GenericSequence {
    public static long solve(String A) {
        int ans = 0;
        int countSingle = 0;
        for (int i = 0; i < A.length(); i++) {
            int count = 0;
            String data="";
            for (int j = i; j <A.length(); j++) {
                for(int k=i;k<=j;k++) {
                    data = data + A.charAt(j);
                    if (data.length() == 1)
                        countSingle++;
                    if (data.length() > 1 && data.charAt(0) == data.charAt(data.length() - 1))
                        count++;
                }
                count = countSingle+ count;
                ans = Math.max(ans,count);
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solve("bccb"));
    }
}
