package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Antonio
 */
public class JPAUtil {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LocaEtecPU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static EntityManagerFactory getEmf() {
        return emf;
    }
}
