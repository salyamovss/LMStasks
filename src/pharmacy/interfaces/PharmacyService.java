package pharmacy.interfaces;

import pharmacy.Employee;
import pharmacy.Medicine;
import pharmacy.Pharmacy;

import java.util.List;

public interface PharmacyService {
    void createPharmacy(Pharmacy pharmacy);
    Pharmacy getPharmacyById(Long id);
    void updatePharmacy(Long id, Pharmacy updatedPharmacy);
    void deletePharmacy(Long id);
    List<Employee> getEmployeesByPharmacy(Long pharmacyId);
    List<Medicine> getMedicinesByPharmacy(Long pharmacyId);
}
