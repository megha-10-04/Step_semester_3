import java.util.*;

abstract class Question {

    String questionText;
    int marks;

    Question(String questionText, int marks) {
        this.questionText = questionText;
        this.marks = marks;
    }

    abstract boolean evaluate(String answer);
}

class MCQQuestion extends Question {

    String correctAnswer;

    MCQQuestion(String questionText, String correctAnswer, int marks) {
        super(questionText, marks);
        this.correctAnswer = correctAnswer;
    }

    boolean evaluate(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }
}

class TrueFalseQuestion extends Question {

    boolean correctAnswer;

    TrueFalseQuestion(String questionText, boolean correctAnswer, int marks) {
        super(questionText, marks);
        this.correctAnswer = correctAnswer;
    }

    boolean evaluate(String answer) {
        return Boolean.parseBoolean(answer) == correctAnswer;
    }
}

class ShortAnswerQuestion extends Question {

    String correctAnswer;

    ShortAnswerQuestion(String questionText, String correctAnswer, int marks) {
        super(questionText, marks);
        this.correctAnswer = correctAnswer;
    }

    boolean evaluate(String answer) {
        return correctAnswer.equalsIgnoreCase(answer.trim());
    }
}

class Student {

    String name;

    Student(String name) {
        this.name = name;
    }
}

class Examination {

    String name;
    ArrayList<Question> questions = new ArrayList<>();

    Examination(String name) {
        this.name = name;
    }

    void addQuestion(Question question) {
        questions.add(question);
    }
}

class Attempt {

    Student student;
    Examination examination;
    HashMap<Question, String> answers = new HashMap<>();
    boolean submitted = false;

    Attempt(Student student, Examination examination) {
        this.student = student;
        this.examination = examination;
    }

    void answerQuestion(Question question, String answer) {

        if (submitted) {
            System.out.println(
                "Cannot change answers for a submitted examination."
            );
            return;
        }

        answers.put(question, answer);
        System.out.println("Answer recorded for Question "
                + (examination.questions.indexOf(question) + 1));
    }

    void submit() {

        if (submitted) {
            return;
        }

        submitted = true;

        int total = 0;
        int score = 0;

        for (Question question : examination.questions) {

            total += question.marks;

            String answer = answers.get(question);

            boolean correct =
                answer != null && question.evaluate(answer);

            if (correct) {
                score += question.marks;
            }

            System.out.println(
                "Question " +
                (examination.questions.indexOf(question) + 1) +
                ": " +
                (correct ? "Correct" : "Incorrect") +
                " (" +
                (correct ? question.marks : 0) +
                " points)"
            );
        }

        System.out.println(
            "Total score: " + score + "/" + total
        );
    }
}

public class M3 {

    public static void main(String[] args) {

        Student student = new Student("Student 1");

        Examination exam = new Examination("Exam A");

        Question q1 =
            new MCQQuestion(
                "Which option is correct?",
                "C",
                5
            );

        Question q2 =
            new TrueFalseQuestion(
                "Java is a programming language.",
                false,
                5
            );

        exam.addQuestion(q1);
        exam.addQuestion(q2);

        System.out.println(
            "Exam A started by Student 1."
        );

        Attempt attempt = new Attempt(student, exam);

        attempt.answerQuestion(q1, "C");
        attempt.answerQuestion(q2, "True");

        System.out.println(
            "Exam A submitted by Student 1."
        );

        attempt.submit();

        attempt.answerQuestion(q1, "A");
    }
}