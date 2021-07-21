package InterviewQuestion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CustomArrayList extends ArrayList {

	@Override
	public boolean add(Object e) {
		if (this.contains(e))
			return true;
		else
			return super.add(e);
	}
	
	
	public static void main(String[] args) {
		CustomArrayList list = new CustomArrayList();
		
		list.add("A");
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("B");
		
		System.out.println(list);
		
		Set s = new HashSet<>();	}

}
