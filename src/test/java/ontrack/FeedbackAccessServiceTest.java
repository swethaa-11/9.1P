package ontrack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FeedbackAccessServiceTest {

    @Test
    public void shouldGrantFeedbackAccess() {

        FeedbackAccessService service = new FeedbackAccessService();

        String result = service.verifyFeedbackAccess(
                "STU1001",
                "ASSIGN1",
                "COMPLETED",
                true);

        assertEquals("Feedback access granted", result);
    }

    @Test
    public void shouldBlockAccessWhenUnderReview() {

        FeedbackAccessService service = new FeedbackAccessService();

        String result = service.verifyFeedbackAccess(
                "STU1001",
                "ASSIGN1",
                "UNDER_REVIEW",
                true);

        assertEquals("Feedback unavailable: assignment under review", result);
    }

    @Test
    public void shouldBlockAccessWhenFeedbackNotReleased() {

        FeedbackAccessService service = new FeedbackAccessService();

        String result = service.verifyFeedbackAccess(
                "STU1001",
                "ASSIGN1",
                "COMPLETED",
                false);

        assertEquals("Feedback unavailable: tutor has not released feedback", result);
    }

    @Test
    public void shouldDetectInvalidStudentInformation() {

        FeedbackAccessService service = new FeedbackAccessService();

        String result = service.verifyFeedbackAccess(
                "",
                "ASSIGN1",
                "COMPLETED",
                true);

        assertEquals("Invalid student information", result);
    }

    @Test
    public void shouldDetectInvalidAssignmentInformation() {

        FeedbackAccessService service = new FeedbackAccessService();

        String result = service.verifyFeedbackAccess(
                "STU1001",
                "",
                "COMPLETED",
                true);

        assertEquals("Invalid assignment information", result);
    }
}