/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import model.Automovel;
import util.JPAUtil;

/**
 *
 * @author Antonio
 */
@ManagedBean
@RequestScoped
public class AutomovelBean {

    private Automovel automovel;
    private List<Automovel> automoveis;

    /**
     * Creates a new instance of AutomovelBean
     */
    public AutomovelBean() {
        this.automovel = new Automovel();
        this.automoveis = null;
    }

    public void salvar() {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(this.automovel);
        tx.commit();
        em.close();
        this.automovel = new Automovel();
    }

    public Automovel getAutomovel() {
        return automovel;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }

    public List<Automovel> getAutomoveis() {
        return automoveis;
        
    }

    public void setAutomoveis(List<Automovel> automoveis) {
        this.automoveis = automoveis;
    }
}
