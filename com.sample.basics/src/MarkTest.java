import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

public class MarkTest {

    Mark mark = new Mark();

    @Test
    public void test_MarkObject_ReturnsNotNull() {
        assertNotNull(mark);
    }

    @Test
    public void test_LengthMethod_ReturnsInteger() {
        assertTrue(Integer.class.isInstance(mark.lengthMethod()));
    }

    @Test
    public void test_LengthMethod() {
        assertEquals(4, mark.lengthMethod());
    }

    @Test
    public void test_SortMethod() {
        int expected[] = { 35, 40, 70, 89 };
        assertArrayEquals(expected, mark.SortMethod());
    }

    @Test(expected = ArithmeticException.class)
    public void test_ExceptionMethod() {
        assertEquals(3, 3 / 0);
    }

    @Test
    public void test_LinkedListMethod() {
        assertEquals(List.of(30,45, 51, 92), mark.linkedListMethod());
    }

    @Test
    public void test_ArrayListMethod() {
        assertEquals(List.of(30,45, 51, 92), mark.arrayListMethod());
    }

    @Test
    public void test_HashSetMethod() {
        assertEquals(Set.of(50,92,30,81), mark.hashSetMethod());
    }

    @Test
    public void test_LinkedHashSetMethod() {
        assertEquals(Set.of(50,92,30,81), mark.linkedHashSetMethod());
    }

    @Test
    public void test_TreeSetMethod() {
    assertEquals(Set.of(30,50,81,92), mark.treeSetMethod());
    }

    @Test
    public void test_HashMapMethod() {
        assertEquals(Map.of(1,39,2,59,5,80), mark.hashMapMethod());
    }

    @Test
    public void test_LinkedHashMapMethod() {
        assertEquals(Map.of(5,72,1,39,2,59), mark.linkedHashMapMethod());
    }

    @Test
    public void test_TreeMapMethod() {
        Map <Integer,Integer> treeMap=new TreeMap<Integer,Integer>();
        treeMap.put(1, 39);
        treeMap.put(2, 59);
        assertEquals(treeMap, mark.treeMapMethod());
    }

    @Test
    public void test_PriorityQueueMethod() {
        List <Integer> actuaList=new LinkedList<Integer>(mark.priorityQueueMethod());
        //actuaList.addAll(mark.priorityQueueMethod());
        assertEquals(List.of(52,73,98),actuaList);
        assertEquals(List.of(52,73,98),List.of(mark.priorityQueueMethod()));
    }
    @Test
    public void test_ArrayDequeMethod() {
        List <Integer> queueList=new LinkedList<Integer>(mark.arrayDequeMethod());
        assertEquals(List.of(32,73), queueList);
    }
}
