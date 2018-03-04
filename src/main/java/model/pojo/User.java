package model.pojo;

import java.util.List;

/**
 *
 * @author Sluski
 */
public class User {

    private String roomKey;
    private String clientAddress;
    private String clientSSID;
    private String nick;
    private List<String> tags;

    public User(String clienetAddress, String clientSSID) {
        this.clientSSID = clientSSID;
        this.clientAddress = clienetAddress;
    }
    
    public User(){
    
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

    public String getClientAddress() {
        return clientAddress;
    }

    public String getClientSSID() {
        return clientSSID;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getRoomKey() {
        return roomKey;
    }

    public void setRoomKey(String roomKey) {
        this.roomKey = roomKey;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public void setClientSSID(String clientSSID) {
        this.clientSSID = clientSSID;
    }
}
