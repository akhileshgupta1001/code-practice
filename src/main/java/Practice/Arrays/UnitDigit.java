package Practice.Arrays;

public class UnitDigit {
    public static int sum(int n){
        if(n==1 || n==1) return n;
        return ((n%10)*(n%10))+ sum(n/10);
    }
    static long solve(int l, int r){
        int sum =0;
        while(l/10>0){
            sum = sum+ sum(l);
            l = l/10;
        }

        while(r/10>0){
            sum = sum+ sum(r);
            r = r/10;
        }

        if(sum==2)
            return l+r;


        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solve(31,32));
    }
}
