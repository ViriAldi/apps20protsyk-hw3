package ua.edu.ucu;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentTest {
    Student student;
    @Before
    public void initStudent() {
        student = new Student("Bob", "Smith", 5.0, 2020);

    }

    @Test
    public void testGetName() {
        assertEquals("Bob", student.getName());
    }

    @Test
    public void testGetSurname() {
        assertEquals("Smith", student.getSurname());
    }

    @Test
    public void testGetGPA() {
        assertEquals(5.0, student.getGPA(), 0.0001);
    }

    @Test
    public void testGetYear() {
        assertEquals(2020, student.getYear());
    }

    @Test
    public void testToString() {
        assertEquals(
                "Student{name=Bob," +
                " surname=Smith," +
                " GPA=5.0, year=2020}",
                student.toString()
        );
    }
}
