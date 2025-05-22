public class BasicLogin implements ILogin {
    String username;
    String password;

    public BasicLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Boolean checkLogin(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}
