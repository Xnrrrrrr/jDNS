import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("DNS Lookup Options:");
            System.out.println("1. Hostname to IP Address");
            System.out.println("2. IP Address to Hostname");
            System.out.println("3. Exit");
            System.out.print("Choose an option (1/2/3): ");

            String input = scanner.nextLine();

            if (input.equals("3")) {
                break;
            } else if (!input.equals("1") && !input.equals("2")) {
                System.out.println("Invalid option. Please choose 1, 2, or 3.");
                continue;
            }

            System.out.print("Enter the " + (input.equals("1") ? "hostname" : "IP address") + ": ");
            String userInput = scanner.nextLine();

            try {
                if (input.equals("1")) {
                    InetAddress[] addresses = InetAddress.getAllByName(userInput);
                    System.out.println("IP Addresses for " + userInput + ":");
                    for (InetAddress address : addresses) {
                        System.out.println(address.getHostAddress());
                    }
                } else {
                    InetAddress address = InetAddress.getByName(userInput);
                    System.out.println("Hostname for " + userInput + ": " + address.getHostName());
                }
            } catch (UnknownHostException e) {
                System.err.println("Unable to resolve: " + userInput);
                e.printStackTrace();
            }

            System.out.println();
        }

        System.out.println("Exiting DNS Lookup program.");
        scanner.close();
    }
}
