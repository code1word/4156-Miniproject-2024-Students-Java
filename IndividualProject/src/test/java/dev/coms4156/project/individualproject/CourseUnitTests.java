package dev.coms4156.project.individualproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * This class contains all of the unit tests for the Course class.
 */
@SpringBootTest
@ContextConfiguration
public class CourseUnitTests {

  @BeforeAll
  public static void setupCourseForTesting() {
    testCourse = new Course("Griffin Newbold", "417 IAB", "11:40-12:55", 20);
  }

  /** The test course instance used for testing. */
  public static Course testCourse;

  @Test
  public void toStringTest() {
    String expectedResult = "\nInstructor: Griffin Newbold; Location: 417 IAB; Time: 11:40-12:55";
    assertEquals(expectedResult, testCourse.toString());
  }

  @Test
  public void getLocationTest() {
    String expectedLocation = "417 IAB";
    assertEquals(expectedLocation, testCourse.getCourseLocation());
  }

  @Test
  public void getInstructorNameTest() {
    String expectedInstructor = "Griffin Newbold";
    assertEquals(expectedInstructor, testCourse.getInstructorName());
  }

  @Test
  public void getTimeTest() {
    String expectedTime = "11:40-12:55";
    assertEquals(expectedTime, testCourse.getCourseTimeSlot());
  }

  @Test
  public void enrollStudentTest() {
    for (int i = 0; i < 20; i++) {
      assertTrue(testCourse.enrollStudent());
    }
    assertTrue(testCourse.isCourseFull());
    assertFalse(testCourse.enrollStudent());
  }

  @Test
  public void dropStudentTest() {
    testCourse.setEnrolledStudentCount(0);
    assertFalse(testCourse.dropStudent());
    testCourse.enrollStudent();
    assertTrue(testCourse.dropStudent());
  }

  @Test
  public void setEnrollmentCountTest() {
    testCourse.setEnrolledStudentCount(4);
    assertEquals(false, testCourse.isCourseFull());
    testCourse.setEnrolledStudentCount(300);
    assertEquals(false, testCourse.isCourseFull());
    testCourse.setEnrolledStudentCount(-1);
    assertEquals(false, testCourse.isCourseFull());
  }

  @Test
  public void reassignTest() {
    String expectedInstructor = "Tony Dear";
    String expectedLocation = "480 CSB";
    String expectedTime = "8:00-9:00";
    testCourse.reassignInstructor(expectedInstructor);
    testCourse.reassignLocation(expectedLocation);
    testCourse.reassignTime(expectedTime);
    assertEquals(expectedInstructor, testCourse.getInstructorName());
    assertEquals(expectedLocation, testCourse.getCourseLocation());
    assertEquals(expectedTime, testCourse.getCourseTimeSlot());
  }

  /** The test course instance used for testing. */
  public static Course testCourse;
}
