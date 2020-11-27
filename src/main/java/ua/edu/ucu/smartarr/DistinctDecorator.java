package ua.edu.ucu.smartarr;

import java.util.Arrays;

public class DistinctDecorator extends SmartArrayDecorator {

    public DistinctDecorator(SmartArray initArray) {
        super(initArray);
        setItems(applyOperation(getWrapped()));
    }

    @Override
    public Object[] applyOperation(SmartArray smartArray) {
        Object[] array = smartArray.toArray();
        Object[] newArray = new Object[smartArray.size()];
        int newLength = 0;
        boolean unique;
        for (Object item : array) {
            unique = true;
            for (Object newItem: newArray) {
                if (item.equals(newItem)) {
                    unique = false;
                    break;
                }
            }
            if (unique) {
                newArray[newLength] = item;
                newLength += 1;
            }
        }
        return Arrays.copyOf(newArray, newLength);
    }

    public String operationDescription() {
        return "Makes a set of all items";
    }

}
