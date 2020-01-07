package labors.labor04;

/**
 * @author LeeKrane
 */

public class PortalCrane {
	/* private */ int[] silos;
	/* private */ int maximumFillValue;
	/* private */ int position;
	
	public static void main (String[] args) {
		PortalCrane crane = new PortalCrane(5, 10);
		crane.fill(4);
		crane.fill(1);
		crane.moveRight(2);
		crane.fill(20);
		crane.moveRight(2);
		crane.fill(1);
		crane.moveLeft(42);
		int content = crane.dropAll();
		crane.moveRight(1);
		crane.fill(content);
		System.out.println(crane);
	}
	
	public PortalCrane (int silos, int maximumFillValue) {
		this.silos = new int[silos];
		this.maximumFillValue = maximumFillValue;
	}
	
	void moveLeft (int i) {
		if (position - i < 0)
			i = position;
		position -= i;
	}
	
	void moveRight (int i) {
		if (position + i >= silos.length)
			i = silos.length - position - 1;
		position += i;
	}
	
	void fill (int x) {
		if (silos[position] + x > maximumFillValue)
			x = maximumFillValue - silos[position];
		else if (x < 0)
			x = 0;
		silos[position] += x;
	}
	
	int dropAll () {
		int content = silos[position];
		silos[position] = 0;
		return content;
	}
	
	@Override
	public String toString () {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < silos.length; i++) {
			builder.append("silo ").append(i + 1).append(": ").append(silos[i]);
			if (position == i)
				builder.append(" (current position)");
			builder.append('\n');
		}
		return builder.toString();
	}
	
	// fancy methods
	void fancyMoveLeft (int i) {
		position -= -Math.max(-position, -i);
	}
	
	void fancyMoveRight (int i) {
		position += Math.min(silos.length - 1 - position, i);
	}
	
	void fancyFill (int x) {
		silos[position] += x >= 0 ? Math.min(maximumFillValue - silos[position], x) : 0;
	}
}
