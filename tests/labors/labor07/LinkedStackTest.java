package labors.labor07;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author LeeKrane
 */

class LinkedStackTest {
	LinkedStack stack;
	
	@BeforeEach
	void createLinkedStackObject () {
		stack = new LinkedStack();
		for (int i = 1; i < 4; i++)
			stack.push(i);
	}
	
	@Test
	void push_filledStack_pushCorrectObjects () {
		stack.push(4);
		assertEquals(4, stack.size());
		assertEquals(4, stack.element());
		stack.push(5);
		assertEquals(5, stack.size());
		assertEquals(5, stack.element());
	}
	
	@Test
	void pop_filledStack_popCorrectObjectsAndDeleteOutOfStack () {
		assertEquals(3, stack.pop());
		assertEquals(2, stack.pop());
		assertEquals(1, stack.size());
	}
	
	@Test
	void isEmpty_filledStack_correctDeterminationOfEmptiness () {
		assertFalse(stack.isEmpty());
		stack.pop();
		stack.pop();
		stack.pop();
		assertTrue(stack.isEmpty());
	}
	
	@Test
	void size_filledStack_correctDeterminationOfSize () {
		assertEquals(3, stack.size());
		stack.pop();
		assertEquals(2, stack.size());
		stack.push(3);
		stack.push(4);
		assertEquals(4, stack.size());
	}
	
	@Test
	void element_filledStack_getElementWithoutRemovingTopOfStack () {
		assertEquals(3, stack.size());
		assertEquals(3, stack.element());
		assertEquals(3, stack.size());
	}
	
	@Test
	void toString_filledStack_correctOutput () {
		assertEquals("3\n2\n1\n", stack.toString());
	}
}