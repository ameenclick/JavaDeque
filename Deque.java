import java.util.Iterator;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.io.File;
import java.io.FileNotFoundException; 

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
    public int size(){
        return length;
    }

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
    {
        if(isEmpty())  throw new NoSuchElementException();
        Item item = first.item;
        first = first.next;
        length--;
        if(isEmpty()) last = first;
        return item;
    }

    // remove and return the item from the back
    public Item removeLast()
    {
        if(isEmpty())  throw new NoSuchElementException();
        Item item = last.item;
        if(first.next==null){
            last=null;
            first=null;
        }  
        else
        {
            Node temp= first;
            while(temp.next!=last)
            {
                temp=temp.next;
            }   
            last=temp;
            last.next=null;
        }
        length--;
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator()
    {
        return new dQueueIterator();
    }

    private class dQueueIterator implements Iterator<Item>
    {
        private Node current = first;
        public boolean hasNext(){
            return current != null;
        }
        public void remove()
        {/*Unsupported Operation Exception*/
                throw new UnsupportedOperationException();
        }
        public Item next()
        {
            if (!hasNext()) throw new NoSuchElementException();
            Item fitem = current.item;
            current = current.next;
            return fitem;
        }
    }

    // unit testing (required)
    public static void main(String[] args)
    {
        try{
            File file = new File("C:\\GitFolder\\ADS\\M2\\QUEUES\\test1.txt");
        Scanner sc= new Scanner(file);
        Deque<String> dq= new Deque<>();
        boolean toggle=true;
        while(sc.hasNextLine())
        {
            if(toggle)
            {
                dq.addFirst(sc.nextLine());
                toggle = !toggle;
            }
            else{
                dq.addLast(sc.nextLine());
                toggle = !toggle;
            }
        }
        Iterator<String> Ival= dq.iterator();
        System.out.println("Added Alternative first and last");
        while(Ival.hasNext())
        {
            System.out.print(Ival.next()+" ");
        }
        dq.removeLast();
        dq.removeFirst();
        assert !dq.isEmpty() : "Empty queue detected";
        Ival= dq.iterator();
        System.out.println("\nAfter removing 1 from last and first");
        while(Ival.hasNext())
        {
            System.out.print(Ival.next()+" ");
        }
        sc.close();
        }catch(FileNotFoundException e){
           System.out.println("An error occured while reading file.");
           e.printStackTrace();
       }
    }
}

