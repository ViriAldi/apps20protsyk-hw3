package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

public class SortDecorator extends SmartArrayDecorator {
    private MyComparator comparator;

    public SortDecorator(
            SmartArray initArray,
            MyComparator initComparator) {
        super(initArray);
        comparator = initComparator;
        setItems(applyOperation(getWrapped()));
    }

    @Override
    public Object[] applyOperation(SmartArray smartArray) {
        Object[] newArray = Arrays.copyOf(
                smartArray.toArray(),
                smartArray.size()
        );
        Arrays.sort(newArray, comparator);
        return newArray;
    }


    public String operationDescription() {
        return "Sorts the array with given comparator";
    }
    
}
