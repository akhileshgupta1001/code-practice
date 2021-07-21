package InterviewQuestion.sigltonClass;

public class DoubleCheckingSingleton {

	private DoubleCheckingSingleton() {
	}

	private static DoubleCheckingSingleton instance;

	public static DoubleCheckingSingleton getInstance() {
		if (instance == null)
			synchronized (DoubleCheckingSingleton.class) {
				if (instance == null)
					return instance = new DoubleCheckingSingleton();

			}
		return instance;
	}
}
