package sigleton;

import java.io.Serializable;

public class SingletonDesign  implements Serializable {
    private SingletonDesign() {
        //protected from reflection
        if (instance != null) {
            throw new IllegalStateException("Object can't created using reflection");
        }
    }

    private static SingletonDesign instance;

    public static synchronized SingletonDesign getInstance() {
        if (instance == null)
            instance = new SingletonDesign();
        return instance;
    }

    // proteced from clone method
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

}


class DoubleCheckingLazySingleton {

    private DoubleCheckingLazySingleton() {
    }

    private static DoubleCheckingLazySingleton instance;

    public static DoubleCheckingLazySingleton getInstance() {

        if (instance == null) {
            synchronized (DoubleCheckingLazySingleton.class) {
                if (instance == null)
                    instance = new DoubleCheckingLazySingleton();
            }
        }
        return instance;
    }

}


class LazzyInnerClassSingleton {

    private LazzyInnerClassSingleton() {
    }

    private static class InnerClassSingleton {
        private static final LazzyInnerClassSingleton instance = new LazzyInnerClassSingleton();
    }

    public static LazzyInnerClassSingleton getInstance() {
        return InnerClassSingleton.instance;
    }
}