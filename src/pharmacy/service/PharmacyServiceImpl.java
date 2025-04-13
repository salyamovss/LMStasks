package pharmacy.service;

import pharmacy.Database;
import pharmacy.Employee;
import pharmacy.Medicine;
import pharmacy.Pharmacy;

import pharmacy.interfaces.PharmacyService;

import java.util.ArrayList;
import java.util.List;

public class PharmacyServiceImpl implements PharmacyService {

    private final Database dataBase = Database.getInstance();
    private static long pharmacyIdCounter = 1;

    @Override
    public void createPharmacy(Pharmacy pharmacy) {
        try {
            for (Pharmacy p : dataBase.getPharmacies()) {
                if (p.getName().equalsIgnoreCase(pharmacy.getName())) {
                    throw new RuntimeException("Pharmacy with this name already exists!");
                }
            }

            pharmacy.setUniqueID(pharmacyIdCounter++);

            if (pharmacy.getEmployeeList() == null) {
                pharmacy.setEmployeeList(new ArrayList<>());
            }
            if (pharmacy.getMedicines() == null) {
                pharmacy.setMedicines(new ArrayList<>());
            }

            dataBase.getPharmacies().add(pharmacy);
            System.out.println("Pharmacy created successfully!");
        } catch (Exception e) {
            System.out.println("Error while creating pharmacy: " + e.getMessage());
        }
    }

    @Override
    public Pharmacy getPharmacyById(Long id) {
        try {
            for (Pharmacy p : dataBase.getPharmacies()) {
                if (p.getUniqueID() == (id)) {
                    return p;
                }
            }
            throw new RuntimeException("Pharmacy not found!");
        } catch (Exception e) {
            System.out.println("Error while getting pharmacy: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void updatePharmacy(Long id, Pharmacy updatedPharmacy) {
        try {
            Pharmacy existing = getPharmacyById(id);
            if (existing != null) {
                existing.setName(updatedPharmacy.getName());
                existing.setAddress(updatedPharmacy.getAddress());
                System.out.println("Pharmacy updated successfully!");
            }
        } catch (Exception e) {
            System.out.println("Error while updating pharmacy: " + e.getMessage());
        }
    }

    @Override
    public void deletePharmacy(Long id) {
        try {
            Pharmacy pharmacy = getPharmacyById(id);
            if (pharmacy != null) {
                dataBase.getPharmacies().remove(pharmacy);
                System.out.println("Pharmacy deleted successfully!");
            }
        } catch (Exception e) {
            System.out.println("Error while deleting pharmacy: " + e.getMessage());
        }
    }

    @Override
    public List<Employee> getEmployeesByPharmacy(Long pharmacyId) {
        try {
            Pharmacy pharmacy = getPharmacyById(pharmacyId);
            if (pharmacy != null) {
                return pharmacy.getEmployeeList();
            } else {
                throw new RuntimeException("Pharmacy not found!");
            }
        } catch (Exception e) {
            System.out.println("Error while getting employees by pharmacy: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public List<Medicine> getMedicinesByPharmacy(Long pharmacyId) {
        try {
            Pharmacy pharmacy = getPharmacyById(pharmacyId);
            if (pharmacy != null) {
                return pharmacy.getMedicines();
            } else {
                throw new RuntimeException("Pharmacy not found!");
            }
        } catch (Exception e) {
            System.out.println("Error while getting medicines by pharmacy: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
