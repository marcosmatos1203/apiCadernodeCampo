package com.cadernodecampo.springcadernodecampo.DTOmodule;

import java.io.Serializable;

import com.cadernodecampo.springcadernodecampo.DominioModule.Cultivar;


public class CultivarDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    public Integer id;

    public String nome;

    public CultivarDTO(Cultivar obj) {
        this.id = obj.id;
        this.nome = obj.nome;
    }

    public CultivarDTO(){
        super();
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
        PortaEnxertoDTO other = (PortaEnxertoDTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
