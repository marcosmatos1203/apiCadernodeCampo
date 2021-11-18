package com.cadernodecampo.springcadernodecampo.DominioModule;

import java.io.Serializable;



public class CultivarQuadraId implements Serializable{

    public Integer enxerto;

    public Integer quadra;

    public Integer cultivar;

    public CultivarQuadraId(Integer enxerto, Integer quadra, Integer cultivar) {
        this.enxerto = enxerto;
        this.quadra = quadra;
        this.cultivar = cultivar;
    }

    public CultivarQuadraId() {
        super();
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
        CultivarQuadraId other = (CultivarQuadraId) obj;
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
