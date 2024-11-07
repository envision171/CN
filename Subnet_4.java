import java.util.Scanner;

public class Subnet_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter IP Address (e.g., 192.168.10.0): ");
        String ipAddress = sc.nextLine();

        System.out.println("IP Address: " + ipAddress);
        System.out.println("Class: " + getClass(ipAddress));

        System.out.println("Enter number of CIDR bits: ");
        int cidr = sc.nextInt();

        calculateSubnet(cidr);
    }

    // Function to calculate subnets based on CIDR
    static void calculateSubnet(int cidr) {
        // Validate CIDR range (0-32)
        if (cidr < 0 || cidr > 32) {
            System.out.println("Enter valid CIDR bits (0-32).");
            return;
        }

        int numberOfOnesInLastOctet = (cidr > 24) ? cidr - 24 : 0;
        int numberOfZeroesInLastOctet = 8 - numberOfOnesInLastOctet;

        // Calculate the number of subnets and IP addresses per subnet
        int totalNumberOfNetworks = (int) Math.pow(2, numberOfOnesInLastOctet);
        int totalNumberOfIPAddress = (int) Math.pow(2, numberOfZeroesInLastOctet);
        int numberOfHostAddressPerNetwork = totalNumberOfIPAddress - 2;  // Subtracting 2 for network and broadcast addresses

        System.out.println("Total number of networks: " + totalNumberOfNetworks);
        System.out.println("Total number of IP addresses per network: " + totalNumberOfIPAddress);
        System.out.println("Total number of usable Host addresses per network: " + numberOfHostAddressPerNetwork);
    }

    // Function to get the class of the IP address
    static String getClass(String ipAddress) {
        String[] octets = ipAddress.split("\\.");

        // Validate if the IP address is correctly formatted (numbers between 0 and 255)
        for (String octet : octets) {
            try {
                int validBits = Integer.parseInt(octet);
                if (validBits < 0 || validBits > 255) {
                    return "Enter valid IP Address (each octet should be between 0 and 255)";
                }
            } catch (NumberFormatException e) {
                return "Enter valid IP Address (non-numeric value found)";
            }
        }

        int firstOctet = Integer.parseInt(octets[0]);

        // Class determination based on the first octet of the IP address
        if (firstOctet >= 1 && firstOctet <= 126) {
            return "Class A";
        } else if (firstOctet >= 128 && firstOctet <= 191) {
            return "Class B";
        } else if (firstOctet >= 192 && firstOctet <= 223) {
            return "Class C";
        } else if (firstOctet >= 224 && firstOctet <= 239) {
            return "Class D (Multicast)";
        } else if (firstOctet >= 240 && firstOctet <= 255) {
            return "Class E (Reserved for future use)";
        } else if (firstOctet == 127) {
            return "Loopback Address (127.0.0.0/8)";
        } else {
            return "Invalid IP Address";
        }
    }
}
