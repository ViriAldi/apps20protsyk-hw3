package ua.edu.ucu.smartarr;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.functions.MyFunction;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class MapDecoratorTest {
    private SmartArray smartArray;
    private Object[] items;
    private Object[] initItems;

    @Before
    public void initArray() {
        items = new Object[] {3, 1, 2, 4, 3, 4, 5, 0, -1, -2, 1};
        initItems = Arrays.copyOf(items, items.length);
        smartArray = new MapDecorator(
                new BaseArray(items),
                new MyFunction() {
                    @Override
                    public Object apply(Object t) {
                        return ((int) t) + 1;
                    }
                }
        );

    }

    @Test
    public void testOperationDescription() {
        assertEquals(
                "Applies given function to all elements",
                smartArray.operationDescription()
        );
    }

    @Test
    public void testToArray() {
        assertArrayEquals(
                new Object[] {
                        4, 2, 3, 5, 4,
                        5, 6, 1, 0, -1, 2
                },
                smartArray.toArray()
        );
        assertArrayEquals(initItems, items);
    }

    @Test
    public void testSize() {
        assertEquals(
                11,
                smartArray.size()
        );
    }

}
