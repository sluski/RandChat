package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpServletRequest;
import model.services.RoomService;
import org.atmosphere.config.service.PathParam;

/**
 *
 * @author Sluski
 */
@ManagedBean
@SessionScoped
public class RoomView {

    private final RoomService roomService;
    private String message;

    @PathParam
    private String room;
    @PathParam
    private String user;

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
    }

//    public void send() {
//        EventBus eventBus = EventBusFactory.getDefault().eventBus();
//        eventBus.publish("/{room}/{user}", String.valueOf(message));
//    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
