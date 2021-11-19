package com.cadernodecampo.springcadernodecampo.DTOmodule;

import java.io.Serializable;

import com.cadernodecampo.springcadernodecampo.DominioModule.Cultivar;
import com.cadernodecampo.springcadernodecampo.DominioModule.CultivarQuadra;
import com.cadernodecampo.springcadernodecampo.DominioModule.PortaEnxerto;
import com.cadernodecampo.springcadernodecampo.DominioModule.Quadra;

public class CultivarQuadraDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public Integer id;

    public PortaEnxerto enxerto;

    public Quadra quadra;

    public Cultivar cultivar;

    public Integer quantidade;

    public CultivarQuadraDTO(CultivarQuadra obj) {
        this.id = obj.id;
        this.cultivar = obj.cultivar;
        this.enxerto = obj.enxerto;
        this.quadra = obj.quadra;
        this.quantidade = obj.quantidade;
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
        CultivarQuadraDTO other = (CultivarQuadraDTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
