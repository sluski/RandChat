package model.pojo;

/**
 *
 * @author Sluski
 */
public class Message {
    private User author;
    private String message;
    
    public Message(User user, String message){
        this.author = user;
        this.message = message;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
