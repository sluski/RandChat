package model.services;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.pojo.Message;
import model.pojo.Room;
import model.pojo.User;
import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;

/**
 *
 * @author Sluski
 */
public class RoomService {

    private Message message;

    public RoomService() {
    }

    public void send(String messageContent, HttpServletRequest request) {
        User sender = UserManager.findBySSID(request.getRequestedSessionId());
        User recipient = findRecipientBySender(sender);
        message = new Message(sender, recipient, messageContent);
        RoomManager.findRoom(recipient.getRoomKey()).addToConversation(message);
        EventBus eventBus = EventBusFactory.getDefault().eventBus();
        eventBus.publish("/test", true);
    }

    public User findRecipientBySender(User sender) {
        Room room = RoomManager.findRoom(sender.getRoomKey());
        if (room.getFirstUser() == sender) {
            return room.getSecondUser();
        } else {
            return room.getFirstUser();
        }
    }

    public Message getMessage() {
        return message;
    }

    public List<Message> getClientConversation(HttpServletRequest request) {
        User client = UserManager.findBySSID(request.getRequestedSessionId());
        Room room = RoomManager.findRoom(client.getRoomKey());
        return room.getConversation();
    }
    
    public User findUserBySSID(String userSSID){
        return UserManager.findBySSID(userSSID);
    }
}
