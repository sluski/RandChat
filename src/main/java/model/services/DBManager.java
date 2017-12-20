package model.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBManager {
    private static DBManager instance;
    private static EntityManagerFactory entityManagerFactory;
    
    private DBManager(){
        entityManagerFactory = Persistence.createEntityManagerFactory("pl.sluski_ChatBoom");
    }
    
    public static DBManager createInstance(){
        if(instance == null){
            instance = new DBManager();
        }
        return instance;
    }
    
    public EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }
}
