package pharmacy.service;

import pharmacy.Database;
import pharmacy.Medicine;
import pharmacy.Pharmacy;
import pharmacy.interfaces.MedicineInterface;


import java.util.ArrayList;
import java.util.List;

public class MedicineServiceImpl implements MedicineInterface {

    private final Database dataBase = Database.getInstance();
    private static long medicineIdCounter = 1;

    @Override
    public void createMedicine(Medicine medicine, Long pharmacyId) {
        try {
            if (medicine.getExpirationDate().getYear() != 2025) {
                throw new RuntimeException("Medicine must have expiration year 2025!");
            }

            Pharmacy pharmacy = null;
            for (Pharmacy p : dataBase.getPharmacies()) {
                if (p.getUniqueID() == (pharmacyId)) {
                    pharmacy = p;
                    break;
                }
            }

            if (pharmacy == null) {
                throw new RuntimeException("Pharmacy not found with ID: " + pharmacyId);
            }

            medicine.setUniqueID(medicineIdCounter++);
            pharmacy.getMedicines().add(medicine);
            System.out.println("Medicine created and assigned to pharmacy!");
        } catch (Exception e) {
            System.out.println("Error while creating medicine: " + e.getMessage());
        }
    }

    @Override
    public Medicine getMedicineById(Long id) {
        try {
            for (Pharmacy pharmacy : dataBase.getPharmacies()) {
                for (Medicine med : pharmacy.getMedicines()) {
                    if (med.getUniqueID() == (id)) {
                        return med;
                    }
                }
            }
            throw new RuntimeException("Medicine not found with ID: " + id);
        } catch (Exception e) {
            System.out.println("Error while getting medicine: " + e.getMessage());
            return null;
        }
    }

    @Override
    public void updateMedicine(Long id, Medicine updatedMedicine) {
        try {
            Medicine medicine = getMedicineById(id);
            if (medicine != null) {
                medicine.setName(updatedMedicine.getName());
                medicine.setPrice(updatedMedicine.getPrice());
                medicine.setExpirationDate(updatedMedicine.getExpirationDate());
                System.out.println("Medicine updated successfully!");
            }
        } catch (Exception e) {
            System.out.println("Error while updating medicine: " + e.getMessage());
        }
    }

    @Override
    public void deleteMedicine(Long id) {
        try {
            for (Pharmacy pharmacy : dataBase.getPharmacies()) {
                List<Medicine> medicines = pharmacy.getMedicines();
                Medicine toDelete = null;
                for (Medicine med : medicines) {
                    if (med.getUniqueID()== (id)) {
                        toDelete = med;
                        break;
                    }
                }

                if (toDelete != null) {
                    medicines.remove(toDelete);
                    System.out.println("Medicine deleted successfully!");
                    return;
                }
            }
            throw new RuntimeException("Medicine not found to delete!");
        } catch (Exception e) {
            System.out.println("Error while deleting medicine: " + e.getMessage());
        }
    }

    @Override
    public List<Medicine> getAllMedicines() {
        List<Medicine> all = new ArrayList<>();
        try {
            for (Pharmacy pharmacy : dataBase.getPharmacies()) {
                all.addAll(pharmacy.getMedicines());
            }
        } catch (Exception e) {
            System.out.println("Error while collecting medicines: " + e.getMessage());
        }
        return all;
    }
}

