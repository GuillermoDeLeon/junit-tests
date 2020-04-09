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

    @Test
    public void checkIdIsReturn() {
        assertEquals(1, Student.getId());
        Student.id = 3;
        assertEquals(3,Student.getId());
        Student.id = 4;
        assertEquals(4, Student.getId());
    }

    @Test
    public void checkNameIsReturn() {
        assertEquals("Student One", Student.getName());
        Student.name = "Student Five";
        assertEquals("Student Five", Student.getName());
        Student.name = "$%5Hello";
        assertNotEquals("Student Five", Student.getName());
        assertEquals("$%5Hello", Student.getName());
    }

    @Test
    public void checkIfGradeCanBeAdded() {
        assertEquals(0, Student.grades.size());
        Student.addGrade(90);
        assertEquals(1, Student.grades.size());
        Student.addGrade(60);
        assertEquals(2, Student.grades.size());
        assertEquals(90, (long)Student.grades.get(0));
        assertEquals(60, (long)Student.grades.get(1));
    }

    @Test
    public void checkIfGradeAverageCorrect() {
        Student.addGrade(90);
        Student.addGrade(80);
        Student.addGrade(100);
        Student.addGrade(35);
        assertNotEquals(83, Student.getGradeAverage(),0); //assertEquals would give a failed test
        assertEquals(76.25, Student.getGradeAverage(), 0);

        Student.grades.clear();
        Student.addGrade(78);
        assertEquals(78, Student.getGradeAverage(), 0);


    }

}
