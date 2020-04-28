package labors.labor11;

import java.util.Random;

public class Person implements Speaker {
	private MuteException muteException;
	
	public Person (boolean mute) {
		if (mute)
			this.muteException = new MuteException(this);
	}
	
	@Override
	public String speak () throws MuteException {
		if (muteException != null)
			throw muteException;
		return "Hello";
	}
	
	public static void main (String[] args) {
		Speaker[] speakers = new Speaker[100];
		Random random = new Random();
		
		for (int i = 0; i < speakers.length; i++) {
			switch (Math.abs(random.nextInt()) % 3) {
				case 0:
					if (Math.abs(random.nextInt()) % 20 == 0)
						speakers[i] = new Person(true);
					else
						speakers[i] = new Person(false);
					break;
				case 1:
					speakers[i] = new Cat();
					break;
				case 2:
					speakers[i] = new Dog();
			}
		}
		
		for (Speaker speaker : speakers) {
			try {
				System.out.println(speaker.speak());
			} catch (MuteException e) {
				System.err.println("Person is mute.");
			}
		}
	}
}
