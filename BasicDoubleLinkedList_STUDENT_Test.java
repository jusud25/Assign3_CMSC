import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BasicDoubleLinkedList_STUDENT_Test {

    BasicDoubleLinkedList<String> stringchecks;
    BasicDoubleLinkedList<Double> doubleChecks;
   StringCheck forString;
    DoubleCheck forDouble;

    @Before
    public void setUp() throws Exception {
        stringchecks = new BasicDoubleLinkedList<String>();
       stringchecks.addToEnd("Hello");
       forString = new StringCheck();

        
        doubleChecks = new BasicDoubleLinkedList<Double>();
        doubleChecks.addToEnd(15.0);
        doubleChecks.addToEnd(100.0);
         forDouble = new DoubleCheck();

    }

    @After
    public void tearDown() throws Exception {
        stringchecks = null;
        forString = null;
    }
   /*
    * @param to get the size of the list
    */
    @Test
    public void testGetSize() {
        assertEquals(1, stringchecks.getSize());
        assertEquals(1, doubleChecks.getSize());
    }
   /*
    * @param add to end
    */
    @Test
    public void testAddToEnd() {
       
        doubleChecks.addToEnd(20.0);
        assertEquals(20, doubleChecks.getLast().intValue());

    }
     /**
      * @return add to the front of the list
      */
    @Test
    public void addToFrontTest() {
        stringchecks.addToFront("start");
        assertEquals("start", stringchecks.getFirst());
    	 
    }
    @Test
    public void testGetFirst() {
         stringchecks.addToFront("Jusu");
         assertEquals("Jusu", stringchecks.getFirst());
    
    }

    @Test
    public void toArrayListTest() {
        ArrayList<String> list;
        stringchecks.addToFront("orange");
        stringchecks.addToFront("Maize");
        stringchecks.addToEnd("End");
        list = stringchecks.toArrayList();
        assertEquals("orange", list.get(1));
        assertEquals("Maize", list.get(0));
        assertEquals("Hello", list.get(2));
        assertEquals("End", list.get(3));
 
    }

    @Test
    public void testToArray() {
    
        doubleChecks.addToEnd(20.0);
        doubleChecks.addToEnd(0.0);
        ArrayList<Double> list = doubleChecks.toArrayList();
        assertEquals(15, list.get(0).intValue());
        assertEquals(100, list.get(1).intValue());
        assertEquals(20, list.get(2).intValue());
        assertEquals(0, list.get(3).intValue());
    }
    @Test
    public void testIteratorSuccessfulPrevious() {
        stringchecks.addToFront("start");
        stringchecks.addToEnd("ends");
        ListIterator<String> iterator = stringchecks.iterator();
        assertEquals(true, iterator.hasNext());
        assertEquals("start", iterator.next());
        assertEquals("Hello", iterator.next());
        assertEquals("ends", iterator.next());
        assertEquals(true, iterator.hasPrevious());
        assertEquals("ends", iterator.previous());
        assertEquals("Hello", iterator.previous());
    }

    @Test
    public void iteratorSuccessfulTest() {
       
        doubleChecks.addToEnd(75.0);

        ListIterator<Double> iterator = doubleChecks.iterator();

        assertEquals(true, iterator.hasNext());
        assertEquals(15, iterator.next().intValue());
        assertEquals(100, iterator.next().intValue());
        assertEquals(75, iterator.next().intValue());
        assertEquals(true, iterator.hasPrevious());
        assertEquals(75, iterator.previous().intValue());
        assertEquals(100, iterator.previous().intValue());
        assertEquals(15, iterator.previous().intValue());
    }
    
    @Test
    public void removeTest() {
        doubleChecks.addToEnd(25.0);
        doubleChecks.addToEnd(60.0);

        assertEquals(15, doubleChecks.getFirst().intValue());
       doubleChecks.remove(15.0, forDouble);
        assertEquals(15, doubleChecks.getFirst().intValue());
        
        doubleChecks.remove(60.0, forDouble);
        assertEquals(25, doubleChecks.getLast().intValue());
        

       
    }

    @Test
    public void retrieveFirstElementTest() {
        stringchecks.addToFront("New");
        assertEquals("New", stringchecks.retrieveFirstElement());
    }
    @Test
    public void testRetrieveLastElement() {
        doubleChecks.addToEnd(20.0);
        doubleChecks.addToEnd(1.56);
        assertEquals(1, doubleChecks.retrieveLastElement().intValue());
       
    }

   private class StringCheck implements Comparator<String> {
        @Override
        public int compare(String arg2, String arg3) {
            // TODO Auto-generated method stub
            return arg2.compareTo(arg3);
        }

    }

    private class DoubleCheck implements Comparator<Double> {

        @Override
        public int compare(Double str, Double arg1) {
            // TODO Auto-generated method stub
            return str.compareTo(arg1);
        }

    }
}