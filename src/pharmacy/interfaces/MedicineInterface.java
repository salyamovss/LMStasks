package pharmacy.interfaces;

import pharmacy.Medicine;

import java.util.List;

public interface MedicineInterface {

    void createMedicine(Medicine medicine, Long pharmacyId);

    Medicine getMedicineById(Long id);

    void updateMedicine(Long id, Medicine updatedMedicine);

    void deleteMedicine(Long id);

    List<Medicine> getAllMedicines();
}
