package com.cadernodecampo.springcadernodecampo.DominioModule;

import java.io.Serializable;

import javax.persistence.Entity;
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
    
    public CultivarQuadra(PortaEnxerto enxerto, Quadra quadra, Cultivar cultivar, Integer quantidade) {
        this.enxerto = enxerto;
        this.quadra = quadra;
        this.cultivar = cultivar;
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cultivar == null) ? 0 : cultivar.hashCode());
        result = prime * result + ((enxerto == null) ? 0 : enxerto.hashCode());
        result = prime * result + ((quadra == null) ? 0 : quadra.hashCode());
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
        if (cultivar == null) {
            if (other.cultivar != null)
                return false;
        } else if (!cultivar.equals(other.cultivar))
            return false;
        if (enxerto == null) {
            if (other.enxerto != null)
                return false;
        } else if (!enxerto.equals(other.enxerto))
            return false;
        if (quadra == null) {
            if (other.quadra != null)
                return false;
        } else if (!quadra.equals(other.quadra))
            return false;
        return true;
    }
}


