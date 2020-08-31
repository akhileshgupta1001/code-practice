package Practice.Algorithm;

public class HCF {

    public static final int gcdOfTwoNumber(int a, int b){

        if(a==b)return a;
        if(a==0)return b;
        if(b==0)return a;
        if(a>b) gcdOfTwoNumber(a-b,b);
        return gcdOfTwoNumber(a,b-a);
    }

    public  static int hcfOfTwoNumber(int first, int second){

        int hcf=1 ,lowest = first<second?first:second;
        for (int i = lowest;i>=1;i--){
            if(first %i ==0 && second %i==0){
                hcf =i;
                break;
            }
        }
        return hcf;
    }

    public static  int hcfOfTwoNumberUsingLCM(int first , int second){
        return  ((first*second)/LCM.findLcm( first,second ));
    }

    public  static  int  findHcf(int arr[]) {

        int smallest = HelperUtility.smallestNumber( arr );
        boolean isNumberFound = false;
        int hcf = 0;
        while (!isNumberFound) {

            int i = 0;
            while (arr[i] % smallest == 0 && i < arr.length - 1) {
                i++;
            }
            if (i == arr.length - 1)
                return smallest;
            else
                smallest--;
        }
        return smallest;
    }

    public  static int getHcf(int arr[]){
        int result = arr[0];
        for (int i = 1;i<arr.length;i++){
            result = hcfOfTwoNumber( result,arr[i] );
        }
        return  result;
    }

}
