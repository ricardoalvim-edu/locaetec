/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "automovel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Automovel.findAll", query = "SELECT a FROM Automovel a"),
    @NamedQuery(name = "Automovel.findById", query = "SELECT a FROM Automovel a WHERE a.id = :id"),
    @NamedQuery(name = "Automovel.findByAnoFabricacao", query = "SELECT a FROM Automovel a WHERE a.anoFabricacao = :anoFabricacao"),
    @NamedQuery(name = "Automovel.findByAnoModelo", query = "SELECT a FROM Automovel a WHERE a.anoModelo = :anoModelo"),
    @NamedQuery(name = "Automovel.findByObservacoes", query = "SELECT a FROM Automovel a WHERE a.observacoes = :observacoes"),
    @NamedQuery(name = "Automovel.findByPreco", query = "SELECT a FROM Automovel a WHERE a.preco = :preco"),
    @NamedQuery(name = "Automovel.findByQuilometragem", query = "SELECT a FROM Automovel a WHERE a.quilometragem = :quilometragem"),
    @NamedQuery(name = "Automovel.findByModeloId", query = "SELECT a FROM Automovel a WHERE a.modeloId = :modeloId")})
public class Automovel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "anoFabricacao")
    private Integer anoFabricacao;
    @Column(name = "anoModelo")
    private Integer anoModelo;
    @Column(name = "observacoes")
    private String observacoes;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preco")
    private Float preco;
    @Column(name = "quilometragem")
    private Integer quilometragem;
    @Column(name = "modelo_id")
    private Integer modeloId;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Modelo modelo;

    public Automovel() {
    }

    public Automovel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Integer getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(Integer quilometragem) {
        this.quilometragem = quilometragem;
    }

    public Integer getModeloId() {
        return modeloId;
    }

    public void setModeloId(Integer modeloId) {
        this.modeloId = modeloId;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Automovel)) {
            return false;
        }
        Automovel other = (Automovel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Automovel[ id=" + id + " ]";
    }
    
}
