import java.util.*;

// Bogie Class
class Bogie {
    String id;
    String type;
    int capacity;

    public Bogie(String id, String type, int capacity) {
        this.id = id;
        this.type = type;
        this.capacity = capacity;
    }
}

// Train Class
class Train {
    List<Bogie> bogies = new ArrayList<>();

    // Add Bogie
    void addBogie(String id, String type, int capacity) {
        bogies.add(new Bogie(id, type, capacity));
    }

    // Calculate Total Seats using reduce()
    void totalCapacity() {
        int total = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, (sum, cap) -> sum + cap);

        System.out.println("🚆 Total Train Capacity: " + total);
    }
}

// Main Class
public class TrainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Train train = new Train();

        while (true) {
            System.out.println("\n--- UC10 Menu ---");
            System.out.println("1. Add Bogie");
            System.out.println("2. Total Capacity");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Type: ");
                    String type = sc.nextLine();
                    System.out.print("Enter Capacity: ");
                    int cap = sc.nextInt();
                    train.addBogie(id, type, cap);
                    break;

                case 2:
                    train.totalCapacity();
                    break;

                case 3:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}