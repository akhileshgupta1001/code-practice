package InterviewQuestion.sigltonClass;

public class LazyInnerClassSingleton {

	private LazyInnerClassSingleton() {
	}

	private static class SingletonHelper {
		private static final LazyInnerClassSingleton instance 
		= new LazyInnerClassSingleton();
	}

	private static LazyInnerClassSingleton getInstance() {
		return SingletonHelper.instance;
	}

}
