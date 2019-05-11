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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
