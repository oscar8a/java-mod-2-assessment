import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

public class OscarHospitalWorld {
    public static void main(String[] args) {
        
        // Create Hospital
        Hospital h1 = new Hospital("Hospital 1");

        // Creating Doctors, make these inputs with a Scanner
        Doctor d1 = new Doctor("Jose Andrade", "Pediatrics");
        Doctor d3 = new Doctor("Bob Walters", "Orthopedics");
        Doctor d2 = new Doctor("Alice Woods", "Dermatology");
        Doctor d4 = new Doctor("Silvio Gonzales", "Orthopedics");
        Doctor d5 = new Doctor("Gregory House", "Internal Medicine");

        // Doctors added to Hospital HashMap
        // Tracks Departments (keys) and their respective list of Doctors (values)
        h1.addDoctorToList(d1);
        h1.addDoctorToList(d2);
        h1.addDoctorToList(d3);
        h1.addDoctorToList(d4);
        h1.addDoctorToList(d5);

        // Creating Patients and placing them in a Array for input purposes
        Patient p1 = new Patient("Carlos", 22, "Skin Rash");
        Patient p2 = new Patient("Jane", 7, "Cold");
        Patient p3 = new Patient("Sarah", 52, "Hip Pain");
        Patient p4 = new Patient("Pedro", 9, "Throat Pain");
        Patient p5 = new Patient("Susan", 35, "Knee Pain");
        
        Patient[] patientArray = {p1, p2, p3, p4, p5};

        // Running "CheckIn" method that assigns patients to respective Department & Doctor
        // Might need to decouple, and place in another class
        refactoredpatientCheckIn(h1.getSpecialtyDirectory(), patientArray);

        // Print all Hospital Data
        printOutHospitalWorld(h1);
    }

    static void printOutHospitalWorld(Hospital hospital){
        System.out.println("\n\n%%%%%%%%%%%%%%%%% Hospital " + hospital.getHospitalName() + " %%%%%%%%%%%%%%%%%\n");

        System.out.println("### Hospital Specialty Departments and Staff and respective Patients ###");
        for (Entry<String, List<Doctor>> specialtyDepartment : hospital.getSpecialtyDirectory().entrySet()) {
            
            System.out.println("  **** " + specialtyDepartment.getKey() + " ****");

            List<Doctor> departmentDoctors = specialtyDepartment.getValue();
            for (Doctor doctor : departmentDoctors) {
                System.out.println("    ===> " + doctor.doctorName);
                doctor.printPatientList();
            }

        }
        
        // System.out.println("### Patients and Respective Assigned Doctor ###");
        // for (Patient patient : hospital.patientList) {
        //     System.out.println("==> " + patient.patientName + " specializes in " + patient);
        // }
    }

    // static void patientCheckIn(List<Doctor> doctorList, Patient[] patientArray){
    //     for (Doctor doctor : doctorList) {
    //         for (Patient patient : patientArray) {

    //             System.out.println("doc specialty =>" + doctor.doctorSpecialty + "||" + patient.patientSymptom + "<= patient symptom");
    //             if (doctor.doctorSpecialty == patient.patientSymptom) {
    //                 System.out.println("inside condition");
    //                 doctor.assignPatient(patient);
    //             }
    //         }
    //     }
    // }
    // REFACTORED CHECK IN METHOD
    static void refactoredpatientCheckIn(HashMap<String, List<Doctor>> directoryMap, Patient[] patientArray) {
        String department = "Internal Medicine";
        for (int i=0; i < patientArray.length; i++) {
            if (patientArray[i].getPatientSymptom() == "Skin Rash") {
                department = "Dermatology";
            } else if (patientArray[i].getPatientSymptom() == "Cold") {
                department = "Pediatrics";
            } else if (patientArray[i].getPatientSymptom() == "Hip Pain") {
                department = "Orthopedics";
            } else if (patientArray[i].getPatientSymptom() == "Throat Pain") {
                department = "Pediatrics";
            }
            List<Doctor> docList = directoryMap.get(department);
            Doctor doc = docList.get(getRandomNumber().nextInt(docList.size()));
            doc.assignPatient(patientArray[i]);
        }
    }

    static Random getRandomNumber() {
        Random rand = new Random();
        return rand;
    }
}
