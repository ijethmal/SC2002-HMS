public class Patient {
    private String id;
    private String password;

    public Patient(String id, String password) {
        this.id = id;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Patient ID: " + id + ", Password: " + password;
    }
}