package ontrack;

public class FeedbackAccessService {

    public String verifyFeedbackAccess(String studentId,
            String assignmentId,
            String reviewStatus,
            boolean feedbackReleased) {

        return "Feedback access granted";
    }
}