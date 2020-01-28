package labors.labor06;

/**
 * Eine einfach verkettete Liste.
 */
public class LinkedList {
    private ListNode first;
    private ListNode last;
    private int size;
    
    public LinkedList () {
        first = last = null;
        size = 0;
    }
    
    /**
     * Ermittelt die Anzahl an Elementen in der Liste.
     *
     * @return Anzahl Elemente
     */
    public int size () {
        return size;
    }
    
    /**
     * Liefert den ersten gespeicherrten Datensatz.
     *
     * @return erster Datensatz
     */
    public Object getFirst () {
        return first.getData();
    }
    
    /**
     * Liefert den letzten gespeicherrten Datensatz.
     *
     * @return letzter Datensatz
     */
    public Object getLast () {
        return last.getData();
    }
    
    /**
     * Fügt einen neuen Datensatz ans Ende der Liste hinzu.
     *
     * @param data anzuhängende Daten
     */
    public void add (Object data) {
        ListNode node = new ListNode(data);
        if (size == 0)
            first = last = node;
        else {
            last.setNext(node);
            last = node;
        }
        size++;
    }
    
    /**
     * Fügt einen neuen Datensatz an einer bestimmten Stelle hinzu.
     *
     * @param data einzufügende Daten
     * @param idx  Index, 0-basiert
     */
    public void add (Object data, int idx) {
        if (idx > size || idx < 0)
            throw new IndexOutOfBoundsException("Invalid index: " + idx);
        ListNode node = new ListNode(data);
        if (size == 0)
            first = last = node;
        else if (idx == 0) {
            node.setNext(first);
            first = node;
        }
        else if (idx == size) {
            last.setNext(node);
            last = node;
        }
        else {
            ListNode current = first;
            for (int i = 0; i < idx - 1; i++)
                current = current.getNext();
            node.setNext(current.getNext());
            current.setNext(node);
        }
        size++;
    }
    
    /**
     * Entfernt einen Datensatz.
     *
     * @param idx an diesem Index wird der Datensatz entfernt
     * @return gespeicherter Datensatz
     */
    public Object remove (int idx) {
        if (size == 0 || idx < 0 || idx >= size)
            throw new IndexOutOfBoundsException("Invalid index: " + idx);
        Object del;
        if (size == 1) {
            del = first.getData();
            first = last = null;
        }
        else if (idx == 0) {
            del = first.getData();
            first = first.getNext();
        }
        else if (idx == size - 1) {
            ListNode current = first;
            for (int i = 0; i < size - 2; i++)
                current = current.getNext();
            del = current.getNext().getData();
            last = current;
        }
        else {
            ListNode current = first;
            for (int i = 0; i < idx - 1; i++)
                current = current.getNext();
            del = current.getNext().getData();
            current.setNext(current.getNext().getNext());
        }
        size--;
        return del;
    }
    
    /**
     * Entfernt alle Kopien eines Datensatzes aus der Liste. Jedes Element wird maximal einmal besucht ==> Laufzeit O(n).
     *
     * @param data zu entfernender Datensatz
     */
    public void removeAll (Object data) {
        if (size == 1)
            first = last = null;
        if (size > 2) {
            ListNode current = first;
            while (data.equals(current.getData())) {
                if (current.getNext() == last) {
                    first = last;
                    size = 1;
                    break;
                }
                else {
                    current = current.getNext();
                    first = current;
                    size--;
                }
            }
            while (current != last && current.getNext() != last) {
                if (data.equals(current.getNext().getData())) {
                    current.setNext(current.getNext().getNext());
                    size--;
                }
                current = current.getNext();
            }
            if (data.equals(last.getData())) {
                last = current;
                last.setNext(null);
                size--;
            }
        }
    }
    
    @Override
    public String toString () {
        if (size == 0)
            return "{ }";
        StringBuilder builder = new StringBuilder("{").append(first.getData());
        ListNode current = first.getNext();
        for (int i = 1; i < size; i++) {
            builder.append(", ").append(current.getData());
            current = current.getNext();
        }
        return builder.append("}").toString();
    }
    
    /**
     * Liefert einen gespeicherten Datensatz.
     *
     * @param idx von diesem Index wird der Datensatz geliefert
     * @return gespeicherter Datensatz am Index {@code idx}
     */
    public Object get (int idx) {
        if (idx < 0 || idx >= size)
            throw new IndexOutOfBoundsException();
        ListNode current = first;
        for (int i = 0; i < idx; i++)
            current = current.getNext();
        return current.getData();
    }
}

class ListNode {
    
    private final Object data;
    private ListNode next;
    
    /**
     * Erstellt einen neuen Knoten.
     *
     * @param data zu speichernde Daten
     */
    public ListNode (Object data) {
        this.data = data;
    }
    
    /**
     * Liefert den Nachfolger dieses Knotens.
     *
     * @return den Nachfolgerknoten
     */
    public Object getData () {
        return data;
    }
    
    public ListNode getNext () {
        return next;
    }
    
    public void setNext (ListNode next) {
        this.next = next;
    }
}