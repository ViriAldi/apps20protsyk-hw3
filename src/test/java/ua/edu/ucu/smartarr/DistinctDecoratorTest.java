package ua.edu.ucu.smartarr;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DistinctDecoratorTest {
    private SmartArray smartArray;
    private Object[] items;
    private Object[] initItems;

    @Before
    public void initArray() {
        items = new Object[] {3, 1, 2, 4, 3, 4, 5, 0, -1, -2, 1};
        initItems = Arrays.copyOf(items, items.length);
        smartArray = new DistinctDecorator(new BaseArray(items));

    }

    @Test
    public void testOperationDescription() {
        assertEquals(
                "Makes a set of all items",
                smartArray.operationDescription()
        );
    }

    @Test
    public void testToArray() {
        assertArrayEquals(
                new Object[] {3, 1, 2, 4, 5, 0, -1, -2},
                smartArray.toArray()
        );
        assertArrayEquals(initItems, items);
    }

    @Test
    public void testSize() {
        assertEquals(
                8,
                smartArray.size()
        );
    }

}