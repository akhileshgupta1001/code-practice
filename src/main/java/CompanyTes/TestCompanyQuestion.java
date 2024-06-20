package CompanyTes;

import java.util.Arrays;
import java.util.Comparator;



interface  Operation{
    public  abstract  int sum(int first, int second);
}
public class TestCompanyQuestion {
    // [1,2,3,4,5]  -> 54321
    //[9,11] ->911
    // [1,0,2]-> 210  -> String[ 1,0,2]  ( 1+0 =10 , 01 , 10,2 -> 102,210
    //[1,0]-> (10)
     //
    // 6 Digits
    // + elements
    public static  void test(int[] arr){
        String[] data = new String[arr.length];
        for(int i=0;i<arr.length;i++){
            data[i]=String.valueOf(arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        /*
        for(int i =0;i< data.length;i++ ){
            Arrays.sort(data, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return 0;
                }
            });
        }

         */


        Arrays.sort(data,(a,b)->(b+a).compareTo(a+b));

        Arrays.sort(data, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -(o1+o2).compareTo(o2+o1);
            }
        });


        System.out.println(Arrays.toString(data));



    }

    public static void main(String[] args) {
        Operation operation = (a,b)->{
            System.out.println((a+b));
            return (a+b);
        };
        operation.sum(2,3);

       // test(new int[]{1,0,2});
       //test(new int[]{9,11});
    }
}
