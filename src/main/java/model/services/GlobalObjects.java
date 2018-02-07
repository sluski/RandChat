package model.services;

import model.pojo.User;

/**
 *
 * @author Sluski
 */
public class GlobalObjects {
    private static final User applicationUser = new User("localhost", "none");
    
    public static User getApplicationUser() {
        applicationUser.setNick("RandChat");
        return applicationUser;
    }
    
    
}
