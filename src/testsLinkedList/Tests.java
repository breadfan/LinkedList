package testsLinkedList;

import static org.junit.Assert.*;

import org.junit.Test;
import prod.*;

import java.util.Random;


public class Tests extends prod.LinkedList {

    public static final int SEED = 1;
    public static final int ARRAY_SIZE = 10000;


    int[] generateRandomIntArray(int size, long seed) {
        int[] arr = new int[size];
        Random rnd = new Random(seed);
        for (int i = 0; i < size; ++i) {
            arr[i] = rnd.nextInt();
        }
        return arr;
    }


    @Test
    public void testPopBack() throws Exception {
        int [] arr = generateRandomIntArray(ARRAY_SIZE, SEED);

        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i : arr) {
            linkedList.addfront(i);
        }

        assertTrue("Smth goes wrong here: ", linkedList.popFront() == arr[0]);
    }


    @Test
    public void testPopFront() throws Exception {
        int [] arr = generateRandomIntArray(ARRAY_SIZE, SEED);

        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i : arr) {
            linkedList.addfront(i);
        }

        assertTrue("Smth goes wrong here: ", linkedList.popFront() == arr[0]);
    }


    @Test
    public void testPopFrontFromEmpty() throws Exception{
        LinkedList<Integer> linkedList = new LinkedList<>();
        assertTrue("LL is empty: ", linkedList.popFront() != null);
    }

    @Test
    public void testPopBackFromEmpty() throws Exception{
       LinkedList<Integer> linkedList = new LinkedList<>();
        assertTrue("LL is empty: ", linkedList.popBack() != null);
    }


    @Test
    public void testAddFront() throws Exception {
        int[] arr = generateRandomIntArray(ARRAY_SIZE, SEED);

        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i : arr) {
            linkedList.addfront(i);
        }
        LinkedList<Integer> n = linkedList;
        for (int i : arr) {
            assertTrue("hey, el " + n.head.info + " is in wrong order", arr[i] == n.head.info);
            n.head = n.head.next;
        }
    }

    @Test
    public void testAppEnd() throws Exception {
        int[] arr = generateRandomIntArray(ARRAY_SIZE, SEED);

        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i : arr) {
            linkedList.append(i);
        }
        LinkedList<Integer> n = linkedList;
        for (int i : arr) {
            assertTrue("hey, el " + n.head.info + " is in wrong order", arr[i] == n.head.info);
            n.head = n.head.next;
        }
    }


}
