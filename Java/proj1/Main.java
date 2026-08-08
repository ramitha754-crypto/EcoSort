import java.util.ArrayList;
import java.util.Scanner;

class Waste {
    String name;
    String type;
    double weight;

    Waste(String name, String type, double weight) {
        this.name = name;
        this.type = type;
        this.weight = weight;
    }

    void display() {
        System.out.println("----------------------------");
        System.out.println("Waste Name : " + name);
        System.out.println("Waste Type : " + type);
        System.out.println("Weight     : " + weight + " kg");
    }
}

public class Main {

    static ArrayList<Waste> wasteList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addWaste() {
        System.out.print("Enter Waste Name: ");
        String name = sc.next();

        System.out.print("Enter Waste Type (Dry/Wet/Plastic/E-Waste): ");
        String type = sc.next();

        System.out.print("Enter Weight (kg): ");
        double weight = sc.nextDouble();

        wasteList.add(new Waste(name, type, weight));
        System.out.println("Waste Added Successfully.");
    }

    public static void viewWaste() {
        if (wasteList.isEmpty()) {
            System.out.println("No Waste Records Found.");
            return;
        }

        System.out.println("\nWaste Details");
        for (Waste w : wasteList) {
            w.display();
        }
    }

    public static void searchWaste() {
        System.out.print("Enter Waste Name to Search: ");
        String search = sc.next();

        boolean found = false;

        for (Waste w : wasteList) {
            if (w.name.equalsIgnoreCase(search)) {
                w.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Waste Record Not Found.");
        }
    }

    public static void deleteWaste() {
        System.out.print("Enter Waste Name to Delete: ");
        String del = sc.next();

        boolean found = false;

        for (int i = 0; i < wasteList.size(); i++) {
            if (wasteList.get(i).name.equalsIgnoreCase(del)) {
                wasteList.remove(i);
                found = true;
                System.out.println("Waste Record Deleted.");
                break;
            }
        }

        if (!found) {
            System.out.println("Waste Record Not Found.");
        }
    }

    public static void menu() {
        while (true) {
            System.out.println("\n===== SMART WASTE SEGREGATION MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Waste");
            System.out.println("2. View Waste");
            System.out.println("3. Search Waste");
            System.out.println("4. Delete Waste");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addWaste();
                    break;
                case 2:
                    viewWaste();
                    break;
                case 3:
                    searchWaste();
                    break;
                case 4:
                    deleteWaste();
                    break;
                case 5:
                    System.out.println("Thank You!");
                    return;
                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }

    public static void main(String[] args) {
        menu();
    }
}