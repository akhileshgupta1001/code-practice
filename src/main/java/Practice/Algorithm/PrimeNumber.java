package Practice.Algorithm;

public class PrimeNumber {

    public static boolean isPrimeNumber(int number){
        int count =0;
        if(number != 1){
              for (int i = 2 ; i<= number;i++){
                  if(number %i == 0)
                      count ++;
              }
              if(count==1)
                  return  true;
         }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPrimeNumber( 9 ));
    }
}
