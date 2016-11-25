package controller;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import model.Modelo;
import util.JPAUtil;

@ManagedBean
@RequestScoped
public class ModeloBean {

    private Modelo modelo;
    private List<Modelo> modelos;
    public ModeloBean() {
        //this.marcaDAO = new MarcaJpaController(JPAUtil.getEmf());
        this.modelo = new Modelo();
        this.modelos = null;
    }

    public void salvar() {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(this.modelo);
        tx.commit();
        em.close();
        this.modelo = new Modelo();
    }

    public List<String> complete() {
        List<String> results = new ArrayList<String>();

        for (Modelo m : getModelos()) {
            results.add(m.getDescricao());
        }
        return results;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public List<Modelo> getModelos() {
        // Ler todas as marcas do banco de dados para exibir nas páginas web
        EntityManager em = JPAUtil.getEntityManager();
        //Linguagem JPQL
        Query q = em.createQuery("select m from Modelo m");
        this.modelos = q.getResultList();
        return modelos;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }
}
