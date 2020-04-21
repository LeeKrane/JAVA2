package labors.labor02;

import java.time.LocalDate;

/**
 * @author LeeKrane
 */

@SuppressWarnings("SameParameterValue")
public class Person {
	private String firstName;
	private String name;
	private int birthYear;
	
	@SuppressWarnings("unused")
	public static void main (String[] args) {
		Person p = new Person();
		Person p1 = new Person(2000);
		Person p2 = new Person("Maier", 1998);
		Person p3 = new Person("Schmidt", "Franz", 1998);
		p1.setName("Bauer");
		p1.setFirstName("Hans");
		p2.setFirstName("Eva");
		System.out.println(p1 + " is " + p1.getAge() + " years old.");
		if (p2.sameAge(p3))
			System.out.println(p2 + " and " + p3 + " are the same age.");
		if (Person.sameAge(p2, p3))
			System.out.println(p2 + " and " + p3 + " are the same age.");
	}
	
	private Person () {
		this("N.N.", "N.N.", 0);
	}
	
	private Person (int birthYear) {
		this("N.N.", "N.N.", birthYear);
	}
	
	private Person (String name, int birthYear) {
		this(name, "N.N.", birthYear);
	}
	
	private Person (String name, String firstName, int birthYear) {
		this.name = name;
		this.firstName = firstName;
		this.birthYear = birthYear;
	}
	
	private boolean sameAge (Person p) {
		return Person.sameAge(this, p);
	}
	
	private static boolean sameAge (Person p1, Person p2) {
		return p1.getAge() == p2.getAge();
	}
	
	private int getAge () {
		return LocalDate.now().getYear() - birthYear;
	}
	
	private void setFirstName (String firstName) {
		this.firstName = firstName;
	}
	
	private void setName (String name) {
		this.name = name;
	}
	
	@Override
	public String toString () {
		return name + " " + firstName;
	}
}
