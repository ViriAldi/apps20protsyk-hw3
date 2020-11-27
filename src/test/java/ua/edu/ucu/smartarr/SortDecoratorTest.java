package ua.edu.ucu.smartarr;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class SortDecoratorTest {
    private SmartArray smartArray;
    private Object[] items;
    private Object[] initItems;

    @Before
    public void initArray() {
        items = new Object[] {3, 1, 2, 4, 3, 4, 5, 0, -1, -2, 1};
        initItems = Arrays.copyOf(items, items.length);
        smartArray = new SortDecorator(
                new BaseArray(items),
                new MyComparator() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        int square1 = (int) o1;
                        square1 *= square1;
                        int square2 = (int) o2;
                        square2 *= square2;
                        if (square1 > square2){
                            return 1;
                        }
                        else if (square1 == square2) {
                            return 0;
                        }
                        else{
                            return -1;
                        }
                    }
                }
        );

    }

    @Test
    public void testOperationDescription() {
        assertEquals(
                "Sorts the array with given comparator",
                smartArray.operationDescription()
        );
    }

    @Test
    public void testToArray() {
        assertArrayEquals(
                new Object[] {
                        0, 1, -1, 1, 2,
                        -2, 3, 3, 4, 4, 5
                },
                smartArray.toArray()
        );
        assertArrayEquals(initItems, items);
    }

    @Test
    public void testSize(){
        assertEquals(
                11,
                smartArray.size()
        );
    }

}
