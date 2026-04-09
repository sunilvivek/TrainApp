import java.util.*;

// Train Class using HashMap
class Train {
    HashMap<String, Integer> bogieMap = new HashMap<>();

    // Add Bogie with Capacity
    void addBogie(String id, int capacity) {
        if (bogieMap.containsKey(id)) {
            System.out.println("❌ Bogie already exists!");
        } else {
            bogieMap.put(id, capacity);
            System.out.println("✅ Bogie added with capacity.");
        }
    }

    // Remove Bogie
    void removeBogie(String id) {
        if (bogieMap.remove(id) != null) {
            System.out.println("✅ Bogie removed.");
        } else {
            System.out.println("❌ Bogie not found.");
        }
    }

    // Get Capacity
    void getCapacity(String id) {
        if (bogieMap.containsKey(id)) {
            System.out.println("Capacity of " + id + " = " + bogieMap.get(id));
        } else {
            System.out.println("❌ Bogie not found.");
        }
    }

    // Display All Bogies
    void displayAll() {
        if (bogieMap.isEmpty()) {
            System.out.println("No bogies available!");
            return;
        }
System.out.println("just examp;le")
        System.out.println("🚆 Bogie Details:");
        for (Map.Entry<String, Integer> entry : bogieMap.entrySet()) {
            System.out.println("ID: " + entry.getKey() +
                    ", Capacity: " + entry.getValue());
                    
        }
    }
}

// Main Class
public class Trainapp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Train train = new Train();

        while (true) {
            System.out.println("\n--- UC6 Menu ---");
            System.out.println("1. Add Bogie");
            System.out.println("2. Remove Bogie");
            System.out.println("3. Get Capacity");
            System.out.println("4. Display All");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter Bogie ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Capacity: ");
                    int cap = sc.nextInt();
                    train.addBogie(id, cap);
                    break;

                case 2:
                    System.out.print("Enter Bogie ID: ");
                    train.removeBogie(sc.nextLine());
                    break;

                case 3:
                    System.out.print("Enter Bogie ID: ");
                    train.getCapacity(sc.nextLine());
                    break;

                case 4:
                    train.displayAll();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}