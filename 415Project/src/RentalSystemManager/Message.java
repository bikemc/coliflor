package RentalSystemManager;

import java.util.Date;

public class Message {
    private Date date;
    private User user;
    private String content;

    public Message(Date date, User user, String content) {
        this.date = date;
        this.user = user;
        this.content = content;
    }
}
