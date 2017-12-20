package model.services;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import model.entity.TUser;

/**
 *
 * @author Sluski
 */
public class User {
    Dao dao;
    
    public User(){
        dao = new Dao();
    }
    public void create(){
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(cookieManager);
        
        
        TUser user = new TUser();
    }
}
