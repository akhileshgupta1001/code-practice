package InterviewQuestion;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

	private static List<Person> getPerson() {
		return Arrays.asList(new Person("AKHILESH", 56, Gender.MALE), new Person("RAHUL", 25, Gender.MALE),
				new Person("SHEFALI", 24, Gender.FEMALE), new Person("SAPNA", 49, Gender.FEMALE));
	}

	public static void main(String[] args) {
		List<Person> persons = getPerson();

		// Get only FEMALE
		List<Person> females = persons.stream()
				.filter(person -> person.getGender().equals(Gender.FEMALE))
				.collect(Collectors.toList());

		females.forEach(System.out::println);

		System.out.println("************Sorting*************");
		// sorting
		List<Person> sortingPersons = persons.stream().sorted(
				Comparator.comparing(Person::getAge).reversed())
				.collect(Collectors.toList());

		sortingPersons.forEach(System.out::println);
		
		//Max
		System.out.println("************MAX*************");
		persons.stream().max(Comparator.comparing(Person::getAge))
		.ifPresent(System.out::println);
		
		//Group by male person
		
		persons.stream().collect(Collectors.groupingBy(Person::getGender));
	}
}
