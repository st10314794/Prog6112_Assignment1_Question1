/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package prog_a1_q1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mik
 */
public class StudentTest {

    Student stud = new Student();
    private ByteArrayOutputStream outputStream;
    private InputStream inputStream;

    ArrayList<String> studID = new ArrayList<>();
    ArrayList<String> studNames = new ArrayList<>();
    ArrayList<Integer> studAges = new ArrayList<>();
    ArrayList<String> studEmails = new ArrayList<>();
    ArrayList<String> studCourses = new ArrayList<>();

    @Before
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        studID.add("123");
        studNames.add("mike");
        studAges.add(19);
        studEmails.add("mik@gmail.com");
        studCourses.add("BCAD");

        stud.setStudentID(studID);
        stud.setStudentName(studNames);
        stud.setStudentAge(studAges);
        stud.setStudentEmail(studEmails);
        stud.setStudentCourse(studCourses);

    }

    @After
    public void tearDown() {
        System.setOut(System.out);
    }

    @Test
    public void testStudentAgeValidChar() {
        System.out.println("studentAgeValidChar");
        String strAge = "123";
        boolean expected = true;
        boolean actual = stud.studentAgeValidChar(strAge);
        assertEquals(expected, actual);

    }

    @Test
    public void testStudentAgeInvalidChar() {
        System.out.println("studentAgeValidChar");
        String strAge = "12e";
        boolean expected = false;
        boolean actual = stud.studentAgeValidChar(strAge);
        assertEquals(expected, actual);

    }

    @Test
    public void testStudentAgeValid() {
        System.out.println("studentAgeValid");
        boolean expected = false;
        boolean actual = stud.studentAgeValid();
        assertEquals(expected, actual);

    }

    @Test
    public void testStudentAgeInvalid() {
        System.out.println("studentAgeValid");
        boolean expResult = false;
        boolean result = stud.studentAgeValid();
        assertEquals(expResult, result);

    }

    /*
    Tests that method adds details to arraylists
     */
    @Test
    public void testSaveStudent() {
        System.out.println("SaveStudent");

        stud.SaveStudent();
        assertEquals(studID.get(0), stud.getStudentID().get(0));
        assertEquals(studNames.get(0), stud.getStudentName().get(0));
        assertEquals(studAges.get(0), stud.getStudentAge().get(0));
        assertEquals(studEmails.get(0), stud.getStudentEmail().get(0));
        assertEquals(studCourses.get(0), stud.getStudentCourse().get(0));

    }

    @Test
    public void testSearchStudentFound() {
        System.out.println("SearchStudent");

        String studentID = "123";
        inputStream = new ByteArrayInputStream(studentID.getBytes());
        System.setIn(inputStream);

        stud.SearchStudent();

        assertTrue(outputStream.toString().contains("STUDENT ID :123"));
        assertTrue(outputStream.toString().contains("STUDENT NAME :mike"));
        assertTrue(outputStream.toString().contains("STUDENT AGE :19"));
        assertTrue(outputStream.toString().contains("STUDENT EMAIL :mik@gmail.com"));
        assertTrue(outputStream.toString().contains("STUDENT COURSE :BCAD"));

    }

    @Test
    public void testSearchStudentNotFound() {
        System.out.println("SearchStudent");
        
        String studentID = "321";
        inputStream = new ByteArrayInputStream(studentID.getBytes());
        System.setIn(inputStream);

        stud.SearchStudent();

        assertTrue(outputStream.toString().contains("Student with Student ID: " + studentID + " was not found"));
    }

    @Test
    public void testDeleteStudent() {
        System.out.println("DeleteStudent");

        String deleteID = "123\ny";
        inputStream = new ByteArrayInputStream(deleteID.getBytes());
        System.setIn(inputStream);

        stud.DeleteStudent();

        assertFalse(stud.getStudentID().contains("123"));
        assertFalse(stud.getStudentName().contains("mike"));
        assertFalse(stud.getStudentAge().contains("19"));
        assertFalse(stud.getStudentEmail().contains("mik@gmail.com"));
        assertFalse(stud.getStudentCourse().contains("BCAD"));

    }

    @Test
    public void testDeleteStudentNotFound() {
        System.out.println("DeleteStudent");

        String deleteID = "321";
        inputStream = new ByteArrayInputStream(deleteID.getBytes());
        System.setIn(inputStream);

        stud.DeleteStudent();

        assertTrue(outputStream.toString().contains("The student with ID: " + deleteID + " was not found."));

    }

}
