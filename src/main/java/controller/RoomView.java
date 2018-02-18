package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpServletRequest;
import model.services.RoomService;

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
    private String user;
    private String alienUser;
    private String commingMessage;

    public RoomView() {
        roomService = new RoomService();

    }

    public void setConncetedUser(HttpServletRequest request) throws InterruptedException {
        roomService.setRoomValues(request);
        setParams();
    }

    private void setParams() {
        room = roomService.getRoomKey();
        user = roomService.getConnectedUser().getClientSSID();
        if(roomService.getAlienUser() != null) alienUser = roomService.getAlienUser().getClientSSID();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRoom() {
        return room;
    }

    public String getUser() {
        return user;
    }

    public String getComingMessage() {
        return commingMessage;
    }

    public void setComingMessage(String comingMessage) {
        this.commingMessage = comingMessage;
    }
}
