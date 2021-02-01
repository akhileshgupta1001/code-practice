package Practice.Algorithm;

import java.util.ArrayList;
import java.util.List;

public class AllPrimeNumber {

    public static List getAllPrimeNumber(int number) {

        ArrayList primeList = new ArrayList();
        if (number != 1) {
            for (int i = 2; i <= number; i++) {
                if (PrimeNumber.isPrimeNumber( i )) {
                    primeList.add( i );
                }   
            }
        }
        return primeList;
    }
}
