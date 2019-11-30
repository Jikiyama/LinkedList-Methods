import java.util.ListIterator;
import java.util.NoSuchElementException;
/**
 * A linked list is a sequence of nodes with efficient
 * element insertion and removal. This class contains a subset of the methods of
 * the standard java.util.LinkedList class.
 */


/**
 *
 * @author Jikiy
 */
public class LinkedList {

    private Node first;
    
    public LinkedList()
    {
        first = null;
    }
    // Assignment method begins here//
    public boolean contains(Object obj){
        boolean found = false;
        if (first == null) { throw new NoSuchElementException();}

        Node currentNode = first;
        int i = 1;
        while (currentNode != null) { 
        /*Traverse the nodes until a node is found containing the object.*/
            if (currentNode.data.equals(obj)) {
                found = true;
                break;
            } else {
                if (currentNode.next != null)
                    currentNode = currentNode.next;
                else
                    currentNode = null;
            }
        }
        return found;
    }
    // Assignment method ends here
    public Object getFirst(){
        if (first == null) { throw new NoSuchElementException();}
        return first.data;
    }
    
    public Object removeFirst()
    {
        if(first == null) { throw new NoSuchElementException(); }
        Object element = first.data;
        first = first.next;
        return element;
    }
    public void addFirst(Object element)
    {
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = first;
        first = newNode;
    }
    public ListIterator listIterator(){
        return new LinkedListIterator();
    }
    class Node
    {
        public Object data;
        public Node next;
    }
    class LinkedListIterator implements ListIterator
    {
        private Node position;
        private Node previous;
        private boolean isAfterNext;
        
        public LinkedListIterator()
        {
            position = null;
            previous = null;
            isAfterNext = false;
        }
        
        public Object next()
        {
            if(!hasNext()){throw new NoSuchElementException();}
            previous = position;
            isAfterNext = true;
            if (position == null)
            {
                position = first;
            }
            else
            {
                position = position.next;
            }
            return position.data;
        }
        
        public boolean hasNext()
        {
            if (position == null)
            {
                return first != null;
            }
            else
            {
                return position.next != null;
            }
        }
        
        public void add(Object element)
        {
            if (position == null)
            {
                addFirst(element);
                position = first;
            }
            else
            {
                Node newNode = new Node();
                newNode.data = element;
                newNode.next = position.next;
                position.next = newNode;
                position = newNode;
            }
            isAfterNext = false;
        }
        public void remove()
        {
            if (!isAfterNext) {throw new IllegalStateException();}
            if (position == first)
            {
                removeFirst();
            }
            else
            {
                previous.next = position.next;
            }
            position = previous;
            isAfterNext = false;
        }
        
        public void set(Object element){
            if(!isAfterNext) {throw new IllegalStateException();}
            position.data = element;
        }

        @Override
        public boolean hasPrevious() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Object previous() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }
}
