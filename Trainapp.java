import java.util.*;

abstract class Bogie {
    String id;

    public Bogie(String id) {
        this.id = id;
    }

    abstract void display();
}

class PassengerBogie extends Bogie {
    String type;
    int capacity;
    int occupied;

    public PassengerBogie(String id, String type, int capacity) {
        super(id);
        this.type = type;
        this.capacity = capacity;
        this.occupied = 0;
    }

    void bookSeats(int seats) {
        if (occupied + seats <= capacity) {
            occupied += seats;
            System.out.println("Seats booked successfully!");
        } else {
            System.out.println("Not enough seats available!");
        }
    }

    @Override
    void display() {
        System.out.println("Passenger Bogie ID: " + id +
                ", Type: " + type +
                ", Capacity: " + capacity +
                ", Occupied: " + occupied);
    }
}

// Goods Bogie
class GoodsBogie extends Bogie {
    String shape;
    String cargoType;

    public GoodsBogie(String id, String shape, String cargoType) {
        super(id);
        this.shape = shape;
        this.cargoType = cargoType;
    }

    boolean isSafe() {
        if (cargoType.equalsIgnoreCase("Hazardous") && shape.equalsIgnoreCase("Rectangular")) {
            return false;
        }
        return true;
    }

    @Override
    void display() {
        System.out.println("Goods Bogie ID: " + id +
                ", Shape: " + shape +
                ", Cargo: " + cargoType +
                ", Safe: " + (isSafe() ? "Yes" : "No"));
    }
}

// Train Class
class Train {
    List<Bogie> consist = new ArrayList<>();

    void addBogie(Bogie b) {
        consist.add(b);
        System.out.println("Bogie added!");
    }

    void removeBogie(String id) {
        consist.removeIf(b -> b.id.equals(id));
        System.out.println("Bogie removed if existed.");
    }

    void displayTrain() {
        if (consist.isEmpty()) {
            System.out.println("Train is empty!");
            return;
        }
        for (Bogie b : consist) {
            b.display();
        }
    }

    void totalPassengerCapacity() {
        int total = 0;
        for (Bogie b : consist) {
            if (b instanceof PassengerBogie) {
                total += ((PassengerBogie) b).capacity;
            }
        }
        System.out.println("Total Passenger Capacity: " + total);
    }
}

// Main Class
public class Trainapp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Train train = new Train();

        while (true) {
            System.out.println("\n--- Train Consist Menu ---");
            System.out.println("1. Add Passenger Bogie");
            System.out.println("2. Add Goods Bogie");
            System.out.println("3. Remove Bogie");
            System.out.println("4. Display Train");
            System.out.println("5. Total Passenger Capacity");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter ID: ");
                    String pid = sc.nextLine();
                    System.out.print("Enter Type (Sleeper/AC/First): ");
                    String type = sc.nextLine();
                    System.out.print("Enter Capacity: ");
                    int cap = sc.nextInt();
                    train.addBogie(new PassengerBogie(pid, type, cap));
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    String gid = sc.nextLine();
                    System.out.print("Enter Shape (Rectangular/Cylindrical): ");
                    String shape = sc.nextLine();
                    System.out.print("Enter Cargo Type: ");
                    String cargo = sc.nextLine();
                    train.addBogie(new GoodsBogie(gid, shape, cargo));
                    break;

                case 3:
                    System.out.print("Enter Bogie ID to remove: ");
                    String rid = sc.nextLine();
                    train.removeBogie(rid);
                    break;

                case 4:
                    train.displayTrain();
                    break;

                case 5:
                    train.totalPassengerCapacity();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}