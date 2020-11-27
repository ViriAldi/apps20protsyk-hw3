package ua.edu.ucu.smartarr;

import java.util.Arrays;

abstract class SmartArrayDecorator implements SmartArray {
    protected Object[] items;
    protected SmartArray smartArray;

    public SmartArrayDecorator(SmartArray smartArray) {
        this.smartArray = smartArray;
    }

    public Object[] toArray() {
        return Arrays.copyOf(items, items.length);
    }

    public int size() {
        return items.length;
    }

    public abstract Object[] applyOperation(
            SmartArray smartArray
    );

}
