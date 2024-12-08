package pa11;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

class HashSetTest {
    private HashSet set;

    @BeforeEach
    void setUp() {
        set = new HashSet();
        for (int i = 0; i < 13; i++) {
            set.setList[i] = new LinkedList<>();
        }
    }

    @Test 
    void testEmptySet() {
        assertEquals(0, set.size());
        assertTrue(set.isEmpty());
    }

    @Test
    void testAddAndContains() {
        set.add("hello");
        assertEquals(1, set.size());
        assertTrue(set.contains("hello"));
        assertFalse(set.contains("world"));
    }

    @Test
    void testRemove() {
        set.add("hello");
        set.add("world");
        assertEquals(2, set.size());
        set.remove("hello");
        assertEquals(1, set.size());
        assertFalse(set.contains("hello"));
        assertTrue(set.contains("world"));
    }

    @Test
    void testClear() {
        set.add("hello");
        set.add("world");
        set.clear();
        assertEquals(0, set.size());
        assertTrue(set.isEmpty());
    }

    @Test
    void testToArray() {
        set.add("hello");
        set.add("world");
        String[] array = set.toArray();
        assertEquals(2, array.length);
        assertTrue(contains(array, "hello"));
        assertTrue(contains(array, "world"));
    }

    @Test
    void testIntersection() {
        HashSet set2 = new HashSet();
        for (int i = 0; i < 13; i++) {
            set2.setList[i] = new LinkedList<>();
        }
        
        set.add("hello");
        set.add("world");
        set2.add("world");
        set2.add("java");

        HashSet intersection = set.intersection(set2);
        assertEquals(1, intersection.size());
        assertTrue(intersection.contains("world"));
    }

    @Test
    void testUnion() {
        HashSet set2 = new HashSet();
        for (int i = 0; i < 13; i++) {
            set2.setList[i] = new LinkedList<>();
        }
        
        set.add("hello");
        set2.add("world");

        HashSet union = set.union(set2);
        assertEquals(2, union.size());
        assertTrue(union.contains("hello"));
        assertTrue(union.contains("world"));
    }

    @Test
    void testDifference() {
        HashSet set2 = new HashSet();
        for (int i = 0; i < 13; i++) {
            set2.setList[i] = new LinkedList<>();
        }
        
        set.add("hello");
        set.add("world");
        set2.add("world");

        HashSet difference = set.difference(set2);
        assertEquals(1, difference.size());
        assertTrue(difference.contains("hello"));
    }

    @Test
    void testSubset() {
        HashSet set2 = new HashSet();
        for (int i = 0; i < 13; i++) {
            set2.setList[i] = new LinkedList<>();
        }
        
        set.add("hello");
        set.add("world");
        set2.add("world");

        assertTrue(set2.subset(set));
        assertFalse(set.subset(set2));
    }

    private boolean contains(String[] array, String target) {
        for (String s : array) {
            if (s.equals(target)) return true;
        }
        return false;
    }
}