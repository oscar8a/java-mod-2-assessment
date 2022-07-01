import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hospital {
    String hospitalName;
    HashMap<String, List<Doctor>> specialtyDirectory;
    
    public Hospital(String nameInput) {
        hospitalName = nameInput;
        specialtyDirectory = new HashMap<String, List<Doctor>>();
    }

    // public void setSpecialtyDirectory(HashMap<String, List<Doctor>> specialtyDirectory) {
    //     List<Doctor> emptyListOfDoctors = new ArrayList<Doctor>();
    //     this.specialtyDirectory.put("Dermatology", emptyListOfDoctors);
    //     this.specialtyDirectory.put("Pediatrics", emptyListOfDoctors);
    //     this.specialtyDirectory.put("Orthopedics", emptyListOfDoctors);
    // }

    public List<Doctor> getDepartmentDoctorList(String department) {
        System.out.println("getting doctors from " + department);

        List<Doctor> deptDocList = this.specialtyDirectory.get(department);

        if (deptDocList == null) {
            this.specialtyDirectory.put(department, new ArrayList<Doctor>());
            return this.specialtyDirectory.get(department);
        }

        return deptDocList;
    }

    public HashMap<String, List<Doctor>> getSpecialtyDirectory() {
        return specialtyDirectory;
    }

    public List<Doctor> getAllDoctorsList() {
        List<Doctor> allDoctors = new ArrayList<Doctor>();

        for (List<Doctor> departmentDoctorList : this.specialtyDirectory.values()) {
            for (Doctor doctor : departmentDoctorList) {
                allDoctors.add(doctor);
            }
        }
        return allDoctors;
    }

    public void addDoctorToList(Doctor doctor) {
        System.out.println("adding doctor " + doctor.doctorName + " who does " + doctor.doctorSpecialty);
        List<Doctor> doctorList = getDepartmentDoctorList(doctor.doctorSpecialty);
        doctorList.add(doctor);
    }

    
}
