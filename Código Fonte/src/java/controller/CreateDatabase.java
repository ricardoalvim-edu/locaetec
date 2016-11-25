package controller;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.*;
/**
 *
 * @author Ricardo
 */
public class CreateDatabase {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("LocaEtecPU");
        EntityManager manager = factory.createEntityManager();
    
        Marca marca = new Marca();
        Modelo modelo = new Modelo();
        Automovel auto = new Automovel();
        
        manager.getTransaction().begin();
        
        manager.persist(marca);
        manager.getTransaction().commit();
        
        manager.persist(modelo);
        manager.getTransaction().begin();
        
        manager.persist(auto);
        manager.getTransaction().begin();
        
        manager.close();
        factory.close();
    }
}
