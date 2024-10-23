public abstract class User {

    protected String userId;
    protected String password;
    protected String role;

    /*public User (String userId, String password, String role) {
        this.userId = userId;
        this.password = password;
        this.role = role;
    }*/
    public User () {}

    public static void login(String userId, String password){
        //...
    }

    public void changePassword(String oldPass, String newPass){
        if (oldPass == this.password) {
            this.password = newPass;
            System.out.println("Your password has been changed.");
        } else {
            System.out.println("Your old password is incorrect. Password change unsuccessful.");
        }
    }

   /* public static void main(String[] args) throws Exception {
        
}
 */
}
