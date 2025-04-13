package pharmacy;

import java.awt.*;
import java.util.ArrayList;

public class Pharmacy {
    private long uniqueID;
    private String name;
    private String address;
    private ArrayList<Employee>employeeList;
    private ArrayList<Medicine>medicines;

    public Pharmacy() {
    }

    public Pharmacy(long uniqueID, String name, String address, ArrayList<Employee> employeeList, ArrayList<Medicine> medicines) {
        this.uniqueID = uniqueID;
        this.name = name;
        this.address = address;
        this.employeeList = employeeList;
        this.medicines = medicines;
    }

    public long getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(long uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(ArrayList<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public ArrayList<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(ArrayList<Medicine> medicines) {
        this.medicines = medicines;
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
               "uniqueID=" + uniqueID +
               ", name='" + name + '\'' +
               ", address='" + address + '\'' +
               ", employeeList=" + employeeList +
               ", medicines=" + medicines +
               '}';
    }
}
