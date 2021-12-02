package com.cadernodecampo.springcadernodecampo.DTOmodule;

import java.io.Serializable;
import java.util.Date;

import com.cadernodecampo.springcadernodecampo.DominioModule.Armadilha;
import com.cadernodecampo.springcadernodecampo.DominioModule.MonitoramentoPraga;


public class MonitoramentoPragaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    public Integer id;

    public Date data;

    public Integer contagem;

    public Armadilha armadilha;

    public MonitoramentoPragaDTO(MonitoramentoPraga obj) {
        this.id = obj.id;
        this.data = obj.data;
        this.contagem = obj.contagem;
        this.armadilha = obj.armadilha;
    }

    public MonitoramentoPragaDTO(){
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
        MonitoramentoPragaDTO other = (MonitoramentoPragaDTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

   
}
