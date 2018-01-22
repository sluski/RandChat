package model.pojo;

import java.util.List;

/**
 *
 * @author Sluski
 */
public class User {
    private String clientAddress;
    private String clientSSID;
    private String nick;
    private List<String> tags;
    private boolean isActive;
    private boolean inConversation;
    
    public User(String clienetAddress, String clientSSID){
        isActive = false;
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

    public List<String> getTags() {
        return tags;
    }

    public boolean isLooking() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
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
