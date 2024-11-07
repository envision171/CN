import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class DNSLookup {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter '1' to lookup hostname by IP or '2' to lookup IP by hostname (or 'exit' to quit): ");
        while (true) {
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the program.");
                break;
            }

            if (choice.equals("1")) {
                System.out.print("Enter IP address: ");
                String ipAddress = scanner.nextLine();
                lookupHostname(ipAddress);
            } else if (choice.equals("2")) {
                System.out.print("Enter hostname: ");
                String hostname = scanner.nextLine();
                lookupIpAddress(hostname);
            } else {
                System.out.println("Invalid choice. Please enter '1' or '2'.");
            }
        }

        scanner.close();
    }

    private static void lookupHostname(String ipAddress) {
        try {
            InetAddress inetAddress = InetAddress.getByName(ipAddress);
            System.out.println("Hostname for IP " + ipAddress + " is: " + inetAddress.getHostName());
        } catch (UnknownHostException e) {
            System.out.println("Unable to find hostname for IP: " + ipAddress);
        }
    }

    private static void lookupIpAddress(String hostname) {
        try {
            InetAddress inetAddress = InetAddress.getByName(hostname);
            System.out.println("IP Address for " + hostname + " is: " + inetAddress.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("Unable to find IP address for hostname: " + hostname);
        }
    }
}
