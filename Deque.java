public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int length;

    private class Node{
        Item item;
        Node next;
    }
    
    // construct an empty deque
    public Deque(){
        first=null;
        last=null;
        length=0;
    }

    // is the deque empty?
    public boolean isEmpty(){
        return first == null || last == null;
    }

    // return the number of items on the deque
    public int size()

    // add the item to the front
    public void addFirst(Item item){
        if(item==null) throw new IllegalArgumentException(); 
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        length++;
        if(last == null) last = first;
    }

    // add the item to the back
    public void addLast(Item item)
    {
        if(item==null) throw new IllegalArgumentException(); 
        Node oldlast = last,newn= new Node();
        newn.item = item;
        newn.next = null;
        last=newn;
        length++;
        if(first==null) first = last;
        else oldlast.next = last;
    }

    // remove and return the item from the front
    public Item removeFirst()

    // remove and return the item from the back
    public Item removeLast()

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator()

    // unit testing (required)
    public static void main(String[] args)

}

