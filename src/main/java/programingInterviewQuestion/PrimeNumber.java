package programingInterviewQuestion;

import java.util.Arrays;

public class PrimeNumber {

	public static boolean isPrime(int num) {
		
		for(int i=2;i<num;i++) {
			if(num%i==0)
				return false;
		}
		
		return true;
	}
	
	// find all prime number between 1 to n
	//Sieve of Eratosthenes algo
	// root(n)
	public static void findAllPrimeNumberBetween(int n){
		
		boolean isPrime[] = new boolean[n+1];
		Arrays.fill(isPrime, true);
		isPrime[0]=false;
		isPrime[1]=false;
		//root(n) ==> i*i<=n
		for(int i=2;i*i<=n;i++) {
			
			//for mulitple of 2 
			for(int j=2*i;j<=n;j=j+i) {
				isPrime[j]=false;
			}
		}
		
		for(int i=0;i<=n;i++) {
			if(isPrime[i])
				System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(isPrime(10));
		System.out.println(isPrime(7));
		findAllPrimeNumberBetween(20);
	}
}
