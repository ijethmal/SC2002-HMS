public class StaffRecordModel {
    
    private User user;
    private String StaffId;
    private String name;
    private String role;

    public StaffRecordModel(User user, String StaffId, String name, String role){
        this.user = user;
        this.staffId = staffId;
        this.name = name;
        this.role = role;
    }

    //get methods
    public User getUser(){
        return user;
    }

    public String getStaffId(){
        return staffId;
    }

    public String getName(){
        return name;
    }

    public String getRole(){
        return role;
    }

    public void viewRecord(){
        return "User: " + user + ", Staff ID: " + staffId + ", Name: " + name + ", Role: " + role;
    }

    public void updateRecord(String name, String role){
        if(name!=null){
            this.name = name;
        }
        
        if(role!=null){
            this.role = role;
        }
        System.out.println("Staff record updated successfully.");
    }

}
