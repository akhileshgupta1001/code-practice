package Practice.Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindReplace {
    public String FindAndReplace(String A, String B, String C) {
        int
                startBracketIndex =
                A.indexOf('[');
        int
                colsedBracketIndex =
                A.indexOf(']');
        int
                replacableCharIndex =
                A.indexOf(B);
       /*
        if(replacableCharIndex>startBracketIndex && replacableCharIndex<colsedBracketIndex){
            A.replace(B,C);
        }
        System.out.println("Ans = "+A+" , startBracketIndex = "+startBracketIndex+" , colsedBracketIndex = "
        +colsedBracketIndex+" , replacableCharIndex = "+replacableCharIndex);
        */
        StringBuilder sb = new StringBuilder(A);
        boolean
                isBracketStart =
                false;
        for (int
             i =
             0; i < A.length(); i++) {
            if (A.charAt(i) == '[') {
                isBracketStart =
                        true;
            } else if (A.charAt(i) == ']') {
                isBracketStart =
                        false;
            } else if (isBracketStart) {
                System.out.println("A = "+A+" , B.indexOf(A.charAt(i)) = "+B.indexOf(A.charAt(i))+" , A.charAt(i) = "+A.charAt(i) );
                if (B.indexOf(A.charAt(i)) != -1) {
                   // A=A.replace(B, C);
                    sb.setCharAt(i,C.charAt(0));
                    System.out.println("After modifying A = " + A + " , B.indexOf(A.charAt(i)) = " + B.indexOf(A.charAt(i)) + " , A.charAt(i) = " + A.charAt(i));

                }
            }

        }
        System.out.println("A = "+sb);
        return A;

    }
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Map<Integer,Integer>
                map = new HashMap<>();
        for(int i=0;i<B;i++){
            map.put(A.get(i),map.getOrDefault(A.get(i),0)+1);
        }
        ans.add(map.size());
        //int startIndex=0;
        for(int i=B;i<A.size();i++){
            int startData = A.get(i-B);
            System.out.println("Remove data : "+ startData+ " , Map = "+map+" , Ans = "+ans);
            if(map.containsKey(startData)){
                map.put(startData,map.getOrDefault(startData,0)-1);
                if(map.get(startData)==0){
                    map.remove(startData);
                }
            }

            map.put(A.get(i),map.getOrDefault(A.get(i),0)+1);
            ans.add(map.size());
        }
        return ans;
    }
    public ArrayList<Integer> solve(int A) {
        int[] dp = new int[A+2];

        dp[0]=1;
        dp[1] =1;

        for(int i =2;i<=A+1;i++){
            dp[i]= dp[i-1]+dp[i-2];
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i=0;i<A;i++){
            int sum= dp[i]+dp[i+1];
            res.add(sum);
        }

        return res;
    }
    public static int[] rentCarWays(int A) {
        int[] dp = new int[A + 1];

        // Base cases
        dp[0] = 1;
        dp[1] = 1;

        // Calculate the number of ways to rent the car for each position
        for (int i = 2; i <= A + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int[] result = new int[A];

        // Calculate the number of ways to rent the car for each car position
        for (int i = 0; i < A; i++) {
            result[i] = dp[i] + dp[i + 1];
            System.out.println("result[" + i + "] = " + result[i]);
        }

        return result;
    }

    public static int continuousCharacterCount(String A, int B, char C) {
        int maxCount = 0;
        int left = 0;
        int right = 0;
        int changes = 0;

        while (right < A.length()) {
            if (A.charAt(right) != C) {
                changes++;
            }

            while (changes > B) {
                if (A.charAt(left) != C) {
                    changes--;
                }
                left++;
            }

            maxCount = Math.max(maxCount, right - left + 1);
            right++;
        }

        return maxCount;
    }
    public static void main(String[] args) {
      FindReplace findReplace = new FindReplace();
     // findReplace.FindAndReplace("a[ab]ba[bab]cz","a","b");
       // findReplace.dNums(new ArrayList<Integer>(Arrays.asList(2,7,7,81,81)),1);
        //rentCarWays(2);
        //continuousCharacterCount("oyorooms",)
    }
}
