package InterviewQuestion;

import java.util.Comparator;

public class IdComparator implements Comparator<Student> {

	@Override
	public int compare(Student student, Student student2) {
		if (student.getId() == student2.getId())
			return 0;
		else if (student.getId() > student2.getId())
			return 1;
		else
			return -1;
	}

}
