package oop.assigment_problems;

public class M4 {

    static class GymMember {

        protected String memberId;
        protected int monthlyFee;
        protected int sessionsAttended;

        public GymMember(String memberId, int monthlyFee) {
            this.memberId = memberId;
            this.monthlyFee = monthlyFee;
            this.sessionsAttended = 0;
        }

        public void attendSession() {
            sessionsAttended++;
        }

        public int getSessionsAttended() {
            return sessionsAttended;
        }

        public void displayInfo() {
            System.out.print(
                "Standard | Sessions: " + sessionsAttended
            );
        }
    }

    static class PremiumMember extends GymMember {

        private String trainerName;

        public PremiumMember(
                String memberId,
                int monthlyFee,
                String trainerName) {

            super(memberId, monthlyFee);
            this.trainerName = trainerName;
        }

        @Override
        public void displayInfo() {
            System.out.print(
                "Premium | Trainer: " + trainerName +
                " | Sessions: " + sessionsAttended
            );
        }

        public String getTrainerName() {
            return trainerName;
        }
    }

    static String batchPrint(GymMember[] members) {

        StringBuilder announcement = new StringBuilder();

        for (GymMember member : members) {

            member.displayInfo();

            if (member instanceof PremiumMember) {

                PremiumMember premium =
                        (PremiumMember) member;

                announcement.append(
                    "Premium | Trainer: " +
                    premium.getTrainerName() +
                    " | Sessions: " +
                    premium.getSessionsAttended() +
                    " [Trainer via downcast: " +
                    premium.getTrainerName() +
                    "] | "
                );

            } else {

                announcement.append(
                    "Standard | Sessions: " +
                    member.getSessionsAttended() +
                    " | "
                );
            }
        }

        return announcement.toString();
    }

    public static void main(String[] args) {

        GymMember standard =
                new GymMember("MEM6", 1000);

        PremiumMember premium =
                new PremiumMember(
                    "MEM7",
                    2000,
                    "Coach Riya"
                );

        GymMember[] members = {
            standard,
            premium
        };

        System.out.println(batchPrint(members));
    }
}