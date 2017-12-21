package model.pojo;

import java.util.List;
import java.util.UUID;

/**
 *
 * @author Sluski
 */
public class User {
    private final String userId;
    private String nick;
    private List<Tag> tags;
    private boolean isLooking;
    private boolean inConversation;
    
    public User(){
        userId = UUID.randomUUID().toString();
        isLooking = false;
        inConversation =  false;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getUserId() {
        return userId;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public boolean isIsLooking() {
        return isLooking;
    }

    public void setIsLooking(boolean isLooking) {
        this.isLooking = isLooking;
    }

    public boolean isInConversation() {
        return inConversation;
    }

    public void setInConversation(boolean inConversation) {
        this.inConversation = inConversation;
    }
}
