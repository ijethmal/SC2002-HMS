public class ReplenishmentRequestModel {
    private Medicine medicine;
    private Pharmacist requester;
    private Administrator admin;
    private Status status;
    private Date requestDate;
    private Date approvalDate;

    public ReplenishmentRequestModel(Medicine medicine, Pharmacist requester) {
        this.medicine = medicine;
        this.requester = requester;
        this.status = Status.PENDING; // Default status
        this.requestDate = new Date(); // Set to current date
    }

    public void approveRequest(Administrator admin) {
        this.status = Status.APPROVED;
        this.admin = admin;
        this.approvalDate = new Date(); // Set to current date
    }

    public void denyRequest(Administrator admin) {
        this.status = Status.DENIED;
        this.admin = admin;
    }

    public String viewRequest() {
        return "Request for " + medicine.getName() + " by " + requester.getName() +
               "\nStatus: " + status + "\nRequested on: " + requestDate +
               "\nApproval Date: " + (approvalDate != null ? approvalDate : "Not yet approved");
    }
}