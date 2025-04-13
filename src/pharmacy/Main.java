package pharmacy;

import pharmacy.Medicine;
import pharmacy.Pharmacy;
import pharmacy.enums.Gender;
import pharmacy.enums.Position;
import pharmacy.interfaces.PharmacyService;
import pharmacy.service.EmployeeServiceImpl;
import pharmacy.service.MedicineServiceImpl;
import pharmacy.service.PharmacyServiceImpl;
import pharmacy.Employee;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PharmacyService pharmacyService = new PharmacyServiceImpl();
        MedicineServiceImpl medicineService = new MedicineServiceImpl();
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

        while (true) {
            System.out.println("\n===== PHARMACY SYSTEM MENU =====");
            System.out.println("1. Create pharmacy");
            System.out.println("2. View pharmacy by ID");
            System.out.println("3. Update pharmacy");
            System.out.println("4. Delete pharmacy");
            System.out.println("5. Add medicine to pharmacy");
            System.out.println("6. View all medicines");
            System.out.println("7. Create employee");
            System.out.println("8. View employee by ID");
            System.out.println("9. Update employee");
            System.out.println("10. Delete employee");
            System.out.println("11. Assign employee to pharmacy");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter pharmacy name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();

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

                    System.out.print("Enter expiration year (e.g., 2025): ");
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

                case 7 -> {
                    System.out.print("Enter full name: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter experience (years): ");
                    int experience = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter position: ADMIN,\n" +
                                     "    PHARMACIST,\n" +
                                     "    TELLER;");
                    String position = scanner.nextLine().toUpperCase();
                    System.out.print("Enter gender (MALE/FEMALE): ");
                    String gender = scanner.nextLine().toUpperCase();

                    Employee employee = new Employee();
                    employee.setFullName(fullName);
                    employee.setEmail(email);
                    employee.setPhoneNumber(phoneNumber);
                    employee.setExperience(experience);
                    employee.setPosition(Position.valueOf(position));
                    employee.setGender(Gender.valueOf(gender));

                    employeeService.createEmployee(employee);
                }

                case 8 -> {
                    System.out.print("Enter employee ID: ");
                    Long id = scanner.nextLong();
                    Employee emp = employeeService.getEmployeeById(id);
                    if (emp != null) {
                        System.out.println(emp);
                    }
                }

                case 9 -> {
                    System.out.print("Enter employee ID to update: ");
                    Long id = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Enter new full name: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Enter new email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter new experience (years): ");
                    int experience = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new position: ");
                    String position = scanner.nextLine().toUpperCase();
                    System.out.print("Enter new gender (MALE/FEMALE): ");
                    String gender = scanner.nextLine().toUpperCase();

                    Employee updated = new Employee();
                    updated.setFullName(fullName);
                    updated.setEmail(email);
                    updated.setPhoneNumber(phoneNumber);
                    updated.setExperience(experience);
                    updated.setPosition(Position.valueOf(position));
                    updated.setGender(Gender.valueOf(gender));

                    employeeService.updateEmployee(id, updated);
                }

                case 10 -> {
                    System.out.print("Enter employee ID to delete: ");
                    Long id = scanner.nextLong();
                    employeeService.deleteEmployee(id);
                }

                case 11 -> {
                    System.out.print("Enter employee ID: ");
                    Long employeeId = scanner.nextLong();
                    System.out.print("Enter pharmacy ID: ");
                    Long pharmacyId = scanner.nextLong();
                    employeeService.assignEmployeeToPharmacy(employeeId, pharmacyId);
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
