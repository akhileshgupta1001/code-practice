package InterviewQuestion;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class ReverseOfString {
public static void main(String[] args) {
	String name ="Akhilesh";
	
	System.out.println("****************************");
	System.out.println(name);
	System.out.println("****************************");
	
	System.out.println(new StringBuffer(name).reverse());
	
	Function<String, String> data = string-> new StringBuilder(string).reverse().toString();
	System.out.println(data.toString());
	
	

}}
