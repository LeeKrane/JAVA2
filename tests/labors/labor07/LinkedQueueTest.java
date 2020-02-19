package labors.labor07;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author LeeKrane
 */

class LinkedQueueTest {
	LinkedQueue queue;
	
	@BeforeEach
	void createLinkedQueueObject () {
		queue = new LinkedQueue();
		for (int i = 1; i < 4; i++)
			queue.add(i);
	}
	
	@Test
	void add_filledQueue_addCorrectObjects () {
		queue.add(4);
		assertEquals(4, queue.size());
		assertEquals(1, queue.element());
		queue.add(5);
		assertEquals(5, queue.size());
		assertEquals(1, queue.element());
	}
	
	@Test
	void get_filledQueue_getCorrectObjectsAndDeleteOutOfQueue () {
		assertEquals(1, queue.get());
		assertEquals(2, queue.get());
		assertEquals(3, queue.get());
	}
	
	@Test
	void get_emptyQueue_noExceptionThrown () {
		assertDoesNotThrow(new LinkedQueue()::get);
	}
	
	@Test
	void get_emptyQueue_correctSizeHandling () {
		LinkedQueue emptyQueue = new LinkedQueue();
		emptyQueue.get();
		assertEquals(0, emptyQueue.size());
	}
	
	@Test
	void isEmpty_filledQueue_correctDeterminationOfEmptiness () {
		assertFalse(queue.isEmpty());
		queue.get();
		queue.get();
		queue.get();
		assertTrue(queue.isEmpty());
	}
	
	@Test
	void size_filledQueue_correctDeterminationOfSize () {
		assertEquals(3, queue.size());
		queue.get();
		assertEquals(2, queue.size());
		queue.add(3);
		queue.add(4);
		assertEquals(4, queue.size());
	}
	
	@Test
	void element_filledQueue_getElementWithoutRemovingTop () {
		assertEquals(3, queue.size());
		assertEquals(1, queue.element());
		assertEquals(3, queue.size());
	}
}