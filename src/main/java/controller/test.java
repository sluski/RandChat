package controller;


import model.services.DBManager;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;

/**
 *
 * @author Sluski
 */

@ManagedBean
@SessionScoped
public class test {
    EntityManager entityManager = DBManager.createInstance().getEntityManager();
    
    public void test(){
        entityManager.getTransaction();
        entityManager.close();
        
    }
}
