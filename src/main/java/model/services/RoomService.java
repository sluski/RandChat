package model.services;

import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import model.pojo.Room;
import model.pojo.User;

/**
 *
 * @author Sluski
 */
public class RoomService {

    private String roomKey;
    private User connectedUser;
    private User alienUser;
    private final RoomManager roomManager;
    
    public RoomService(){
        connectedUser = new User();
        roomManager = new RoomManager();
    }
    
    public void setRoomValues(HttpServletRequest request) throws InterruptedException{
        connectedUser = UserManager.returnBySSID(request.getRequestedSessionId());
        roomKey = connectedUser.getRoomKey();
        setAlienUser();
    }
    
    public void setAlienUser(){
        if(isPairInRoom(roomKey)){
          Room room = RoomManager.rooms.get(UUID.fromString(roomKey));
          if(room.getFirstUser().equals(connectedUser)) alienUser = room.getSecondUser();
          else alienUser = room.getFirstUser();
        } 
    }
    
    public String getRoomKey(){
        return roomKey;
    }

    public User getConnectedUser() {
        return connectedUser;
    }
    
    public boolean isPairInRoom(String roomUUID){
        return roomManager.findRoom(roomUUID).isIsPair();
    }
}