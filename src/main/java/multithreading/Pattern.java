package multithreading;

import java.util.Scanner;

public class Pattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of terms: ");
        int n = sc.nextInt();
        sc.close();

        String res = "1";
        System.out.println(res);
        for (int i = 1; i < n; i++) {
            int count = 1;
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < res.length(); j++) {
                if (res.charAt(j) == res.charAt(j - 1)) {
                    count++;
                } else {
                    sb.append(count).append(res.charAt(j - 1));
                    count = 1;
                }
            }
            sb.append(count).append(res.charAt(res.length() - 1));
            res = sb.toString();
            System.out.println(res);
        }
    }
}
//1
//11
//21
//1211
//111221
//312211
//13112221
