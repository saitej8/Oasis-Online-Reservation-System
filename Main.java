package onlinereservationsystem;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int choice;
        while(true) {
            System.out.println("\n--- Online Reservation System ---");
            System.out.println("1. Make a Reservation");
            System.out.println("2. Cancel a Reservation");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline left by nextInt()

            switch (choice) {
                case 1:
                    // Make a reservation
                    System.out.println("\nEnter reservation details:");
                    System.out.print("Enter username: ");
                    String username = sc.nextLine();
                    System.out.print("Enter password: ");
                    String password = sc.nextLine();

                    Login login = new Login();
                    if (!login.validateLogin(username, password)) {
                        System.out.println("Invalid login credentials!");
                        break;
                    }
                    System.out.println("Login successful!");

                    System.out.print("Passenger Name: ");
                    String passengerName = sc.nextLine();
                    System.out.print("Train Number: ");
                    String trainNo = sc.nextLine();
                    System.out.print("Train Name: ");
                    String trainName = sc.nextLine();
                    System.out.print("Class Type: ");
                    String classType = sc.nextLine();
                    System.out.print("Journey Date (yyyy-mm-dd): ");
                    String date = sc.nextLine();
                    System.out.print("From Place: ");
                    String fromPlace = sc.nextLine();
                    System.out.print("To Place: ");
                    String toPlace = sc.nextLine();

                    Reservation reservation = new Reservation();
                    if (reservation.makeReservation(passengerName, trainNo, trainName, classType, date, fromPlace, toPlace)) {
                        System.out.println("Reservation successful!");
                    } else {
                        System.out.println("Reservation failed!");
                    }
                    break;

                case 2:
                    // Cancel a reservation
                    System.out.print("\nEnter PNR number to cancel reservation: ");
                    String pnrToCancel = sc.nextLine();
                    Cancellation cancellation = new Cancellation();
                    ReservationDetails reservationDetails = cancellation.getReservationByPNR(pnrToCancel);
                    if (reservationDetails != null) {
                        System.out.println("Reservation found for PNR: " + pnrToCancel);
                        System.out.println("Passenger Name: " + reservationDetails.getPassengerName());
                        System.out.print("Confirm cancellation? (yes/no): ");
                        String confirm = sc.nextLine();
                        if ("yes".equalsIgnoreCase(confirm)) {
                            if (cancellation.cancelReservation(pnrToCancel)) {
                                System.out.println("Reservation cancelled successfully!");
                            } else {
                                System.out.println("Cancellation failed!");
                            }
                        }
                    } else {
                        System.out.println("No reservation found for that PNR.");
                    }
                    break;

                case 3:
                    
                    System.out.println("Exiting the system. Goodbye!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please enter 1, 2, or 3.");
            }
        }
    }
}
