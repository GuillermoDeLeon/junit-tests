import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest {

    @Before

    public void setUp() {
        new Student(1, "Student One");
    }

    @Test
    public void checkIfSetUpCorrect() {
        assertEquals(1, Student.id);
        assertEquals("Student One", Student.name);
        assertNotNull(Student.grades);
    }

    @Test
    public void checkConstructorWorks() {
        new Student(2, "Student Two");
        assertEquals(2, Student.id);
        assertEquals("Student Two", Student.name);
//        assertNotNull(Student.grades);
    }
}
