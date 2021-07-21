package InterviewQuestion.sigltonClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestSingleton {

	public static void main(String[] args) throws 
	CloneNotSupportedException, InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, 
			FileNotFoundException, IOException,
			ClassNotFoundException {

		LazySingleton singleton = LazySingleton.getInstance();
		//System.out.println(singleton.hashCode());

		// LazySingleton singleton2 = (LazySingleton) singleton.clone();
		// System.out.println(singleton2.hashCode());

		/*
		 * LazySingleton reflectionInstance=null; Constructor[] constructors =
		 * LazySingleton.class.getDeclaredConstructors(); for (Constructor constructor :
		 * constructors) { constructor.setAccessible(true); reflectionInstance =
		 * (LazySingleton) constructor.newInstance(); }
		 * 
		 * System.out.println(reflectionInstance.hashCode());
		 * 
		 */

		// Serialize singleton object to a file.
		ObjectOutput out = new ObjectOutputStream(new 
				FileOutputStream("singleton.ser"));
		out.writeObject(singleton);
		out.close();

		// Deserialize singleton object from the file
		ObjectInput in = new ObjectInputStream(new
				FileInputStream("singleton.ser"));
		LazySingleton instance2 = (LazySingleton) in.readObject();
		in.close();

		System.out.println("instance1 hashCode: " + singleton.hashCode());
		System.out.println("instance2 hashCode: " + instance2.hashCode());

	}
}
