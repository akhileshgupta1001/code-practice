package Practice.Arrays;

public class Palindrome {
    public static void main(String[] args) {
        System.out.print(isPalindrom(121));
    }

    private static boolean isPalindrom(int num) {
        int orginal=num;
        int result=0;
        while (num>0){
            result =result*10+num%10;
            num=num/10;
        }

        return orginal==result;
    }
}
