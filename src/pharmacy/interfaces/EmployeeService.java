package pharmacy.interfaces;

import pharmacy.Employee;

public interface EmployeeService {
    void createEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    void updateEmployee(Long id, Employee updatedEmployee);
    void deleteEmployee(Long id);
    void assignEmployeeToPharmacy(Long employeeId, Long pharmacyId);
}
