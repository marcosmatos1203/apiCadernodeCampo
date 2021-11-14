package com.cadernodecampo.springcadernodecampo.DTOmodule;

import java.io.Serializable;

import com.cadernodecampo.springcadernodecampo.DominioModule.Cultivar;
import com.cadernodecampo.springcadernodecampo.DominioModule.CultivarQuadra;
import com.cadernodecampo.springcadernodecampo.DominioModule.PortaEnxerto;
import com.cadernodecampo.springcadernodecampo.DominioModule.Quadra;

public class CultivarQuadraDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private PortaEnxerto enxerto;

    private Quadra quadra;

    public Cultivar cultivar;

    public Integer quantidade;

    public CultivarQuadraDTO(CultivarQuadra obj) {
        this.cultivar = obj.cultivar;
        this.enxerto = obj.enxerto;
        this.quadra = obj.quadra;
        this.quantidade = obj.quantidade;
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
        CultivarQuadraDTO other = (CultivarQuadraDTO) obj;
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
