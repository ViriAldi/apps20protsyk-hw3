package ua.edu.ucu.smartarr;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class FilterDecoratorTest {
    private SmartArray smartArray;
    private Object[] items;
    private Object[] initItems;

    @Before
    public void initArray() {
        items = new Object[] {3, 1, 2, 4, 3, 4, 5, 0, -1, -2, 1};
        initItems = Arrays.copyOf(items, items.length);
        smartArray = new FilterDecorator(
                new BaseArray(items),
                new MyPredicate() {
                    @Override
                    public boolean test(Object t) {
                        return ((int) t) >= 3;
                    }
                }
                );

    }

    @Test
    public void testOperationDescription() {
        assertEquals(
                "Filters array",
                smartArray.operationDescription()
        );
    }

    @Test
    public void testToArray() {
        assertArrayEquals(
                new Object[] {3, 4, 3, 4, 5},
                smartArray.toArray()
        );
        assertArrayEquals(initItems, items);
    }

    @Test
    public void testSize() {
        assertEquals(
                5,
                smartArray.size()
        );
    }

}