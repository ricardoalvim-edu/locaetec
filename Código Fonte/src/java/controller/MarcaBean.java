package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import model.Marca;
import util.JPAUtil;

@ManagedBean
@SessionScoped
public class MarcaBean {

    private Marca marca;
    private List<Marca> marcas;

    /**
     * Creates a new instance of MarcaBean
     */
    public MarcaBean() {
        this.marca = new Marca();
        this.marcas = null;
    }

    public void salvar() {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(this.marca);
        tx.commit();
        em.close();
        this.marca = new Marca();
    }
    public void excluir(Marca marca){
        try{
            EntityManager em = JPAUtil.getEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Marca m = em.find(Marca.class, marca.getId());
            em.remove(m);
            tx.commit();
            em.close();
        }catch(Exception ex){
            System.out.println(ex);
        }
        
        
    }
    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Marca> getMarcas() {
        // Ler todas as marcas do banco de dados para exibir nas páginas web
        EntityManager em = JPAUtil.getEntityManager();
        //Linguagem JPQL
        Query q = em.createQuery("select m from Marca m");
        this.marcas = q.getResultList();
        return marcas;
    }

    public void setMarcas(List<Marca> marcas) {
        this.marcas = marcas;
    }
}
