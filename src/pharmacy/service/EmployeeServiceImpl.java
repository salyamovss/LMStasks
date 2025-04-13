package pharmacy.service;

import pharmacy.Database;
import pharmacy.Employee;
import pharmacy.Pharmacy;
import pharmacy.exceptions.MyException;
import pharmacy.interfaces.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

    private final Database dataBase = Database.getInstance();
    private static long employeeIdCounter = 1;

    @Override
    public void createEmployee(Employee employee) {
        try {
            for (Employee emp : dataBase.getEmployees()) {
                if (emp.getEmail().equalsIgnoreCase(employee.getEmail())) {
                    throw new RuntimeException("Email already exists!");
                }
            }
            employee.setUniqueID(employeeIdCounter++);
            dataBase.getEmployees().add(employee);
            System.out.println("Employee created successfully!");
        } catch (MyException e) {
            System.out.println("Error while creating employee: " + e.getMessage());
        }
    }

    @Override
    public Employee getEmployeeById(Long id) {
        try {
            for (Employee emp : dataBase.getEmployees()) {
                if (emp.getUniqueID()==(id)) {
                    return emp;
                }
            }
            throw new RuntimeException("Employee not found!");
        } catch (MyException e) {
            System.out.println("Error while getting employee: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void updateEmployee(Long id, Employee updatedEmployee) {
        try {
            Employee existing = getEmployeeById(id);
            if (existing != null) {
                existing.setFullName(updatedEmployee.getFullName());
                existing.setEmail(updatedEmployee.getEmail());
                existing.setPhoneNumber(updatedEmployee.getPhoneNumber());
                existing.setExperience(updatedEmployee.getExperience());
                existing.setPosition(updatedEmployee.getPosition());
                existing.setGender(updatedEmployee.getGender());
                System.out.println("Employee updated successfully!");
            }
        } catch (MyException e) {
            System.out.println("Error while updating employee: " + e.getMessage());
        }
    }

    @Override
    public void deleteEmployee(Long id) {
        try {
            Employee emp = getEmployeeById(id);
            if (emp != null) {
                dataBase.getEmployees().remove(emp);
                System.out.println("Employee deleted.");
            }
        } catch (MyException e) {
            System.out.println("Error while deleting employee: " + e.getMessage());
        }
    }

    @Override
    public void assignEmployeeToPharmacy(Long employeeId, Long pharmacyId) {
        try {
            Employee employee = getEmployeeById(employeeId);
            Pharmacy pharmacy = null;
            for (Pharmacy p : dataBase.getPharmacies()) {
                if (p.getUniqueID() == (pharmacyId)) {
                    pharmacy = p;
                    break;
                }
            }

            if (pharmacy == null) throw new RuntimeException("Pharmacy not found!");

            pharmacy.getEmployeeList().add(employee);
            System.out.println("Employee assigned to pharmacy!");
        } catch (MyException e) {
            System.out.println("Error while assigning employee: " + e.getMessage());
        }
    }
}
