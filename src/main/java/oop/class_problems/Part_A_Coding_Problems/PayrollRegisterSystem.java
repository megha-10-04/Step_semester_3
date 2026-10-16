
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Payslip {
    String name;
    String type;
    double pay;

    Payslip(String name, String type, double pay) {
        this.name = name;
        this.type = type;
        this.pay = pay;
    }

    @Override
    public String toString() {
        return "Payslip[name=" + name + ", type=" + type
                + ", pay=" + formatPay(pay) + "]";
    }

    static String formatPay(double pay) {
        if (pay == (long) pay) {
            return String.valueOf((long) pay);
        }
        return String.valueOf(pay);
    }
}

public class PayrollRegisterSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Payslip> list = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+");
            String type = parts[0];
            String name = parts[1];
            double pay;

            switch (type) {
                case "FullTime":
                    pay = Double.parseDouble(parts[2]);
                    break;

                case "PartTime":
                    double hours = Double.parseDouble(parts[2]);
                    double rate = Double.parseDouble(parts[3]);
                    pay = hours * rate;
                    break;

                case "Intern":
                    pay = Double.parseDouble(parts[2]);
                    break;

                default:
                    continue;
            }

            list.add(new Payslip(name, type, pay));
        }

        Payslip[] payslips = list.toArray(new Payslip[0]);

        double total = 0;
        Payslip topper = null;

        for (Payslip payslip : payslips) {
            System.out.println(payslip);
            total += payslip.pay;

            if (topper == null || payslip.pay > topper.pay) {
                topper = payslip;
            }
        }

        System.out.println("Total " + Payslip.formatPay(total));

        if (topper != null) {
            System.out.println("top earner " + topper.name);
        }

        sc.close();
    }
}
