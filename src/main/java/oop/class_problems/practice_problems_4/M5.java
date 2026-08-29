package oop.practice_problems_4;

public class M5 {

    static class FeeAccount {
    }

    static class HostelFeeAccount extends FeeAccount {
    }

    static class PaymentProcessor {

        int hostelCount = 0;
        int dayScholarCount = 0;

        public void processPayment(
                FeeAccount account,
                double amount) {

            if (account instanceof HostelFeeAccount) {

                System.out.println(
                        "Paid in two installments (hostel account)"
                );

                hostelCount++;

            } else {

                System.out.println(
                        "Paid in one go (day-scholar account)"
                );

                dayScholarCount++;
            }
        }

        public void printCounts() {
            System.out.println(
                    "Hostel accounts processed: "
                            + hostelCount
                            + " | Day-scholar accounts processed: "
                            + dayScholarCount
            );
        }
    }

    public static void main(String[] args) {

        FeeAccount[] accounts = {
                new HostelFeeAccount(),
                new HostelFeeAccount(),
                new FeeAccount(),
                new FeeAccount()
        };

        double amount = 60000;

        PaymentProcessor processor =
                new PaymentProcessor();

        for (FeeAccount account : accounts) {
            processor.processPayment(account, amount);
        }

        processor.printCounts();
    }
}