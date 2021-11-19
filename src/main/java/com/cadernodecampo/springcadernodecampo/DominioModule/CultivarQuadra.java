package com.cadernodecampo.springcadernodecampo.DominioModule;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@IdClass(CultivarQuadraId.class)
public class CultivarQuadra implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    @Id
    @ManyToOne()
    @JsonIgnore()
    @JoinColumn(name = "id_Quadra")
    public Quadra quadra;

    @Id
    @ManyToOne()
    @JoinColumn(name = "id_Enxerto")
    public PortaEnxerto enxerto;

    @Id
    @ManyToOne()
    @JoinColumn(name = "id_Cultivar")
    public Cultivar cultivar;

    public Integer quantidade;

    CultivarQuadra(){
        super();
    }
    
    public CultivarQuadra(Integer id, PortaEnxerto enxerto, Quadra quadra, Cultivar cultivar, Integer quantidade) {
        this.id = id;
        this.enxerto = enxerto;
        this.quadra = quadra;
        this.cultivar = cultivar;
        this.quantidade = quantidade;
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
        CultivarQuadra other = (CultivarQuadra) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}


