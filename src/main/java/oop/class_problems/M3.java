package oop.class_problems;

import java.util.Arrays;

public class M3 {

    static class LibraryMember {
        private String memberId;
        private int borrowLimit;
        private int booksBorrowed;

        private int[] fineHistory = new int[10];
        private int fineCount = 0;
        private int totalFine = 0;

        public LibraryMember(String memberId, int borrowLimit) {
            this.memberId = memberId;
            this.borrowLimit = borrowLimit;
        }

        protected void chargeFine(int amount) {
            totalFine += amount;
            fineHistory[fineCount] = amount;
            fineCount++;
        }

        public int[] getFineHistory() {
            return Arrays.copyOf(fineHistory, fineCount);
        }

        public int getTotalFine() {
            return totalFine;
        }
    }

    static class StudentMember extends LibraryMember {

        public StudentMember(String memberId, int borrowLimit, String course) {
            super(memberId, borrowLimit);
        }

        @Override
        protected void chargeFine(int amount) {
            super.chargeFine(amount / 2);
        }
    }

    public static void main(String[] args) {

        StudentMember s =
                new StudentMember("STU5", 3, "CSE");

        s.chargeFine(100);

        System.out.println(s.getTotalFine());

        int[] history = s.getFineHistory();

        history[0] = 999;

        System.out.println(Arrays.toString(s.getFineHistory()));
    }
}