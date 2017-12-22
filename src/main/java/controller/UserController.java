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
public class UserController {

    private final UserServices userServices;
    private final List<String> categories;
    private List<String> selectedCategories;

    public UserController() {
        userServices = new UserServices();
        categories = new ArrayList<>();
        selectedCategories = new ArrayList<>();
        categories.add("Sport");
        categories.add("IT");
        categories.add("Music");
        categories.add("Science");
        categories.add("Cars");
        categories.add("Art");
        categories.add("Computer Games");
        categories.add("Culture");
    }

    public void create(HttpServletRequest request) {
        if (!selectedCategories.isEmpty()) {
            userServices.createUser(request, selectedCategories);
        } else {
            userServices.createUser(request);
        }

    }

    public List<String> getCategories() {
        return categories;
    }

    public List<String> getSelectedCategories() {
        return selectedCategories;
    }

    public void setSelectedCategories(List<String> selectedCategories) {
        this.selectedCategories = selectedCategories;
    }

}
