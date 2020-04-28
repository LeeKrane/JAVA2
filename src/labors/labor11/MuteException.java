package labors.labor11;

public class MuteException extends Exception {
	private Person person;
	
	public MuteException (Person person) {
		this.person = person;
	}
}
