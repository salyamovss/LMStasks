package pharmacy;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private static Database instance;

    private List<Pharmacy> pharmacies;
    private List<Employee> employees;
    private List<Medicine> medicines;

    private Database() {
        this.pharmacies = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.medicines = new ArrayList<>();
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public List<Pharmacy> getPharmacies() {
        return pharmacies;
    }

    public void setPharmacies(List<Pharmacy> pharmacies) {
        this.pharmacies = pharmacies;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }
}
