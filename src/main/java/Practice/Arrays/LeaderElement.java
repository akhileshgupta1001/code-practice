package Practice.Arrays;

import java.util.ArrayList;
import java.util.List;

public class LeaderElement {

    //7,10,4,10,6,5,2
    //0/p => 2,5,6,10

    public static void leader(int[] arr){
        List<Integer> list = new ArrayList<>();
        for(int i=0;i< arr.length;i++){
            boolean isAdd = true;
            for (int j=i+1;j<arr.length;j++){
                if(arr[i]<=arr[j]){
                    isAdd=false;
                    break;

                }
            }
            if (isAdd)
            list.add(arr[i]);
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        leader(new int[]{7,10,4,10,6,5,2});
    }
}
