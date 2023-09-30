package de.tum.in.ase.eist;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;

class OnlineCourseTest {

	@Test
	void testSetOnlineCourseUrlWithValidUrl() throws MalformedURLException {
		OnlineCourse course = new OnlineCourse("ASE");
		URL url = new URL("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
		course.setUrl(url.toString());
		assertEquals(url, course.getUrl());
	}

	@Test
	void testSetOnlineCourseUrlWithInvalidUrl() {
		OnlineCourse course = new OnlineCourse("ASE");
		assertThrows(MalformedURLException.class, () -> {
			course.setUrl("invalid url");
		});
	}
}
