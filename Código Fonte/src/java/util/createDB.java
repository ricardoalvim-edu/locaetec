package util;

import javax.persistence.*;
public class createDB {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("LocaEtecPU");
        EntityManager manager = factory.createEntityManager();
        manager.close();
    }
}
