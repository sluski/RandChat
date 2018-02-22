package controller;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpServletRequest;
import model.pojo.Message;
import model.pojo.User;
import model.services.RoomService;
import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;


/**
 *
 * @author Sluski
 */
@ManagedBean
@SessionScoped
public class RoomView {

    private final RoomService roomService;
    private String message;
    private String room;
    private User user;
    private String alienUser;
    private List<Message> conversation;

    public RoomView() {
        roomService = new RoomService();
        conversation = new ArrayList<>();
    }

    public void setConncetedUser(HttpServletRequest request) throws InterruptedException {
        roomService.setRoomValues(request);
        setParams();
    }

    private void setParams() {
        room = roomService.getRoomKey();
        user = roomService.getConnectedUser();
        if (roomService.getAlienUser() != null) {
            alienUser = roomService.getAlienUser().getClientSSID();
        }
    }

    public void send() {
        EventBus eventBus = EventBusFactory.getDefault().eventBus();
        eventBus.publish("/notify", new Message(user, message));
        conversation.add(roomService.getComingMessage());
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }
}
