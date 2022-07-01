import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Map.Entry;

public class OscarHospitalWorld {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            // Create Hospital
            Hospital userHospital = new Hospital(scanner.nextLine());

            // Creating Doctors, make these inputs with a Scanner
            // Doctor d1 = new Doctor("Jose Andrade", "Pediatrics");
            // Doctor d3 = new Doctor("Bob Walters", "Orthopedics");
            // Doctor d2 = new Doctor("Alice Woods", "Dermatology");
            // Doctor d4 = new Doctor("Silvio Gonzales", "Orthopedics");
            // Doctor d5 = new Doctor("Gregory House", "Internal Medicine");

            populateData(scanner, userHospital);

            // Doctors added to Hospital HashMap
            // Tracks Departments (keys) and their respective list of Doctors (values)
            // userHospital.addDoctorToList(d1);
            // userHospital.addDoctorToList(d2);
            // userHospital.addDoctorToList(d3);
            // userHospital.addDoctorToList(d4);
            // userHospital.addDoctorToList(d5);

            // Creating Patients and placing them in a Array for input purposes
            Patient p1 = new Patient("Carlos", 22, "Skin Rash");
            Patient p2 = new Patient("Jane", 7, "Cold");
            Patient p3 = new Patient("Sarah", 52, "Hip Pain");
            Patient p4 = new Patient("Pedro", 9, "Throat Pain");
            Patient p5 = new Patient("Susan", 35, "Knee Pain");

            Patient[] patientArray = { p1, p2, p3, p4, p5 };

            // Running "CheckIn" method that assigns patients to respective Department &
            // Doctor
            // Might need to decouple, and place in another class
            refactoredpatientCheckIn(userHospital.getSpecialtyDirectory(), patientArray);

            // Print all Hospital Data
            printOutHospitalWorld(userHospital);

        } catch (Exception e) {
            System.out.println("Opps, bad input...");
            e.printStackTrace();
        }
    }

    static void printOutHospitalWorld(Hospital hospital) {
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
    }

    // REFACTORED CHECK IN METHOD
    static void refactoredpatientCheckIn(HashMap<String, List<Doctor>> directoryMap, Patient[] patientArray) {
        String department = "Internal Medicine";
        for (int i = 0; i < patientArray.length; i++) {
            if (patientArray[i].getPatientSymptom().equals("Skin Rash")) {
                department = "Dermatology";
            } else if (patientArray[i].getPatientSymptom() == "Cold") {
                department = "Pediatrics";
            } else if (patientArray[i].getPatientSymptom() == "Hip Pain") {
                department = "Orthopedics";
            } else if (patientArray[i].getPatientSymptom() == "Throat Pain") {
                department = "Pediatrics";
            }
            if (directoryMap.get(department) != null) {
                Doctor doc = directoryMap.get(department).get(getRandomNumber().nextInt(directoryMap.get(department).size()));
                doc.assignPatient(patientArray[i]);
            }
        }
    }

    static Random getRandomNumber() {
        Random rand = new Random();
        return rand;
    }

    static void populateData(Scanner scanner, Hospital hospital) {
        System.out.println("How many doctors would you like to add?");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        int i = 0;
        do {
            populateDoctors(scanner, hospital);
            i++;
        } while (i < quantity);
    }

    static void populateDoctors(Scanner scanner, Hospital hospital) {
        String[] specialties = {"Dermatology", "Pediatrics", "Orthopedics"};

        Doctor inputDoctor = new Doctor();
        System.out.println("Please enter Doctor name");
        inputDoctor.setDoctorName(scanner.nextLine());
        System.out.println("Please enter Doctor specialty 1-Dermatology 2-Pediatrics 3-Orthopedics");
        inputDoctor.setDoctorSpecialty(scanner.nextInt(), specialties);
        hospital.addDoctorToList(hospital, inputDoctor);
        scanner.nextLine();
    }
}
