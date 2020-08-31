package Practice.Algorithm;

import java.util.Scanner;

public class InputUtils {

    private static int[] getInput(Scanner scanner) {
        System.out.println("Enter the number of input");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("ENter the input array");
        for(int i = 0; i<n;i++){
            arr[i]=scanner.nextInt();
        }
        for (int num:arr)
            System.out.print(num+" ");

        return arr;
    }

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        //getInput(scanner);
         }


}

