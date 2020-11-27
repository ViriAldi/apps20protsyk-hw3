package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

public class MapDecorator extends SmartArrayDecorator {
    private MyFunction function;

    public MapDecorator(
            SmartArray initArray,
            MyFunction initFunction) {
        super(initArray);
        function = initFunction;
        setItems(applyOperation(getWrapped()));
    }

    @Override
    public Object[] applyOperation(SmartArray smartArray) {
        Object[] array = smartArray.toArray();
        Object[] newArray = new Object[smartArray.size()];
        for (int i = 0; i < smartArray.size(); i++) {
            newArray[i] = function.apply(array[i]);
        }
        return newArray;
    }

    public String operationDescription() {
        return "Applies given function to all elements";
    }

}
