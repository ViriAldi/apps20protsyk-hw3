package ua.edu.ucu.functions;

import java.util.Comparator;

public interface MyComparator extends Comparator<Object> {

    @Override
    public int compare(Object o1, Object o2);
    
}
