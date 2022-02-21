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

    // public boolean isEmpty()

    public int size()
    {
        return n;
    }

    // public void addFirst(Item item)

    // public void addLast(Item item)

    // public Item removeFirst()

    // public Item removeLast()

    public static void main(String[] args)
    {
        try{
            File file = new File("C:\\GitFolder\\ADS\\M2\\QUEUES\\test1.txt");
        Scanner sc= new Scanner(file);
        Deque<String> dq= new Deque<>();

        }catch(FileNotFoundException e){
            System.out.println("An error occured while reading file.");
            e.printStackTrace();
        }
    }
}
