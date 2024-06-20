import java.util.Arrays;

public class CMTest {

    // F(n) = f(n-1)+f(n-2)
    public static int getFiboniSerries(int num,int[] dp, int index){
        if(num==0|| num==1){
           // System.out.print("1"+" , ");
            dp[num]=1;
            return 1;
        }
        dp[index]= getFiboniSerries(num-1,dp,index-1)+getFiboniSerries(num-2,dp,index-2);
        //System.out.print(getFiboniSerries(num-1)+" , "+getFiboniSerries(num-2)+ " ");
        return dp[index];
    }

    public static void main(String[] args) {
        int numb = 30;
        int[] dp = new int[numb+1];
        int idex=5;
        System.out.println(getFiboniSerries(numb,dp,idex));
        System.out.println(Arrays.toString(dp));
    }
}
