package InterviewQuestion;

@FunctionalInterface
interface Calculate{
	public abstract void sum(int a,int b);
}

public class TestLambdaExpresion {

	public static void main(String[] args) {
		LambdaExpresion expersion = 
				() -> System.out.println("Lambda Expresion");
		expersion.sum();
		
		Calculate cal = (a, b) -> {
			System.out.println(a + b);
		};
		
		cal.sum(10, 20);
	}
}
