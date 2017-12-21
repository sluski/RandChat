package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.services.UserServices;

/**
 *
 * @author Sluski
 */

@ManagedBean
@ViewScoped
public class UserController {
    
    UserServices userServices;
    
    public UserController(){
        userServices = new UserServices();
    }
    
    public void create(){
        userServices.createUser();
    }
}
