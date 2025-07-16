import java.io.*;
import java.util.*;

    class Client {
        private String name;
        private String phone;
        private String email;
        private String address;
        private String serviceType;
        private Date createdAt;

        public Client(String name, String phone, String email, String address, String serviceType) {
            this.name = name;
            this.phone = phone;
            this.email = email;
            this.address = address;
            this.serviceType = serviceType;
            this.createdAt = new Date();
        }

        public String toCSV() {
            return String.join(",", name, phone, email, address, serviceType, createdAt.toString());
        }

        public static Client fromCSV(String line) {
            String[] parts = line.split(",");
            Client c = new Client(parts[0], parts[1], parts[2], parts[3], parts[4]);
            return c;
        }

        public void printInfo() {
            System.out.println("==============================");
            System.out.println("Name       : " + name);
            System.out.println("Phone      : " + phone);
            System.out.println("Email      : " + email);
            System.out.println("Address    : " + address);
            System.out.println("Service    : " + serviceType);
            System.out.println("Created at : " + createdAt);
        }
    }

    public class HandymanCRM {
        private static final String FILE_NAME = "clients.csv";
        private static List<Client> clients = new ArrayList<>();
        private static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            loadClients();
            while (true) {
                printMenu();
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        addClient();
                        break;
                    case "2":
                        listClients();
                        break;
                    case "3":
                        exportCSV();
                        break;
                    case "0":
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            }
        }

        private static void printMenu() {
            System.out.println("\n--- Handyman CRM Menu ---");
            System.out.println("1. Add new client");
            System.out.println("2. List all clients");
            System.out.println("3. Export to CSV");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
        }

        private static void addClient() {
            System.out.print("Enter client name: ");
            String name = scanner.nextLine();
            System.out.print("Enter phone number: ");
            String phone = scanner.nextLine();
            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            System.out.print("Enter address: ");
            String address = scanner.nextLine();
            System.out.print("Type of service (plumbing, electric, etc.): ");
            String service = scanner.nextLine();

            Client client = new Client(name, phone, email, address, service);
            clients.add(client);
            System.out.println("✅ Client added successfully!");
        }

        private static void listClients() {
            if (clients.isEmpty()) {
                System.out.println("No clients yet.");
                return;
            }
            for (Client client : clients) {
                client.printInfo();
            }
        }

        private static void exportCSV() {
            try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
                for (Client c : clients) {
                    pw.println(c.toCSV());
                }
                System.out.println("✅ Exported to " + FILE_NAME);
            } catch (IOException e) {
                System.out.println("❌ Error writing CSV: " + e.getMessage());
            }
        }

        private static void loadClients() {
            try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
                String line;
                while ((line = br.readLine()) != null) {
                    clients.add(Client.fromCSV(line));
                }
                System.out.println("🔄 Loaded " + clients.size() + " clients from file.");
            } catch (IOException e) {
                System.out.println("📂 No existing client file found.");
            }
        }
    }

