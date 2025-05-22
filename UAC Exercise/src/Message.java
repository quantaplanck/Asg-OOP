public abstract class Message {
    ILogin login;
    String sender;
    String recipient;
    String content;

    public Message(ILogin login, String sender, String recipient, String content) {
        this.login = login;
        this.sender = sender;
        this.recipient = recipient;
        this.content = content;
    }

    public abstract void send(String username, String password);
}
