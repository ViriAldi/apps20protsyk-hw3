package ua.edu.ucu.smartarr;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BaseArrayTest {
    private BaseArray baseArray;
    private Object[] items;

    @Before
    public void initArray() {
        items = new Object[] {1, 2, 3, 4, 5, 0, -1, -2};
        baseArray = new BaseArray(items);
    }

    @Test
    public void testOperationDescription() {
        assertEquals(
                "No operation",
                baseArray.operationDescription()
        );
    }

    @Test
    public void testToArray() {
        assertArrayEquals(
                items,
                baseArray.toArray()
        );
    }

    @Test
    public void testSize() {
        assertEquals(
                items.length,
                baseArray.size()
        );
    }

}
