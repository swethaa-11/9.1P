package ontrack;

public class FeedbackAccessService {

    public String verifyFeedbackAccess(String studentId, String assignmentId,
            String reviewStatus, boolean feedbackReleased) {

        if (studentId == null || studentId.isBlank()) {
            return "Invalid student information";
        }

        if (assignmentId == null || assignmentId.isBlank()) {
            return "Invalid assignment information";
        }

        if (!feedbackReleased) {
            return "Feedback unavailable: tutor has not released feedback";
        }

        if (reviewStatus == null || reviewStatus.isBlank()) {
            return "Invalid review status";
        }

        switch (reviewStatus.toUpperCase()) {

        case "UNDER_REVIEW":
            return "Feedback unavailable: assignment under review";

        case "COMPLETED":
            return "Feedback access granted";

        default:
            return "Invalid review status";
        }
    }
}