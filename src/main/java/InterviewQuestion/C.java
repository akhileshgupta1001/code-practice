package InterviewQuestion;

public class C implements A,B{

	@Override
	public void show() {
		//A.super.show();
		A.super.show();
		//System.out.println("Default");
	}

	public static void main(String[] args) {
		C c = new C();
		c.show();
	}
}
