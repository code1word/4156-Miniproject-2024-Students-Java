package dev.coms4156.project.individualproject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * This class contains all of the unit tests for the Department class.
 */
@SpringBootTest
@ContextConfiguration
public class DepartmentUnitTests {

  /** The test department instance used for testing. */
  public static HashMap<String, Course> testCourses;
  public static Department testDep;

  /**
   * This function does the initial @BeforeEach setup before
   * each @Test function is run.
   */
  @BeforeEach
  public void setupDepartmentForTesting() {
    testCourses = new HashMap<String, Course>();
    Course coms4701 = new Course("Tony Dear", "501 SCH", "11:40-12:55", 200);
    testCourses.put("4701", coms4701);
    testDep = new Department("COMS", testCourses, "Luca Carloni", 2000);
  }

  @Test
  public void getCourseSelectionTest() {
    assertEquals(testCourses, testDep.getCourseSelection());
  }

  @Test
  public void getNumberofMajorsTest() {
    assertEquals(2000, testDep.getNumberOfMajors());
  }

  @Test
  public void getDepartmentChairTest() {
    assertEquals("Luca Carloni", testDep.getDepartmentChair());
  }

  @Test
  public void addPersonToMajorTest() {
    assertEquals(2000, testDep.getNumberOfMajors());
    testDep.addPersonToMajor();
    assertEquals(2001, testDep.getNumberOfMajors());
  }

  @Test
  public void dropPersonFromMajorTest() {
    assertEquals(2000, testDep.getNumberOfMajors());
    testDep.dropPersonFromMajor();
    assertEquals(1999, testDep.getNumberOfMajors());
  }

  @Test
  public void dropPersonWhenMajorEmptyTest() {
    for (int i = 0; i < 2000; i++) {
      testDep.dropPersonFromMajor();
    }
    assertEquals(0, testDep.getNumberOfMajors());
    testDep.dropPersonFromMajor();
    assertEquals(0, testDep.getNumberOfMajors());
  }

  @Test
  public void addCourseTest() {
    Course coms4995 = new Course("Yongwhan Lim", "417 IAB", "1:10-2:25", 150);
    testDep.addCourse("4995", coms4995);
    testCourses.put("4995", coms4995);
    assertEquals(testDep.getCourseSelection(), testCourses);
  }

}