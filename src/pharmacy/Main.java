package pharmacy;

import pharmacy.Medicine;
import pharmacy.Pharmacy;
import pharmacy.interfaces.PharmacyService;

import pharmacy.service.MedicineServiceImpl;
import pharmacy.service.PharmacyServiceImpl;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PharmacyService pharmacyService = new PharmacyServiceImpl();
        MedicineServiceImpl medicineService = new MedicineServiceImpl();

        while (true) {
            System.out.println("\n===== PHARMACY SYSTEM MENU =====");
            System.out.println("1. Create pharmacy");
            System.out.println("2. View pharmacy by ID");
            System.out.println("3. Update pharmacy");
            System.out.println("4. Delete pharmacy");
            System.out.println("5. Add medicine to pharmacy");
            System.out.println("6. View all medicines");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter pharmacy name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();

                    Pharmacy pharmacy = new Pharmacy();
                    pharmacy.setName(name);
                    pharmacy.setAddress(address);
                    pharmacyService.createPharmacy(pharmacy);
                }

                case 2 -> {
                    System.out.print("Enter pharmacy ID: ");
                    Long id = scanner.nextLong();
                    Pharmacy pharmacy = pharmacyService.getPharmacyById(id);
                    if (pharmacy != null) {
                        System.out.println(pharmacy);
                    }
                }

                case 3 -> {
                    System.out.print("Enter pharmacy ID to update: ");
                    Long id = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Enter new name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter new address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    String phone = scanner.nextLine();

                    Pharmacy updated = new Pharmacy();
                    updated.setName(name);
                    updated.setAddress(address);

                    pharmacyService.updatePharmacy(id, updated);
                }

                case 4 -> {
                    System.out.print("Enter pharmacy ID to delete: ");
                    Long id = scanner.nextLong();
                    pharmacyService.deletePharmacy(id);
                }

                case 5 -> {
                    System.out.print("Enter pharmacy ID to add medicine to: ");
                    Long pharmacyId = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Enter medicine name: ");
                    String medName = scanner.nextLine();

                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();

                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();

                    scanner.nextLine(); // consume newline
                    System.out.print("Enter expiration year (2025): ");
                    int year = scanner.nextInt();
                    System.out.print("Enter expiration month: ");
                    int month = scanner.nextInt();
                    System.out.print("Enter expiration day: ");
                    int day = scanner.nextInt();

                    Medicine medicine = new Medicine();
                    medicine.setName(medName);
                    medicine.setPrice(price);
                    medicine.setExpirationDate(LocalDate.of(year, month, day));

                    medicineService.createMedicine(medicine, pharmacyId);
                }

                case 6 -> {
                    System.out.println("All medicines:");
                    for (Medicine m : medicineService.getAllMedicines()) {
                        System.out.println(m);
                    }
                }

                case 0 -> {
                    System.out.println("Exiting... Goodbye!");
                    return;
                }

                default -> System.out.println("Invalid option. Try again!");
            }
        }
    }
}
