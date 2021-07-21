package InterviewQuestion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Student {
	
	private int id;
	private String name ;
	private String email;
	
	
	
	public Student(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + "]";
	}



public static void main(String[] args) {
	Set<Student> students = new HashSet<>();
	students.add(new Student(1, "Akhilesh", "akhi@gmail.com"));
	students.add(new Student(1, "Rahul", "rahul@gmail.com"));
	students.add(new Student(1, "Akhilesh", "akhi@gmail.com"));
	
	//System.out.println(students);
	
	List<Student> student = new ArrayList<>();
	student.add(new Student(3, "Akhilesh", "akhi@gmail.com"));
	student.add(new Student(2, "Rahul", "rahul@gmail.com"));
	student.add(new Student(1, "Akhilesh", "akhi@gmail.com"));
	student.add(new Student(5, "Ojasvi", "Ojasvi@gmail.com"));
	
	System.out.println("************Before Sorting****************");
	System.out.println(student);
	System.out.println("************Before Sorting****************");
	Collections.sort(student, new IdComparator());
	System.out.println();
	System.out.println("************After Sorting by Id****************");
	System.out.println(student);
	System.out.println("************After Sorting by Id****************");
	System.out.println();
	
	
	Collections.sort(student, new NameComparator());
	System.out.println();
	System.out.println("************After Sorting by name****************");
	System.out.println(student);
	System.out.println("************After Sorting by name****************");
	System.out.println();
	

}
}
