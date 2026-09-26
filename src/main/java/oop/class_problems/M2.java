abstract class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }

    abstract boolean canTakeLeave(int days);
}

class FullTimeEmployee extends Employee {

    FullTimeEmployee(String name) {
        super(name);
    }

    boolean canTakeLeave(int days) {
        return days <= 20;
    }
}

class PartTimeEmployee extends Employee {

    PartTimeEmployee(String name) {
        super(name);
    }

    boolean canTakeLeave(int days) {
        return days <= 10;
    }
}

class Contractor extends Employee {

    Contractor(String name) {
        super(name);
    }

    boolean canTakeLeave(int days) {
        return days <= 5;
    }
}

enum LeaveStatus {
    PENDING,
    APPROVED,
    REJECTED
}

class LeaveRequest {

    Employee employee;
    String startDate;
    String endDate;
    int days;
    LeaveStatus status = LeaveStatus.PENDING;

    LeaveRequest(
        Employee employee,
        String startDate,
        String endDate,
        int days
    ) {
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.days = days;
    }

    void approve() {

        if (status != LeaveStatus.PENDING) {
            System.out.println(
                "Cannot approve request. Current status: " + status
            );
            return;
        }

        if (!employee.canTakeLeave(days)) {
            System.out.println(
                employee.name + " is not eligible for " + days + " days."
            );
            return;
        }

        status = LeaveStatus.APPROVED;

        System.out.println(
            employee.name + "'s leave request (" +
            startDate + "-" + endDate +
            ") approved. Status: " + status
        );
    }

    void reject() {

        if (status != LeaveStatus.PENDING) {
            System.out.println(
                "Cannot reject request. Current status: " + status
            );
            return;
        }

        status = LeaveStatus.REJECTED;

        System.out.println(
            employee.name + "'s leave request (" +
            startDate + "-" + endDate +
            ") rejected. Status: " + status
        );
    }

    void changeStatus(LeaveStatus newStatus) {

        if (status != LeaveStatus.PENDING) {
            System.out.println(
                "Cannot change leave request status from " +
                status + " to " + newStatus + "."
            );
            return;
        }

        status = newStatus;
    }
}

public class M2 {

    public static void main(String[] args) {

        Employee john = new FullTimeEmployee("John");
        Employee jane = new PartTimeEmployee("Jane");

        LeaveRequest request1 =
            new LeaveRequest(john, "Jan 1", "Jan 5", 5);

        System.out.println(
            "Leave request submitted for John (Jan 1-5). Status: "
            + request1.status
        );

        request1.approve();

        LeaveRequest request2 =
            new LeaveRequest(jane, "Feb 10", "Feb 11", 2);

        System.out.println(
            "Leave request submitted for Jane (Feb 10-11). Status: "
            + request2.status
        );

        request2.reject();

        request1.changeStatus(LeaveStatus.PENDING);
    }
}