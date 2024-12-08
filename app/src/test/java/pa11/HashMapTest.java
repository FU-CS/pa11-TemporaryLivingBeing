package pa11;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

class HashMapTest {
    private HashMap map;

    @BeforeEach
    void setUp() {
        map = new HashMap();
        for (int i = 0; i < 13; i++) {
            map.setList[i] = new LinkedList<>();
        }
    }

    @Test
    void testEmptyMap() {
        assertEquals(0, map.size());
        assertTrue(map.isEmpty());
    }

    @Test
    void testPutAndGet() {
        assertNull(map.put("key1", "value1"));
        assertEquals("value1", map.get("key1"));
    }

    @Test
    void testPutOverwrite() {
        map.put("key1", "value1");
        assertEquals("value1", map.put("key1", "value2"));
        assertEquals("value2", map.get("key1"));
    }

    @Test
    void testRemove() {
        map.put("key1", "value1");
        assertEquals("value1", map.remove("key1"));
        assertNull(map.get("key1"));
    }

    @Test
    void testKeySetAndValues() {
        map.put("key1", "value1");
        map.put("key2", "value2");
        
        String[] keys = map.keySet();
        String[] values = map.values();
        
        assertEquals(2, keys.length);
        assertEquals(2, values.length);
        assertTrue(containsValue(keys, "key1"));
        assertTrue(containsValue(keys, "key2"));
        assertTrue(containsValue(values, "value1"));
        assertTrue(containsValue(values, "value2"));
    }

    private boolean containsValue(String[] array, String target) {
        for (String s : array) {
            if (s.equals(target)) return true;
        }
        return false;
    }
}