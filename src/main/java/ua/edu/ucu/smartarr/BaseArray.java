package ua.edu.ucu.smartarr;

import java.util.Arrays;

public class BaseArray implements SmartArray {
    private Object[] items;

    public BaseArray(Object[] initItems) {
        items = Arrays.copyOf(initItems, initItems.length);
    }

    public Object[] toArray() {
        return Arrays.copyOf(items, items.length);
    }

    public String operationDescription() {
        return "No operation";
    }

    public int size() {
        return items.length;
    }

}
