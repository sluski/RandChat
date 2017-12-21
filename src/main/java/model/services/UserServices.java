package model.services;

import model.pojo.User;

/**
 *
 * @author Sluski
 */
public class UserServices {
    User user;
    public void createUser(){
        user = new User();
        
    }
    
    public void findRoom(){
        user.setIsLooking(true);
        while(!user.isInConversation()){
            
        }
        user.setInConversation(true);
        
    }
}
