import java.util.*;

interface NotificationChannel {

    void send(Student student, String message);
}

class EmailChannel implements NotificationChannel {

    public void send(Student student, String message) {

        System.out.println(
            "[Email → " +
            student.getName() +
            "] " +
            message
        );
    }
}

class SmsChannel implements NotificationChannel {

    public void send(Student student, String message) {

        System.out.println(
            "[SMS → " +
            student.getName() +
            "] " +
            message
        );
    }
}

class AppChannel implements NotificationChannel {

    public void send(Student student, String message) {

        System.out.println(
            "[App → " +
            student.getName() +
            "] " +
            message
        );
    }
}

class Student {

    private String name;
    private String department;

    private List<NotificationChannel> channels =
        new ArrayList<>();

    Student(String name, String department) {
        this.name = name;
        this.department = department;
    }

    String getName() {
        return name;
    }

    String getDepartment() {
        return department;
    }

    void addChannel(NotificationChannel channel) {
        channels.add(channel);
    }

    List<NotificationChannel> getChannels() {
        return channels;
    }
}

class Notice {

    private String title;
    private Set<String> targetDepartments;

    Notice(
        String title,
        Set<String> targetDepartments
    ) {
        this.title = title;
        this.targetDepartments = targetDepartments;
    }

    boolean isValid() {

        return title != null &&
               !title.trim().isEmpty() &&
               targetDepartments != null &&
               !targetDepartments.isEmpty();
    }

    String getTitle() {
        return title;
    }

    Set<String> getTargetDepartments() {
        return targetDepartments;
    }
}

class NoticeBoard {

    private List<Student> students =
        new ArrayList<>();

    void addStudent(Student student) {
        students.add(student);
    }

    void postNotice(Notice notice) {

        if (!notice.isValid()) {

            System.out.println(
                "Cannot post notice: At least one target department is required."
            );

            return;
        }

        System.out.print(
            "Notice '" +
            notice.getTitle() +
            "' posted to "
        );

        int count = 0;

        for (String department :
             notice.getTargetDepartments()) {

            System.out.print(department);

            count++;

            if (count <
                notice.getTargetDepartments().size()) {

                System.out.print(", ");
            }
        }

        System.out.println(".");

        for (Student student : students) {

            if (notice.getTargetDepartments()
                    .contains(student.getDepartment())) {

                for (NotificationChannel channel :
                     student.getChannels()) {

                    channel.send(
                        student,
                        notice.getTitle()
                    );
                }
            }
        }
    }
}

public class M5 {

    public static void main(String[] args) {

        Student asha =
            new Student("Asha", "CSE");

        asha.addChannel(
            new EmailChannel()
        );

        asha.addChannel(
            new AppChannel()
        );

        Student ravi =
            new Student("Ravi", "ECE");

        ravi.addChannel(
            new SmsChannel()
        );

        NoticeBoard board =
            new NoticeBoard();

        board.addStudent(asha);
        board.addStudent(ravi);

        Set<String> cse =
            new LinkedHashSet<>();

        cse.add("CSE");

        board.postNotice(
            new Notice(
                "Lab Closed Tomorrow",
                cse
            )
        );

        Set<String> cseEce =
            new LinkedHashSet<>();

        cseEce.add("CSE");
        cseEce.add("ECE");

        board.postNotice(
            new Notice(
                "Fee Deadline Extended",
                cseEce
            )
        );

        board.postNotice(
            new Notice(
                "Sports Day",
                new HashSet<>()
            )
        );
    }
}