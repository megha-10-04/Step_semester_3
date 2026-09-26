import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

abstract class Assignment {

    protected String title;
    protected int maxMarks;
    protected LocalDate dueDate;

    Assignment(String title, int maxMarks, LocalDate dueDate) {
        this.title = title;
        this.maxMarks = maxMarks;
        this.dueDate = dueDate;
    }

    abstract double applyLatePenalty(double marks, long lateDays);
}

class CodingAssignment extends Assignment {

    CodingAssignment(String title, int maxMarks, LocalDate dueDate) {
        super(title, maxMarks, dueDate);
    }

    double applyLatePenalty(double marks, long lateDays) {
        double penalty = lateDays * 0.10;
        return Math.max(0, marks * (1 - penalty));
    }
}

class WrittenAssignment extends Assignment {

    WrittenAssignment(String title, int maxMarks, LocalDate dueDate) {
        super(title, maxMarks, dueDate);
    }

    double applyLatePenalty(double marks, long lateDays) {
        double penalty = lateDays * 0.20;
        return Math.max(0, marks * (1 - penalty));
    }
}

class Student {

    private String name;

    Student(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}

enum SubmissionStatus {
    SUBMITTED,
    GRADED
}

class Submission {

    private Student student;
    private Assignment assignment;
    private LocalDate submissionDate;
    private SubmissionStatus status;
    private double finalMarks;

    Submission(
        Student student,
        Assignment assignment,
        LocalDate submissionDate
    ) {
        this.student = student;
        this.assignment = assignment;
        this.submissionDate = submissionDate;
        this.status = SubmissionStatus.SUBMITTED;
    }

    void grade(double awardedMarks) {

        if (status == SubmissionStatus.GRADED) {
            System.out.println(
                "Cannot grade again: submission has already been graded."
            );
            return;
        }

        long lateDays = 0;

        if (submissionDate.isAfter(assignment.dueDate)) {
            lateDays = ChronoUnit.DAYS.between(
                assignment.dueDate,
                submissionDate
            );
        }

        finalMarks =
            assignment.applyLatePenalty(
                awardedMarks,
                lateDays
            );

        status = SubmissionStatus.GRADED;

        if (lateDays == 0) {

            System.out.printf(
                "%s graded: %.0f/%d.%n",
                student.getName(),
                finalMarks,
                assignment.maxMarks
            );

        } else {

            double penaltyPercent;

            if (assignment instanceof CodingAssignment) {
                penaltyPercent = lateDays * 10;
            } else {
                penaltyPercent = lateDays * 20;
            }

            System.out.printf(
                "%s graded: %.0f/%d after %.0f%% late penalty.%n",
                student.getName(),
                finalMarks,
                assignment.maxMarks,
                penaltyPercent
            );
        }

        System.out.println("Status: " + status);
    }

    void resubmit(LocalDate date) {

        if (status == SubmissionStatus.GRADED) {

            System.out.println(
                "Cannot resubmit: '" +
                assignment.title +
                "' has already been graded."
            );

            return;
        }

        submissionDate = date;
        status = SubmissionStatus.SUBMITTED;
    }

    SubmissionStatus getStatus() {
        return status;
    }
}

public class M2 {

    public static void main(String[] args) {

        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");

        Assignment coding =
            new CodingAssignment(
                "Linked List Lab",
                50,
                LocalDate.of(2027, 3, 10)
            );

        Assignment written =
            new WrittenAssignment(
                "Design Essay",
                50,
                LocalDate.of(2027, 3, 12)
            );

        Submission ashaSubmission =
            new Submission(
                asha,
                coding,
                LocalDate.of(2027, 3, 10)
            );

        System.out.println(
            "Asha's submission for 'Linked List Lab' received (on time)."
        );

        System.out.println(
            "Status: " + ashaSubmission.getStatus()
        );

        Submission raviSubmission =
            new Submission(
                ravi,
                written,
                LocalDate.of(2027, 3, 14)
            );

        System.out.println(
            "Ravi's submission for 'Design Essay' received (2 days late)."
        );

        System.out.println(
            "Status: " + raviSubmission.getStatus()
        );

        ashaSubmission.grade(45);

        raviSubmission.grade(40);

        ashaSubmission.resubmit(
            LocalDate.of(2027, 3, 11)
        );
    }
}