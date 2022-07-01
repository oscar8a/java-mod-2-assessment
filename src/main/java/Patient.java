public class Patient {
    private String patientName;
    private int patientAge;
    private String patientSymptom;
    
    public Patient(String nameInput, int ageInput, String symptomInput) {
        patientName = nameInput;
        patientAge = ageInput;
        patientSymptom = symptomInput;
    }

    public String getPatientName() {
        return patientName;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public String getPatientSymptom() {
        return patientSymptom;
    }

}