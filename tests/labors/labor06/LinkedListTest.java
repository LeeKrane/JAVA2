package labors.labor06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    LinkedList list;

    /**
     * Vergleicht zwei LinkedList Objekte auf Gleichheit.
     *
     * @param l1 erste LinkedList
     * @param l2 zweite LinkedList
     * @return true wenn komplett gleich, sonst false
     */
    private static boolean areEqual(LinkedList l1, LinkedList l2) {
        if (l1 == null && l2 == null) {
            return true;
        }
        if (l1 == null || l2 == null) {
            return false;
        }
        if (l1.size() != l2.size()) {
            return false;
        }
        for (int i = 0; i < l1.size(); i++) {
            boolean equal = Objects.equals(l1.get(i), l2.get(i));
            if (!equal) {
                return false;
            }
        }
        return true;
    }

    @BeforeEach
    public void setUp() {
        list = new LinkedList();
    }

    @Test
    public void add_element_elementAdded() {
        int val = 3;
        list.add(val);
        assertEquals(val, list.get(0));
    }

    @Test
    public void add_elementNull_elementAdded() {
        list.add(null);
        assertNull(list.get(0));
    }

    @Test
    public void add_indexNegative_exception() {
        int idx = -1;
        String errorMsg = assertThrows(IndexOutOfBoundsException.class, () -> list.add("data", idx)).getMessage();
        assertTrue(errorMsg.contains(Integer.toString(idx)));
    }

    @Test
    public void add_indexTooBig_exception() {
        int idx = 1;
        String errorMsg = assertThrows(IndexOutOfBoundsException.class, () -> list.add("data", idx)).getMessage();
        assertTrue(errorMsg.contains(Integer.toString(idx)));
    }

    @Test
    public void add_elementAtEnd_elementAppended() {
        String data = "data";
        list.add(data, 0);
        assertEquals(data, list.get(0));
    }

    @Test
    public void add_elementAtIndex_elementInserted() {
        for (int i = 0; i < 5; i++) {
            list.add(i * i);
        }
        int data = 42;
        int idx = 3;
        list.add(data, idx);
        assertEquals(data, list.get(idx));
        assertEquals(9, list.get(idx + 1));
    }

    @Test
    public void size_noElements_0() {
        assertEquals(0, list.size());
    }

    @Test
    public void size_threeElements_3() {
        list.add(0);
        list.add(0);
        list.add(0);
        assertEquals(3, list.size());
    }

    @Test
    public void remove_indexNegative_exception() {
        int idx = -1;
        String errorMsg = assertThrows(IndexOutOfBoundsException.class, () -> list.remove(idx)).getMessage();
        assertTrue(errorMsg.contains(Integer.toString(idx)));
    }

    @Test
    public void remove_indexTooBig_exception() {
        int idx = 0;
        String errorMsg = assertThrows(IndexOutOfBoundsException.class, () -> list.remove(idx)).getMessage();
        assertTrue(errorMsg.contains(Integer.toString(idx)));
    }

    @Test
    public void remove_single_ElementList_listEmpty() {
        list.add(42);
        list.remove(0);
        assertEquals(0, list.size());
        assertThrows(NullPointerException.class, () -> list.getFirst());
        assertThrows(NullPointerException.class, () -> list.getLast());
    }

    @Test
    public void remove_index0_firstRemovedNewFirstSet() {
        String first = "first";
        list.add(first);
        String second = "second";
        list.add(second);
        list.add("last");
        Object objectAt0 = list.remove(0);
        assertEquals(first, objectAt0);
        assertEquals(2, list.size());
        assertEquals(second, list.getFirst());
    }

    @Test
    public void remove_indexLast_lastRemovedNewLastSet() {
        list.add("first");
        String second = "second";
        list.add(second);
        String last = "last";
        list.add(last);
        Object objectAt2 = list.remove(2);
        assertEquals(last, objectAt2);
        assertEquals(2, list.size());
        assertEquals(second, list.getLast());
    }

    @Test
    public void remove_indexMiddle_removed() {
        LinkedList expected = new LinkedList();
        int idxToRemove = 2;
        for (int i = 0; i < 5; i++) {
            list.add(i * i);
            if (i != idxToRemove)
                expected.add(i * i);
        }
        assertEquals(4, list.remove(idxToRemove));
        assertTrue(areEqual(list, expected));
    }

    @Test
    public void toString_listNotEmpty_resultAsSpecified() {
        list.add(0);
        list.add(1);
        list.add(2);
        assertEquals("{0, 1, 2}", list.toString());
    }

    @Test
    public void toString_emptyList_emptyBracketsresultAsSpecified() {
        assertEquals("{ }", list.toString());
    }

    @Test
    public void removeAll_emptyList_noChange() {
        list.removeAll("emptyList");
        assertTrue(areEqual(new LinkedList(), list));
    }

    @Test
    public void removeAll_targetPresentAtStartMiddleEnd_rest() {
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(2);
        list.add(0);
        LinkedList expected = new LinkedList();
        expected.add(1);
        expected.add(2);
        list.removeAll(0);
        assertTrue(areEqual(expected, list));
    }

    @Test
    public void removeAll_listContainsOnlyTarget_emptyList() {
        list.add(0);
        list.add(0);
        list.add(0);
        list.removeAll(0);
        assertEquals(0, list.size());
    }

    @Test
    public void removeAll_targetNotPresent_listUnchanged() {
        list.add(0);
        list.add(1);
        list.removeAll(42);
        LinkedList expected = new LinkedList();
        expected.add(0);
        expected.add(1);
        assertTrue(areEqual(expected, list));
    }

    @Test
    public void get_indexTooLarge_exception() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    public void get_indexNegative_exception() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }
}