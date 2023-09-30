package de.tum.in.ase.eist;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

	@Test
	void testGetCourseTitle() {
		Course course = new Course("ASE");
		assertEquals("ASE", course.getTitle());

	}

	@Test
	void testNoAttendees() {
		Course course = new Course("ASE");
		assertEquals(0, course.getNumberOfAttendees());
	}

	@Test
	void testThreeAttendees() {
		Course course = new Course("ASE");
		course.addAttendee(new Student("a", "b", "c", "d", "e"));
		course.addAttendee(new Student("B", "b", "c", "d", "e"));
		course.addAttendee(new Student("C", "b", "c", "d", "e"));
		assertEquals(3, course.getNumberOfAttendees());
	}

}
