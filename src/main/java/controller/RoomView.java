package controller;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpServletRequest;
import model.pojo.Message;
import model.services.RoomService;
import org.primefaces.push.annotation.OnMessage;
import org.primefaces.push.annotation.PathParam;
import org.primefaces.push.annotation.PushEndpoint;
import org.primefaces.push.impl.JSONEncoder;

/**
 *
 * @author Sluski
 */
@PushEndpoint("/test")
@ManagedBean
@SessionScoped
public class RoomView {

    private final RoomService roomService;
    private String message;
    private final List<String> conversation;

    @PathParam("room")
    private String room;

    public RoomView() {
        roomService = new RoomService();
        conversation = new ArrayList<>();
        conversation.add("RandChat: You'r connected with other user, say hello");
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void send(HttpServletRequest request) {
        roomService.send(message, request);
        message = "";

    }

    public String getMessage() {
        return message;
    }

    public void setConversation(HttpServletRequest request) {
        String conversationRow;
        Message temp = roomService.getClientConversation(request).get(roomService.getClientConversation(request).size() - 1);
        conversationRow = temp.getSender().getNick() + ": " + temp.getMessage();
        conversation.add(conversationRow);
    }

    public List<String> getConversation() {
        return conversation;
    }

    @OnMessage(encoders = {JSONEncoder.class})
    public boolean onMessage(boolean confirm) {
        return confirm;
    }
    
    public void setParam(HttpServletRequest request){
        room = roomService.findUserBySSID(request.getRequestedSessionId()).getRoomKey();
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
    
}
