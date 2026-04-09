import java.util.*;
import java.util.stream.*;

// Goods Bogie Class
class GoodsBogie {
    String id;
    String shape;   // Cylindrical / Rectangular
    String cargo;   // Oil, Gas, Coal, etc.

    public GoodsBogie(String id, String shape, String cargo) {
        this.id = id;
        this.shape = shape;
        this.cargo = cargo;
    }
}

// Train Class
class Train {
    List<GoodsBogie> goodsList = new ArrayList<>();

    // Add Goods Bogie
    void addGoodsBogie(String id, String shape, String cargo) {
        goodsList.add(new GoodsBogie(id, shape, cargo));
    }

    // Safety Check using Streams
    void checkSafety() {
        List<GoodsBogie> unsafe = goodsList.stream()
                .filter(b ->
                        (b.shape.equalsIgnoreCase("Cylindrical") &&
                         !(b.cargo.equalsIgnoreCase("Oil") || b.cargo.equalsIgnoreCase("Gas")))
                        ||
                        (b.shape.equalsIgnoreCase("Rectangular") &&
                         (b.cargo.equalsIgnoreCase("Oil") || b.cargo.equalsIgnoreCase("Gas")))
                )
                .collect(Collectors.toList());

        if (unsafe.isEmpty()) {
            System.out.println("✅ All bogies are SAFE.");
        } else {
            System.out.println("❌ Unsafe Bogies Detected:");
            unsafe.forEach(b -> System.out.println(
                    "ID: " + b.id +
                    ", Shape: " + b.shape +
                    ", Cargo: " + b.cargo
            ));
        }
    }
}

// Main Class
public class TrainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Train train = new Train();

        while (true) {
            System.out.println("\n--- UC12 Menu ---");
            System.out.println("1. Add Goods Bogie");
            System.out.println("2. Check Safety Compliance");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Shape (Cylindrical/Rectangular): ");
                    String shape = sc.nextLine();
                    System.out.print("Enter Cargo (Oil/Gas/Coal/etc): ");
                    String cargo = sc.nextLine();

                    train.addGoodsBogie(id, shape, cargo);
                    break;

                case 2:
                    train.checkSafety();
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