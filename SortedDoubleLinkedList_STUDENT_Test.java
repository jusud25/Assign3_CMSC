import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SortedDoubleLinkedList_STUDENT_Test {

    GregorianMonthComparator comparators;
    GregorianCalendar s1, s2, s3, s4, s5;
    SortedDoubleLinkedList<GregorianCalendar> sortedLinked;

    @Before
    public void setUp() throws Exception {
        s1 = new GregorianCalendar(2022, 1, 1); 
        s2 = new GregorianCalendar(2022, 3, 15); 
        s3 = new GregorianCalendar(2022, 5, 6);
        s4 = new GregorianCalendar(2022, 7, 13); 
        s5 = new GregorianCalendar(2022, 8, 23); 
        comparators = new GregorianMonthComparator();
        sortedLinked = new SortedDoubleLinkedList<GregorianCalendar>(comparators);
    }
   
    @After
    public void tearDown() throws Exception {
        comparators = null;
        sortedLinked = null;
    }
    
    @Test
    public void addToEndTest() {
        try {
            sortedLinked.addToEnd(s1);
            assertTrue("Did not throw an UnsupportedOperationException", false);
        } catch (UnsupportedOperationException e) {
            assertTrue("successfully threw an UnsupportedOperationException",true);
        } catch (Exception e) {
       assertTrue("Will throw an exception other than UnsupportedOperationException", false);
        }
    }
 
    @Test
    public void testAddToFront() {
       try {
            sortedLinked.addToFront​(s2);
            assertTrue("Did not throw an UnsupportedOperationException", false);
        } catch (UnsupportedOperationException e) {
            assertTrue("Successfully threw an UnsupportedOperationException",true);
       } catch (Exception e) {
          assertTrue("Will throw an exception other than UnsupportedOperationException", false);
        }
   }
   
    @Test
    public void iteratorSuccessfulNext() {
        sortedLinked.add(s2);
        sortedLinked.add(s3);
        sortedLinked.add(s1);
        sortedLinked.add(s4);
        ListIterator<GregorianCalendar> iterator = sortedLinked.iterator();
        assertEquals(true, iterator.hasNext());
        assertEquals(s1, iterator.next());
        assertEquals(s2, iterator.next());
        assertEquals(s3, iterator.next());
        assertEquals(true, iterator.hasNext());
    }
    
    @Test
    public void iteratorNoSuchElementExceptionNext() {
        sortedLinked.add(s2);
        sortedLinked.add(s3);
        sortedLinked.add(s1);
        sortedLinked.add(s4);
        ListIterator<GregorianCalendar> iterator = sortedLinked.iterator();
        assertEquals(true, iterator.hasNext());
        assertEquals(s1, iterator.next());
        assertEquals(s2, iterator.next());
        assertEquals(s3, iterator.next());
        assertEquals(true, iterator.hasNext());
        assertEquals(s4, iterator.next());
        try {
           
            iterator.next();
            assertTrue("Did not throw a NoSuchElementException", false);
        } catch (NoSuchElementException e) {
            assertTrue("Successfully threw a NoSuchElementException", true);
        } catch (Exception e) {
            assertTrue("Threw an exception other than the NoSuchElementException", false);
        }
    }
    
    @Test
    public void iteratorNoSuchElementExceptionTest() {
        sortedLinked.add(s2);
        sortedLinked.add(s3);
        sortedLinked.add(s1);
        sortedLinked.add(s4);
        ListIterator<GregorianCalendar> iterator = sortedLinked.iterator();
        assertEquals(true, iterator.hasNext());
        assertEquals(s1, iterator.next());
        assertEquals(s2, iterator.next());
        assertEquals(true, iterator.hasPrevious());
        assertEquals(s2, iterator.previous());
        assertEquals(s1, iterator.previous());
        
        try {
            //there is not element in the list
            iterator.previous();
            assertTrue("Did not throw a NoSuchElementException", false);
        } catch (NoSuchElementException e) {
            assertTrue("Successfully threw a NoSuchElementException", true);
        } catch (Exception e) {
            assertTrue("Will throw an exception other than NoSuchElementException", false);
        }
    }
   
    @Test
    public void iteratorUnsupportedOperationExceptionStringTest() {
        sortedLinked.add(s2);
        sortedLinked.add(s3);
        sortedLinked.add(s1);
        sortedLinked.add(s4);
        ListIterator<GregorianCalendar> iterator = sortedLinked.iterator();
        try {
            //remove is not supported for the iterator
            iterator.remove();
            assertTrue("Did not throw a UnsupportedOperationException", false);
        } catch (UnsupportedOperationException e) {
            assertTrue("Successfully threw a UnsupportedOperationException", true);
        } catch (Exception e) {
            assertTrue("Threw an exception other than the UnsupportedOperationException", false);
        }
    }
    /**
     * @return To remove an item from the list
     */
    @Test
    public void addTest() {
        sortedLinked.add(s2);
        sortedLinked.add(s5);
        sortedLinked.add(s1);
        assertEquals(s1, sortedLinked.getFirst());
        assertEquals(s5, sortedLinked.getLast());
        sortedLinked.add(s3);
        sortedLinked.add(s4);
        assertEquals(s1, sortedLinked.getFirst());
        assertEquals(s5, sortedLinked.getLast());
       
        assertEquals(s5, sortedLinked.retrieveLastElement());
        assertEquals(s4, sortedLinked.getLast());
    }
    /**
     * @return will remove the first element from the list
     */
    @Test
    public void removeFirstTest() {
        sortedLinked.add(s2);
        sortedLinked.add(s4);
        assertEquals(s2, sortedLinked.getFirst());
        assertEquals(s4, sortedLinked.getLast());
        sortedLinked.add(s1);
        assertEquals(s1, sortedLinked.getFirst());
        // remove the first
        sortedLinked.remove(s1, comparators);
        assertEquals(s1, sortedLinked.getFirst());
    }
   /**
    * @param To insert element in correct position
    * To compare element for deletion 
    * and remove from the end of the list
    */
    @Test
    public void removeTest() {
        sortedLinked.add(s2);
        sortedLinked.add(s4);
        sortedLinked.add(s1);
        assertEquals(s1, sortedLinked.getFirst());
        assertEquals(s4, sortedLinked.getLast());
        sortedLinked.remove(s4, comparators);
        assertEquals(s2, sortedLinked.getLast());
    }
    @Test
    public void removeCenterTest() {
        sortedLinked.add(s2);
        sortedLinked.add(s4);
        sortedLinked.add(s1);
        assertEquals(s1, sortedLinked.getFirst());
        assertEquals(s4, sortedLinked.getLast());
        assertEquals(3, sortedLinked.getSize());
        sortedLinked.remove(s1, comparators);
        assertEquals(s1, sortedLinked.getFirst());
        assertEquals(s4, sortedLinked.getLast());
        assertEquals(3, sortedLinked.getSize());
    }

    private class GregorianMonthComparator implements Comparator<GregorianCalendar> {

        @Override
        public int compare(GregorianCalendar month1, GregorianCalendar month2) {
            // TODO Auto-generated method stub
            return month1.compareTo(month2);
        }

    }
}