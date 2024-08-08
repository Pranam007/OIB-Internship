import java.util.Scanner;

class ReservationSystem {
    Scanner sc = new Scanner(System.in);

    boolean verifyStatus = false;
    private final String[] verifiedUsers = { "Pranam", "Rohang", "Prem", "Divy", "Neer" };
    private final String[] verifiedPass = { "phb@123", "rhs@321", "ppn@345", "dmp@543", "np@567" };

    private final String[] train = { "Train_1", "Train_2", "Train_3", "Train_4", "Train_5" };
    private final int[] trainNo = { 12345, 23456, 34567, 45678, 56789 };
    private final String[] traintype = { "Second Class", "Sleeper class-AC", "First Class", "Sleeper Class-AC",
            "Sleeper Class-Non-AC" };
    private final String[] dateOfJourney = { "25/07/2024", "27/07/2024", "01/08/2024", "03/08/2024", "03/08/2024" };
    private final String[] Source = { "Palnpur", "Surat", "Delhi", "Mumbai", "Ahmedabad" };
    private final String[] Destination = { "Surat", "Ahmedabad", "Rajkot", "Jaipur", "Goa" };
    private final String[] PNRnumber = { "25-6-T1-12345", "27-6-T2-23456", "01-7-T3-34567", "03-7-T4-45678",
            "03-7-T5-56789" };

    public void verify() {
        System.out.println("******************************");
        System.out.println("       LOGIN VERIFICATION     ");
        System.out.println("******************************");
        System.out.print("Enter Your Login ID: ");
        String login_ID = sc.nextLine();

        System.out.print("Enter Password : ");
        String password = sc.nextLine();
        sc.nextLine(); // Consume newline left-over

        for (int i = 0; i < verifiedUsers.length; i++) {
            if (login_ID.equalsIgnoreCase(verifiedUsers[i])) {
                if (password.equals(verifiedPass[i])) {
                    System.out.println("Logged In");
                    verifyStatus = true;
                    return;
                } else {
                    System.out.println("Invalid Password. Please try again.");
                    return;
                }
            }
        }
        System.out.println("Invalid Login ID. Please try again.");
    }

    public void reservationForm() {
        if (verifyStatus) {
            System.out.println("******************************");
            System.out.println("       RESERVATION FORM       ");
            System.out.println("******************************");
            System.out.print("Enter Number of the train: ");
            int trainNum = sc.nextInt();
            sc.nextLine(); // Consume newline left-over
            int trIndex = -1;
            for (int i = 0; i < train.length; i++) {
                if (trainNum == trainNo[i]) {
                    trIndex = i;
                    System.out.println("\nTrain Details:");
                    System.out.println("Train Name:      \t" + train[i]);
                    System.out.println("Class Type:      \t" + traintype[i]);
                    System.out.println("Date Of Journey: \t" + dateOfJourney[i]);
                    System.out.println("Source:          \t" + Source[i]);
                    System.out.println("Destination:     \t" + Destination[i]);
                    break;
                }
            }
            if (trIndex == -1) {
                System.out.println("Invalid train number.");
                return;
            }

            System.out.print("\nPress Y to confirm booking\n");
            System.out.print("Press N to Exit\n");

            String res = sc.nextLine();

            if (res.equalsIgnoreCase("Y")) {
                System.out.println("Booking Confirmed");
                System.out.println("Your PNR number is " + PNRnumber[trIndex]);
                System.out.println("*********************************");
            } else if (res.equalsIgnoreCase("N")) {
                System.out.println("Exit.");
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }

        } else {
            System.out.println("Please Complete Verification Again");
        }
    }

    public void cancellationForm() {
        if (!verifyStatus) {
            System.out.println("Please Complete Verification Again");
            return;
        }

        System.out.println("******************************");
        System.out.println("       CANCELLATION FORM      ");
        System.out.println("******************************");
        System.out.print("Enter your PNR Number: ");
        String user_PNR = sc.nextLine();
        int pnrIndex = -1;
        for (int i = 0; i < PNRnumber.length; i++) {
            if (user_PNR.equalsIgnoreCase(PNRnumber[i])) {
                pnrIndex = i;
                System.out.println("\nBooking Details:");
                System.out.println("PNR Number:      \t" + user_PNR);
                System.out.println("Train Name:      \t" + train[i]);
                System.out.println("Class Type:      \t" + traintype[i]);
                System.out.println("Date Of Journey: \t" + dateOfJourney[i]);
                System.out.println("Source:          \t" + Source[i]);
                System.out.println("Destination:     \t" + Destination[i]);
                break;
            }
        }

        if (pnrIndex == -1) {
            System.out.println("Invalid PNR number.");
            return;
        }

        System.out.print("\nPress Y to cancel\n");
        System.out.print("Press N to Exit\n");
        String res = sc.nextLine();

        if (res.equalsIgnoreCase("Y")) {
            System.out.println("Booking Cancelled");
            System.out.println("*****************");
        } else if (res.equalsIgnoreCase("N")) {
            System.out.println("EXIT.");
        } else {
            System.out.println("Invalid input. Please enter Y or N.");
        }
    }
}

public class ORS {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        ReservationSystem rs = new ReservationSystem();
        rs.verify();

        int c;
        do {
            System.out.println("\n******************************");
            System.out.println("       RESERVATION MENU       ");
            System.out.println("******************************");
            System.out.println("Enter 0 to EXIT");
            System.out.println("Enter 1 for Reservation Form");
            System.out.println("Enter 2 for Cancellation Form");

            c = 0;
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline left-over
            switch (choice) {
                case 0:
                    c = 1;
                    break;
                case 1:
                    rs.reservationForm();
                    break;
                case 2:
                    rs.cancellationForm();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 0, 1, or 2.");
                    break;
            }

        } while (c != 1);
    }
}
