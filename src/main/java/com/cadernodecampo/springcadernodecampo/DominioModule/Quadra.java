package com.cadernodecampo.springcadernodecampo.DominioModule;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Quadra implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    private Integer anoPlantio;

    private Integer distanciaFilas;

    private Integer distanciaPlantas;

    private Integer quantidadeColmeias;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "Pomar")
    private Pomar pomar;
    

    @OneToMany(mappedBy = "quadra")
    public List<CultivarQuadra> cultivaresQuadra = new ArrayList<>();


    public Quadra(Integer id, Integer anoPlantio, Integer distanciaFilas, Integer distanciaPlantas,
            Integer quantidadeColmeias, Pomar pomar) {
        this.id = id;
        this.anoPlantio = anoPlantio;
        this.distanciaFilas = distanciaFilas;
        this.distanciaPlantas = distanciaPlantas;
        this.quantidadeColmeias = quantidadeColmeias;
        this.pomar = pomar;
    }

    public Quadra() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public Pomar getPomar() {
        return pomar;
    }

    public void setPomar(Pomar pomar) {
        this.pomar = pomar;
    }

    public Integer getQuantidadeColmeias() {
        return quantidadeColmeias;
    }

    public void setQuantidadeColmeias(Integer quantidadeColmeias) {
        this.quantidadeColmeias = quantidadeColmeias;
    }

    public Integer getDistanciaPlantas() {
        return distanciaPlantas;
    }

    public void setDistanciaPlantas(Integer distanciaPlantas) {
        this.distanciaPlantas = distanciaPlantas;
    }

    public Integer getDistanciaFilas() {
        return distanciaFilas;
    }

    public void setDistanciaFilas(Integer distanciaFilas) {
        this.distanciaFilas = distanciaFilas;
    }

    public Integer getAnoPlantio() {
        return anoPlantio;
    }

    public void setAnoPlantio(Integer anoPlantio) {
        this.anoPlantio = anoPlantio;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Quadra other = (Quadra) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
