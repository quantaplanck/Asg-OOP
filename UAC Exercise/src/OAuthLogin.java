public class OAuthLogin implements ILogin {
    String token;

    public OAuthLogin(String token) {
        this.token = token;
    }

    @Override
    public Boolean checkLogin(String username, String password) {
        return this.token.equals(password);
    }
}
