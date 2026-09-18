package oop.assigment_problems;

import java.util.Arrays;

public class M3 {

    static class GymMember {

        private String memberId;
        private int monthlyFee;

        private int[] lateFeeHistory = new int[10];
        private int feeCount = 0;
        private int totalLateFees = 0;

        public GymMember(String memberId, int monthlyFee) {
            this.memberId = memberId;
            this.monthlyFee = monthlyFee;
        }

        protected void chargeLateFee(int amount) {

            totalLateFees += amount;

            lateFeeHistory[feeCount] = amount;
            feeCount++;
        }

        public int[] getLateFeeHistory() {
            return Arrays.copyOf(lateFeeHistory, feeCount);
        }

        public int getTotalLateFees() {
            return totalLateFees;
        }
    }

    static class PremiumMember extends GymMember {

        public PremiumMember(
                String memberId,
                int monthlyFee,
                String trainerName) {

            super(memberId, monthlyFee);
        }

        @Override
        protected void chargeLateFee(int amount) {
            super.chargeLateFee(amount / 2);
        }
    }

    public static void main(String[] args) {

        PremiumMember p =
                new PremiumMember(
                    "MEM5",
                    2000,
                    "Coach Riya"
                );

        p.chargeLateFee(200);

        System.out.println(p.getTotalLateFees());

        int[] history = p.getLateFeeHistory();

        history[0] = 999;

        System.out.println(
            Arrays.toString(p.getLateFeeHistory())
        );
    }
}