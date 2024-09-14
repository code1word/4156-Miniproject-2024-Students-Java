package dev.coms4156.project.individualproject;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents a course with an instructor, location, time slot, and enrollment
 * capacity.
 * Allows for students to enroll and drop, and accordingly reassigns course
 * details.
 */

public class Course implements Serializable {

  @Serial
  private static final long serialVersionUID = 123456L;

  private final int enrollmentCapacity;
  private int enrolledStudentCount;
  private String courseLocation;
  private String instructorName;
  private String courseTimeSlot;

  /**
   * Constructs a new Course object with the given parameters. Initial count
   * starts at 0.
   *
   * @param instructorName The name of the instructor teaching the course.
   * @param courseLocation The location where the course is held.
   * @param timeSlot       The time slot of the course.
   * @param capacity       The maximum number of students that can enroll in the
   *                       course.
   */
  public Course(String instructorName, String courseLocation, String timeSlot, int capacity) {
    this.courseLocation = courseLocation;
    this.instructorName = instructorName;
    this.courseTimeSlot = timeSlot;
    this.enrollmentCapacity = capacity;
    this.enrolledStudentCount = 0;
  }

  /**
   * Enrolls a student in the course if there is space available.
   *
   * @return true if the student is successfully enrolled, false otherwise.
   */
  public boolean enrollStudent() {
    if (enrolledStudentCount < enrollmentCapacity) {
      enrolledStudentCount++;
      return true;
    }
    return false;
  }

  /**
   * Drops a student from the course if a student is enrolled.
   *
   * @return true if the student is successfully dropped, false otherwise.
   */
  public boolean dropStudent() {
    if (enrolledStudentCount > 0) {
      enrolledStudentCount--;
      return true;
    }
    return false;
  }

  /**
   * Gets the location of the course.
   *
   * @return the location of the course.
   */
  public String getCourseLocation() {
    return this.courseLocation;
  }

  /**
   * Gets the name of the course's instructor.
   *
   * @return the name of the instructor.
   */
  public String getInstructorName() {
    return this.instructorName;
  }

  /**
   * Gets the time slot for the course.
   *
   * @return the time slot of the course.
   */
  public String getCourseTimeSlot() {
    return this.courseTimeSlot;
  }

  /**
   * Provides a string represetation of the course.
   *
   * @return a string describing the course.
   */
  public String toString() {
    return "\nInstructor: " + instructorName
        + "; Location: " + courseLocation
        + "; Time: " + courseTimeSlot;
  }

  /**
   * Reassigns the course to a new instructor.
   *
   * @param newInstructorName which is the name of the new instructor.
   */
  public void reassignInstructor(String newInstructorName) {
    this.instructorName = newInstructorName;
  }

  /**
   * Reassigns the time slot of the course.
   *
   * @param newLocation which is the new location of the course.
   */
  public void reassignLocation(String newLocation) {
    this.courseLocation = newLocation;
  }

  /**
   * Reassigns the time slot for the course.
   *
   * @param newTime which is the new time slot for the course.
   */
  public void reassignTime(String newTime) {
    this.courseTimeSlot = newTime;
  }

  /**
   * Sets the number of students who are currently enrolled in the course.
   *
   * @param count which is the new count of enrolled students.
   */
  public void setEnrolledStudentCount(int count) {
    if (count <= enrollmentCapacity && count >= 0) {
      this.enrolledStudentCount = count;
    }
  }

  /**
   * Checks if the course is full based on the specified enrollment capacity.
   *
   * @return true if the course is full, false otherwise.
   */
  public boolean isCourseFull() {
    return enrollmentCapacity <= enrolledStudentCount;
  }

}
