package programingInterviewQuestion;

public class AdditionOfTwoNumber {
	public static void main(String[] args) {
     Calculation cal= (a,b)-> a+b;
     System.out.println(cal.sum(2, 3));
	}
}


@FunctionalInterface interface Calculation {
	public abstract int sum(int a,int b);
}
