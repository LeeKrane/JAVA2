package labors.labor07;

/**
 * @author LeeKrane
 */

public class LinkedStack {
	private Node topOfStack;
	private int size;
	
	public static void main (String[] args) {
		LinkedStack stack = new LinkedStack();
		stack.push('A');
		stack.push('B');
		stack.push('C');
		System.out.println(stack.toString());
	}
	
	void push(Object object) {
		topOfStack = new Node(object, topOfStack);
		size++;
	}
	
	Object pop() {
		if (isEmpty())
			return null;
		Object ret = topOfStack.getElement();
		topOfStack = topOfStack.getNext();
		size--;
		return ret;
	}
	
	boolean isEmpty() {
		return size == 0;
	}
	
	int size() {
		return size;
	}
	
	Object element() {
		if (isEmpty())
			return null;
		return topOfStack.getElement();
	}
	
	@Override
	public String toString () {
		StringBuilder builder = new StringBuilder();
		Node node = topOfStack;
		while (node != null) {
			builder.append(node.getElement()).append('\n');
			node = node.getNext();
		}
		return builder.toString();
	}
}