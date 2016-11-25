/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import model.Marca;

/**
 *
 * @author Antonio
 */
public class RecuperarMarca {

    public static void main(String[] args) {
        Marca marca;
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("LocaEtecPU");
            EntityManager em = emf.createEntityManager();
            marca = em.find(Marca.class, 4);
            em.close();
            emf.close();
            JOptionPane.showMessageDialog(null, "Marca " + marca.getId() + " = " + marca.getNome());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro 2: " + ex.getMessage());
        }
    }
}
