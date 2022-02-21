import java.util.Iterator;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.io.File;
import java.io.FileNotFoundException; 

public class DequeArray implements Iterable<Item>  {
    private static final int INIT_CAPACITY = 8;

    private Item[] q;       // queue elements
    private int n;          // number of elements on queue
    private int first;      // index of first element of queue
    private int last;       // index of next available slot

    public DequeArray()
    {
        q = (Item[]) new Object[INIT_CAPACITY];
        n = 0;
        first = 0;
        last = 0;
    }

    public boolean isEmpty()
    {
        return n==0;
    }

    public int size()
    {
        return n;
    }

    // resize the underlying array
    private void resize(int capacity) {
        assert capacity >= n;
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            copy[i] = q[(first + i) % q.length];
        }
        q = copy;
        first = 0;
        last  = n;
    }

    // public void addFirst(Item item)
    public void addLast(Item item)
    {
        if (n == q.length) resize(2*q.length);   // double size of array if necessary
        q[last++] = item;                        // add item
        if (last == q.length) last = 0;          // wrap-around
        n++;
    }

    //public Item removeFirst()
    

    // public Item removeLast()

    public Iterator<Item> iterator() {
        return new DequeArray();
    }

    public static void main(String[] args)
    {
        try{
            File file = new File("C:\\GitFolder\\ADS\\M2\\QUEUES\\test1.txt");
        Scanner sc= new Scanner(file);
        Deque<String> dq= new Deque<String>();

        }catch(FileNotFoundException e){
            System.out.println("An error occured while reading file.");
            e.printStackTrace();
        }
    }
}
