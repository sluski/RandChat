package model.services;

import javax.persistence.EntityManager;

/**
 *
 * @author Sluski
 * @param <AnyType>
 */
public class Dao<AnyType> {
    EntityManager entityManager;
    public void addObject(AnyType objectToAdd){
        entityManager = DBManager.createInstance().getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(objectToAdd);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
    public void removeObject( AnyType objectToRemove){
        entityManager = DBManager.createInstance().getEntityManager();
        entityManager.remove(objectToRemove);
    }
}
