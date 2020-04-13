import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class CohortTest {

    Cohort emptyCohort;
    Cohort cohortWithOne;
    Cohort cohortWithMany;

    @Before
    public void setup(){
        emptyCohort = new Cohort();
        cohortWithOne = new Cohort();
        cohortWithMany = new Cohort();

        Student fer = new Student(1, "Fer M");
        fer.addGrade(90);

        Student trant = new Student(2, "Trant B");
        trant.addGrade(100);
        trant.addGrade(100);
        trant.addGrade(100);

        cohortWithOne.addStudent(fer);
        cohortWithMany.addStudent(fer);
        cohortWithMany.addStudent(trant);
    }

    @Test
    public void testAddStudentAndGetStudentsWork(){
        assertEquals(0, emptyCohort.getStudents().size());
        assertEquals(1, cohortWithOne.getStudents().size());
//        assertEquals(1, cohortWithOne.getStudents().get(0).getId());
    }

    @Test
    public void testIfAvgIsCorrect(){
        assertEquals(95.0, cohortWithMany.getCohortAverage(), 0);
    }


    @Test
    public void testAddStudent() {
        int initialSize = cohortWithMany.getStudents().size();
        Student smith = new Student(1, "Alias Smith");
        smith.addGrade(90);
        smith.addGrade(80);
        cohortWithMany.addStudent(smith);
        assertEquals(initialSize+1, cohortWithMany.getStudents().size());
    }

    @Test
    public void testGetStudents() {
        Student smith = new Student(1, "Alias Smith");
        smith.addGrade(90);
        smith.addGrade(80);
        cohortWithMany.addStudent(smith);
        List<Student> students = cohortWithMany.getStudents();
        assertEquals(3, students.size());
        assertEquals("Fer M", students.get(0).getName());
        assertEquals("Trant B", students.get(1).getName());
        assertEquals("Alias Smith", students.get(2.).getName());
    }

    @Test
    public void testGetCohortAverage() {
        Student smith = new Student(1, "Alias Smith");
        smith.addGrade(90);
        smith.addGrade(80);
        smith.addGrade(70);
        cohortWithMany.addStudent(smith);
        assertEquals(80, cohortWithMany.getCohortAverage(), 0.000001);
    }

}

