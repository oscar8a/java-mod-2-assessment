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

    public List<Doctor> getDepartmentDoctorList(Hospital hospital, String department) {
        List<Doctor> deptDocList = hospital.getSpecialtyDirectory().get(department);
        if (deptDocList == null) {
            hospital.specialtyDirectory.put(department, new ArrayList<Doctor>());
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

    public void addDoctorToList(Hospital hospital, Doctor doctor) {
        List<Doctor> doctorList = getDepartmentDoctorList(hospital, doctor.doctorSpecialty);
        doctorList.add(doctor);
    }
}
