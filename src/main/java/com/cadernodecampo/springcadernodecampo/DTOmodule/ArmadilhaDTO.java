package com.cadernodecampo.springcadernodecampo.DTOmodule;

import java.io.Serializable;

import com.cadernodecampo.springcadernodecampo.DominioModule.Armadilha;
import com.cadernodecampo.springcadernodecampo.DominioModule.Quadra;

public class ArmadilhaDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    public Integer id;

    public double latitude;

    public double longitude;

    public String localizacaoTexto;

    public Quadra quadra;

    public ArmadilhaDTO(Armadilha obj){
        id = obj.id;
        latitude = obj.latitude;
        longitude = obj.longitude;
        localizacaoTexto = obj.localizacaoTexto;
        quadra = obj.quadra;
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
        ArmadilhaDTO other = (ArmadilhaDTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public ArmadilhaDTO() {
        super();
    }
}
