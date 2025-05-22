public class EmailMessage extends Message {
    public EmailMessage(ILogin login, String sender, String recipient, String content) {
        super(login, sender, recipient, content);
    }

    @Override
    public void send(String username, String password) {
        if (!this.login.checkLogin(username, password)) {
            System.out.println("Email authentication failed for user: " + username);
            return;
        }

        System.out.println("Email sent from " + this.sender + " to " + this.recipient + ": " + this.content);
    }
}