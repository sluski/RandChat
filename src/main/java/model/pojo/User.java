package model.pojo;

import java.util.List;
import java.util.UUID;

/**
 *
 * @author Sluski
 */
public class User {
    private final String userId;
    private String clientAddress;
    private String clientSSID;
    private String nick;
    private List<String> tags;
    private boolean isLooking;
    private boolean inConversation;
    
    public User(String clienetAddress, String clientSSID){
        userId = UUID.randomUUID().toString();
        isLooking = false;
        inConversation =  false;
        this.clientSSID = clientSSID;
        this.clientAddress = clienetAddress;
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

    public List<String> getTags() {
        return tags;
    }

    public boolean isLooking() {
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

    public String getClientAddress() {
        return clientAddress;
    }

    public String getClientSSID() {
        return clientSSID;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
