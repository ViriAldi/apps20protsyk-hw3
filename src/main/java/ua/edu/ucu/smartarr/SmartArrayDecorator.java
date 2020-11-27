package ua.edu.ucu.smartarr;

import java.util.Arrays;

abstract class SmartArrayDecorator implements SmartArray {
    private Object[] items;
    private SmartArray smartArray;

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

    public SmartArray getWrapped() {
        return smartArray;
    }

    public void setItems(Object[] newItems) {
        items = newItems;
    }

}
