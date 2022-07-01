import java.util.ArrayList;
import java.util.List;

public class Doctor {
    String doctorName;
    String doctorSpecialty;
    
    List<Patient> patientList;
    
    public Doctor(String nameInput, String specialtyInput) {
        doctorName = nameInput;
        doctorSpecialty = specialtyInput;
        patientList = new ArrayList<Patient>();
    }

    void assignPatient(Patient patientInput) {
        this.patientList.add(patientInput);
    }

    public void printPatientList() {
        if (this.patientList.isEmpty()) System.out.println("           + Doctor has no patients");
        
        for (Patient patient : this.patientList) {
            System.out.println("           + " + patient.patientName + " " + patient.patientAge + " " + patient.patientSymptom);
        }
    }


}