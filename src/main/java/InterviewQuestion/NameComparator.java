package InterviewQuestion;

import java.util.Comparator;

public class NameComparator implements Comparator<Student> {

	@Override
	public int compare(Student student, Student student2) {
		return student.getName().compareTo(student2.getName());
	}

}
