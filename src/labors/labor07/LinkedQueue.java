package labors.labor07;

import java.util.Random;

/**
 * @author LeeKrane
 */

public class LinkedQueue {
	private Node top;
	private Node tail;
	private int size;
	
	boolean isEmpty () {
		return size == 0;
	}
	
	int size () {
		return size;
	}
	
	@SuppressWarnings({"UnusedReturnValue", "SameReturnValue"})
	boolean add (Object object) {
		Node node = new Node(object, null);
		if (isEmpty())
			top = node;
		else if (size == 1) {
			top.setNext(node);
			tail = node;
		} else {
			tail.setNext(node);
			tail = node;
		}
		size++;
		return true;
	}
	
	Object get () {
		if (isEmpty())
			return null;
		Object ret = top.getElement();
		top = top.getNext();
		size--;
		return ret;
	}
	
	Object element () {
		if (isEmpty())
			return null;
		return top.getElement();
	}
	
	Object remove (int index) {
		if (isEmpty())
			return null;
		Node node = top;
		for (int i = 0; i < index - 1; i++)
			node = node.getNext();
		Object ret = node.getNext().getElement();
		node.setNext(node.getNext().getNext());
		return ret;
	}
	
	@Override
	public String toString () {
		StringBuilder builder = new StringBuilder("size: ").append(size).append('\n');
		Node node = top;
		while (node != null) {
			builder.append(node).append('\n');
			node = node.getNext();
		}
		return builder.toString();
	}
}

class Order {
	private String customer;
	private int quantity;
	
	public static void main (String[] args) {
		Random random = new Random();
		LinkedQueue queue = new LinkedQueue();
		
		for (int i = 0; i < Math.abs(random.nextInt()) % 4 + 4; i++)
			queue.add(new Order("Customer " + (i + 1), Math.abs(random.nextInt()) % 31 + 20));
		
		while (!queue.isEmpty()) {
			System.out.println(queue);
			System.out.println("Order {" + queue.get() + "} done.\n");
		}
	}
	
	public Order (String customer, int quantity) {
		this.customer = customer;
		this.quantity = quantity;
	}
	
	@Override
	public String toString () {
		return "customer: " + customer + "; quantity: " + quantity;
	}
}