package controller;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpServletRequest;
import model.services.UserServices;

/**
 *
 * @author Sluski
 */
@ManagedBean
@ViewScoped
public class StartView {

    private final UserServices userServices;
    private final List<String> tags;
    private List<String> selectedTags;
    private String nick;

    public StartView() {
        userServices = new UserServices();
        tags = new ArrayList<>();
        selectedTags = new ArrayList<>();
        tags.add("Sport");
        tags.add("IT");
        tags.add("Music");
        tags.add("Science");
        tags.add("Cars");
        tags.add("Art");
        tags.add("Computer Games");
        tags.add("Culture");
    }

    public String create(HttpServletRequest request) {
            if(selectedTags == null && nick.isEmpty()){
                userServices.createUser(request);
            }
            if(selectedTags != null && nick.isEmpty()){
                userServices.createUser(request, selectedTags);
            }
            if(selectedTags == null && !nick.isEmpty()){
                userServices.createUser(request, nick);
            }
            if(selectedTags != null && !nick.isEmpty()){
                userServices.createUser(request, selectedTags, nick);
            }
            return "room.xhtml";
    }
    
    public List<String> getCategories() {
        return tags;
    }

    public List<String> getSelectedCategories() {
        return selectedTags;
    }

    public void setSelectedCategories(List<String> selectedCategories) {
        this.selectedTags = selectedCategories;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }    
}
