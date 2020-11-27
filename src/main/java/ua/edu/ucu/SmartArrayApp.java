package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {
                
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr);
        sa = new SortDecorator(sa, cmp);
        sa = new MapDecorator(sa, func);

        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {

        MyPredicate predicate = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                Student student = (Student) t;
                return (student.getYear() == 2) && (student.getGPA() >= 4.0);
            }
        };

        MyComparator comparator = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Student) o1).getSurname().compareTo(((Student) o2).getSurname());
            }
        };

        MyFunction function = new MyFunction() {
            @Override
            public Object apply(Object t) {
                Student student = (Student) t;

                return String.format("%s %s", student.getSurname(),student.getName());
            }
        };

        SmartArray array = new BaseArray(students);

        array = new MapDecorator(
                new SortDecorator(
                        new FilterDecorator(
                                new DistinctDecorator(
                                        array
                                ),
                                predicate
                        ),
                        comparator
                ),
                function
        );


        return Arrays.copyOf(array.toArray(), array.size(), String[].class);
    }
}
