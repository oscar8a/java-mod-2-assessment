import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hospital {
    private String hospitalName;
    private HashMap<String, List<Doctor>> specialtyDirectory;

    public Hospital(String nameInput) {
        hospitalName = nameInput;
        specialtyDirectory = new HashMap<String, List<Doctor>>();
    }

    public HashMap<String, List<Doctor>> getSpecialtyDirectory() {
        return specialtyDirectory;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public List<Doctor> getDepartmentDoctorList(String department) {
        System.out.println("getting doctors from " + department);

        List<Doctor> deptDocList = this.specialtyDirectory.get(department);

        if (deptDocList == null) {
            this.specialtyDirectory.put(department, new ArrayList<Doctor>());
            return this.specialtyDirectory.get(department);
        }

        return deptDocList;
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
