import java.util.HashMap;
import java.util.Map;

public class LCS {

    public static int getLCS(String str){
        int left =0;
        int right =0;
        int ans =0;
        Map<Character,Integer> map = new HashMap<>();
        int len= str.length();
        while (right<len){
            char currentChar = str.charAt(right);

            if(map.containsKey(currentChar)){
              left=Math.max(map.get(currentChar)+1,left);
            }

            ans = Math.max(ans,right-left+1);
            map.put(currentChar,right);

            right++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(getLCS("pwwkew"));
    }
}
