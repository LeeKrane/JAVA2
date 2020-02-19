package labors.labor07;

public class Node {
	private Object element;
	private Node next;
	
	public Node (Object element, Node next) {
		this.element = element;
		this.next = next;
	}
	
	public Object getElement () {
		return element;
	}
	
	public Node getNext () {
		return next;
	}
	
	public void setNext (Node next) {
		this.next = next;
	}
	
	@Override
	public String toString () {
		return element.toString();
	}
}