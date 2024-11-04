public abstract class UserModel {

    protected String userId;
    protected String password;
    protected String role;

    public UserModel (String userId, String password, String role) {
        this.userId = userId;
        this.password = password;
        this.role = role;
    }

    public static void login(String userId, String password){
        //...
    }

    /*public void changePassword(String oldPass, String newPass){
        if (oldPass == this.password) {
            this.password = newPass;
            System.out.println("Your password has been changed.");
        } else {
            System.out.println("Your old password is incorrect. Password change unsuccessful.");
        }
    }*/

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

   /* public static void main(String[] args) throws Exception {
        
}
 */
}
