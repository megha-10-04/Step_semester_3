package oop.class_problems;

public class M4 {

    static class LibraryMember {
        protected String memberId;
        protected int borrowLimit;
        protected int booksBorrowed;

        public LibraryMember(String memberId, int borrowLimit) {
            this.memberId = memberId;
            this.borrowLimit = borrowLimit;
            this.booksBorrowed = 0;
        }

        public void borrowBook() {
            if (booksBorrowed < borrowLimit) {
                booksBorrowed++;
            }
        }

        public int getBooksBorrowed() {
            return booksBorrowed;
        }

        public void displayInfo() {
            System.out.print(
                "General | Books: " + booksBorrowed
            );
        }
    }

    static class StudentMember extends LibraryMember {
        private String course;

        public StudentMember(
                String memberId,
                int borrowLimit,
                String course) {

            super(memberId, borrowLimit);
            this.course = course;
        }

        @Override
        public void displayInfo() {
            System.out.print(
                "Student | Course: " + course +
                " | Books: " + booksBorrowed
            );
        }

        public String getCourse() {
            return course;
        }
    }

    static String batchPrint(LibraryMember[] members) {

        StringBuilder report = new StringBuilder();

        for (LibraryMember member : members) {

            // Polymorphic call
            member.displayInfo();

            if (member instanceof StudentMember) {

                StudentMember student =
                        (StudentMember) member;

                report.append(
                    "Student | Course: " +
                    student.getCourse() +
                    " | Books: " +
                    student.getBooksBorrowed() +
                    " [Course via downcast: " +
                    student.getCourse() +
                    "] | "
                );

            } else {

                report.append(
                    "General | Books: " +
                    member.getBooksBorrowed() +
                    " | "
                );
            }
        }

        return report.toString();
    }

    public static void main(String[] args) {

        LibraryMember general =
                new LibraryMember("LB5", 3);

        StudentMember student =
                new StudentMember("STU6", 3, "ECE");

        LibraryMember[] members = {
            general,
            student
        };

        System.out.println(batchPrint(members));
    }
}