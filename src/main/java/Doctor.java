import java.util.ArrayList;
import java.util.List;

public class Doctor {
    String doctorName;
    String doctorSpecialty;
    
    List<Patient> patientList;
    
    public Doctor() {
        patientList = new ArrayList<Patient>();
    }

    void assignPatient(Patient patientInput) {
        this.patientList.add(patientInput);
    }

    public void printPatientList() {
        if (this.patientList.isEmpty()) System.out.println("           + Doctor has no patients");
        
        for (Patient patient : this.patientList) {
            System.out.println("           + " + patient.getPatientName() + " " + patient.getPatientAge() + " " + patient.getPatientSymptom());
        }
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void setDoctorSpecialty(int specialtyInput, String[] specialties) {
        this.doctorSpecialty = specialties[specialtyInput - 1];
    }

    public String getDoctorSpecialty() {
        return doctorSpecialty;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

}
