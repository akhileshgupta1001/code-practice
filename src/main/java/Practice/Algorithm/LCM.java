package Practice.Algorithm;

public class LCM {

    public  static int   findLcm(int firstNumber , int secondNumber){

        int lcm=1 ,  largest = firstNumber>secondNumber?firstNumber:secondNumber;
        for (int i = largest ; i<=firstNumber*largest;i=i+largest)
            //Larget/first ==0 && largest/second
            if (i %firstNumber == 0 && i%secondNumber == 0) {
                lcm = i;
                break;
            }
            return lcm;
    }
    public static int getLcmUsingHCF(int first,int second){
         return ((first * second) / HCF.gcdOfTwoNumber( first,second ));
    }

    public static  int findLcm(int arr[]) {

        int largest = HelperUtility.getLargestNumber( arr );
        boolean isNumberFound = false;
        int lcm = 0;
        while (!isNumberFound) {
            lcm = lcm + largest;
            int i = 0;
            while (lcm % arr[i] == 0 && i<arr.length-1) {
                i++;
            }
            if (i == arr.length-1){
                isNumberFound = true;
                break;
            }
        }
        return lcm;
    }

    public  static  int getLcm(int arr[]) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = findLcm( result, arr[i] );
        }
        return result;
    }
}
