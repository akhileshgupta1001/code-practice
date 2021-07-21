package InterviewQuestion.sigltonClass;

public class EggerSingleton {

	private EggerSingleton() {
	}

	private static final EggerSingleton instance = new EggerSingleton();

	public static EggerSingleton getInstance() {
		return instance;
	}

}
