package de.tum.in.ase.eist;

import org.easymock.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDate;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(EasyMockExtension.class)
class DiscussionTest {

    @TestSubject
    private Discussion discussion;

    @Mock
    private Comment commentMock;

    @Mock
    private Course courseMock;

    @Test
    void testComment() {
        // Set up the behavior of the commentMock
        expect(commentMock.save()).andReturn(true);
        replay(commentMock);

        // Invoke the addComment() method
        boolean result = discussion.addComment(commentMock);

        // Verify the result and number of comments
        assertTrue(result);
        assertEquals(1, discussion.getNumberOfComments());

        // Verify that the commentMock's save() method was called
        verify(commentMock);
    }

    @Test
    void testCommentIfSavingFails() {
        expect(commentMock.save()).andReturn(false);
        replay(commentMock);

        var bool = discussion.addComment(commentMock);
        assertFalse(bool);

        verify(commentMock);
    }

    @Test
    void testStartCourseDiscussion() {
        Student student = new Student("a", "b", LocalDate.now(), "d", "e");
        expect(courseMock.isDiscussionAllowed(student)).andReturn(true);
        replay(courseMock);

        var bool = discussion.startCourseDiscussion(courseMock, student, "topic");
        assertTrue(bool);
        assertEquals(courseMock, discussion.getCourse());
        assertEquals("topic", discussion.getTopic());

        verify(courseMock);
    }
}
