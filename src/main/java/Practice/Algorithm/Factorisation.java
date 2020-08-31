package Practice.Algorithm;

public class Factorisation {

    public  static void getPrimeFactorisation(int number){


        for(int i = 2; i<=number ;i++){

            if(number%i == 0){
                int powerCount = 0;
                while (number%i==0){
                    number = number/i;
                    powerCount++;
                }
                System.out.print(i+"("+powerCount+") ");
            }
        }

    }
}
