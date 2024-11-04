public abstract class UserController {
    
    protected UserModel model;
    protected UserView view;

    public UserController(UserModel model, UserView view) {
        this.model = model;
        this.view = view;
    }

    public boolean handleLogin(String userId, String password) {
        if (model.getUserId().equals(userId) && model.getPassword().equals(password)) {
            view.displayLoginSuccess();
            return true;
        } else {
            view.displayLoginError();
            return false;
        }
    }

    public void handleChangePassword(String oldPass, String newPass) {
        if (oldPass.equals(model.getPassword())) {
            model.setPassword(newPass);
            view.displayPasswordChangeSuccess();
        } else {
            view.displayPasswordChangeError();
        }
    }

    public void updateLoginView() {
        //...
    }

    public void updateUserView() {
        //...
    }

    public void updateChangePasswordView() {
        //...
    }
}
