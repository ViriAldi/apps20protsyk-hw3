package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;

public class FilterDecorator extends SmartArrayDecorator {
    private MyPredicate predicate;

    public FilterDecorator(SmartArray initArray, MyPredicate initPredicate) {
        super(initArray);
        predicate = initPredicate;
        setItems(applyOperation(getWrapped()));
    }

    @Override
    public Object[] applyOperation(SmartArray smartArray) {
        Object[] array = smartArray.toArray();
        Object[] newArray = new Object[smartArray.size()];
        int newLength = 0;
        for (Object item : array) {
            if (predicate.test(item)) {
                newArray[newLength] = item;
                newLength += 1;
            }
        }
        return Arrays.copyOf(newArray, newLength);
    }

    public String operationDescription() {
        return "Filters array";
    }
}
