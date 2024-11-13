import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;


public class RegisterNewPatient {

    public PatientModel createPatient() {
        Scanner scanner = new Scanner(System.in);
        String patientId = generateUniqueId();

        System.out.println("Please enter the patient details:");
        System.out.println("Generated Patient ID: " + patientId);

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        Date dob = getDateInput("Enter Date of Birth (dd/MM/yyyy): ", scanner);

        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();

        System.out.print("Enter Contact Information: ");
        String contactInfo = scanner.nextLine();

        System.out.print("Enter Blood Type: ");
        String bloodType = scanner.nextLine();

        PatientModel newPatient = new PatientModel(patientId, name, dob, gender, contactInfo, bloodType, null);
        System.out.println("Patient registered successfully!");
        return newPatient;
    }

    private String generateUniqueId() {
        return UUID.randomUUID().toString();
    }

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
 RegisterNewPatient() {
 }
}
