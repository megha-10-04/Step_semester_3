interface MembershipPlan {

    double calculateFee();

    String getPlanName();
}

class MonthlyPlan implements MembershipPlan {

    public double calculateFee() {
        return 1000;
    }

    public String getPlanName() {
        return "Monthly";
    }
}

class QuarterlyPlan implements MembershipPlan {

    public double calculateFee() {
        return 1000 * 3 * 0.90;
    }

    public String getPlanName() {
        return "Quarterly";
    }
}

class AnnualPlan implements MembershipPlan {

    public double calculateFee() {
        return 1000 * 12 * 0.75;
    }

    public String getPlanName() {
        return "Annual";
    }
}

enum MembershipStatus {
    ACTIVE,
    FROZEN,
    EXPIRED
}

class Member {

    private String name;

    Member(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}

class Membership {

    private Member member;
    private MembershipPlan plan;
    private MembershipStatus status;

    Membership(
        Member member,
        MembershipPlan plan
    ) {
        this.member = member;
        this.plan = plan;
        this.status = MembershipStatus.ACTIVE;
    }

    void checkIn() {

        if (status == MembershipStatus.ACTIVE) {

            System.out.println(
                member.getName() +
                " checked in successfully."
            );

        } else {

            System.out.println(
                "Check-in denied: " +
                member.getName() +
                "'s membership is " +
                status + "."
            );
        }
    }

    void freeze() {

        if (status == MembershipStatus.ACTIVE) {

            status = MembershipStatus.FROZEN;

            System.out.println(
                member.getName() +
                "'s membership frozen."
            );

            System.out.println(
                "Status: " + status
            );

        } else {

            System.out.println(
                "Cannot freeze an " +
                status +
                " membership."
            );
        }
    }

    void unfreeze() {

        if (status == MembershipStatus.FROZEN) {

            status = MembershipStatus.ACTIVE;

            System.out.println(
                member.getName() +
                "'s membership unfrozen."
            );

        } else {

            System.out.println(
                "Cannot unfreeze an " +
                status +
                " membership."
            );
        }
    }

    void expire() {

        if (status == MembershipStatus.EXPIRED) {
            return;
        }

        status = MembershipStatus.EXPIRED;

        System.out.println(
            member.getName() +
            "'s membership expired."
        );

        System.out.println(
            "Status: " + status
        );
    }

    MembershipStatus getStatus() {
        return status;
    }

    double getFee() {
        return plan.calculateFee();
    }

    String getPlanName() {
        return plan.getPlanName();
    }
}

public class M4 {

    public static void main(String[] args) {

        Member asha =
            new Member("Asha");

        Member ravi =
            new Member("Ravi");

        Membership ashaMembership =
            new Membership(
                asha,
                new QuarterlyPlan()
            );

        Membership raviMembership =
            new Membership(
                ravi,
                new MonthlyPlan()
            );

        System.out.printf(
            "Quarterly membership created for Asha. Fee: ₹%.2f. Status: %s%n",
            ashaMembership.getFee(),
            ashaMembership.getStatus()
        );

        System.out.printf(
            "Monthly membership created for Ravi. Fee: ₹%.2f. Status: %s%n",
            raviMembership.getFee(),
            raviMembership.getStatus()
        );

        ashaMembership.checkIn();

        ashaMembership.freeze();

        ashaMembership.checkIn();

        raviMembership.expire();

        raviMembership.freeze();
    }
}