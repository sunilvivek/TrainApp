
import java.util.*;

// Passenger Bogie Class
class PassengerBogie {
    String id;
    String type;
    int capacity;

    public PassengerBogie(String id, String type, int capacity) {
        this.id = id;
        this.type = type;
        this.capacity = capacity;
    }

    void display() {
        System.out.println("ID: " + id +
                ", Type: " + type +
                ", Capacity: " + capacity);
    }
}

// Train Class using Set + List
class Train {
    ArrayList<PassengerBogie> bogies = new ArrayList<>();
    HashSet<String> bogieIds = new HashSet<>();

    // Add Bogie 
    void addBogie(PassengerBogie b) {
        if (!bogieIds.add(b.id)) { 
            System.out.println("❌ Duplicate Bogie ID! Not allowed.");
            return;
        }

        bogies.add(b);
        System.out.println("✅ Bogie added successfully!");
    }

    // Remove Bogie
    void removeBogie(String id) {
        boolean found = false;

        Iterator<PassengerBogie> it = bogies.iterator();
        while (it.hasNext()) {
            PassengerBogie b = it.next();
            if (b.id.equals(id)) {
                it.remove();
                bogieIds.remove(id);
                found = true;
                System.out.println("✅ Bogie removed successfully!");
                break;
            }
        }

        if (!found) {
            System.out.println("❌ Bogie not found!");
        }
    }

    // Check Bogie Exists
    void checkBogie(String id) {
        if (bogieIds.contains(id)) {
            System.out.println("✅ Bogie exists in train.");
        } else {
            System.out.println("❌ Bogie does not exist.");
        }
    }

    // Display All
    void displayAll() {
        if (bogies.isEmpty()) {
            System.out.println("No bogies in train!");
            return;
        }

        for (PassengerBogie b : bogies) {
            b.display();
        }
    }
}

// Main Class
public class Trainapp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Train train = new Train();

        while (true) {
            System.out.println("\n--- UC3 Menu ---");
            System.out.println("1. Add Bogie");
            System.out.println("2. Remove Bogie");
            System.out.println("3. Check Bogie");
            System.out.println("4. Display All");
            System.out.println("5. Exit");
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

                    train.addBogie(new PassengerBogie(id, type, cap));
                    break;

                case 2:
                    System.out.print("Enter ID to remove: ");
                    train.removeBogie(sc.nextLine());
                    break;

                case 3:
                    System.out.print("Enter ID to check: ");
                    train.checkBogie(sc.nextLine());
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