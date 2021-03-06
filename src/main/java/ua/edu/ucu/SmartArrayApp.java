package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.BaseArray;
import ua.edu.ucu.smartarr.DistinctDecorator;
import ua.edu.ucu.smartarr.FilterDecorator;
import ua.edu.ucu.smartarr.SortDecorator;
import ua.edu.ucu.smartarr.SmartArray;
import ua.edu.ucu.smartarr.MapDecorator;


public class SmartArrayApp {
    private static final double LIM_GPA = 4.0;
    private static final int GROUP_YEAR = 2;

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
                return (student.getYear() == GROUP_YEAR)
                        && (student.getGPA() >= LIM_GPA);
            }
        };

        MyComparator comparator = new MyComparator() {
            @Override
            public int compare(Object student, Object otherStudent) {
                return ((Student) student)
                        .getSurname()
                        .compareTo(
                                ((Student) otherStudent)
                                        .getSurname()
                        );
            }
        };

        MyFunction function = new MyFunction() {
            @Override
            public Object apply(Object t) {
                Student student = (Student) t;

                return String.format(
                        "%s %s",
                        student.getSurname(),
                        student.getName());
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
