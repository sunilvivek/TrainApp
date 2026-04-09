import java.util.*;

// Bogie Class
class Bogie {
    String id;
    int capacity;

    public Bogie(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }
}

// Comparator for sorting by capacity
class CapacityComparator implements Comparator<Bogie> {
    public int compare(Bogie b1, Bogie b2) {
        return b2.capacity - b1.capacity; 
    }
}

// Train Class
class Train {
    HashMap<String, Integer> bogieMap = new HashMap<>();

    void addBogie(String id, int capacity) {
        bogieMap.put(id, capacity);
    }

    void displaySorted() {
        List<Bogie> list = new ArrayList<>();

        // Convert map → list
        for (Map.Entry<String, Integer> entry : bogieMap.entrySet()) {
            list.add(new Bogie(entry.getKey(), entry.getValue()));
        }

        // Sort using Comparator
        Collections.sort(list, new CapacityComparator());

        System.out.println("🚆 Bogies sorted by capacity (High → Low):");
        for (Bogie b : list) {
            System.out.println("ID: " + b.id + ", Capacity: " + b.capacity);
        }
    }
}

// Main Class
public class TrainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Train train = new Train();

        while (true) {
            System.out.println("\n--- UC7 Menu ---");
            System.out.println("1. Add Bogie");
            System.out.println("2. Display Sorted Bogies");
            System.out.println("3. Exit");
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
                    train.displaySorted();
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