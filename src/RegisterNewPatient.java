import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID; // For generating unique IDs

public class RegisterNewPatient {

    public PatientModel createPatient() {
        Scanner scanner = new Scanner(System.in);

        // Generate a unique patient ID
        String patientId = generateUniqueId();
        
        // Collect user input for patient data
        System.out.println("Please enter the patient details:");
        System.out.println("Generated Patient ID: " + patientId); // Display the generated ID to the user
        
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        
        Date dob = getDateInput("Enter Date of Birth (dd/MM/yyyy): ", scanner);
        
        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();
        
        System.out.print("Enter Contact Information: ");
        String contactInfo = scanner.nextLine();
        
        System.out.print("Enter Blood Type: ");
        String bloodType = scanner.nextLine();
        
        // Create and return a new PatientModel instance
        PatientModel newPatient = new PatientModel();
        newPatient.setPatientId(patientId); // Set the generated patient ID
        newPatient.setName(name);
        newPatient.setDob(dob);
        newPatient.setGender(gender);
        newPatient.setContactInfo(contactInfo);
        newPatient.setBloodType(bloodType);
        
        System.out.println("Patient registered successfully!");
        return newPatient;
    }

    // Helper method to generate a unique patient ID
    private String generateUniqueId() {
        return UUID.randomUUID().toString(); // Generates a unique identifier
    }

    // Helper method to get user input as a date
    private Date getDateInput(String prompt, Scanner scanner) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        while (date == null) {
            System.out.print(prompt);
            String dateString = scanner.nextLine();
            try {
                date = formatter.parse(dateString);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please use dd/MM/yyyy.");
            }
        }
        return date;
    }
}
