package com.cadernodecampo.springcadernodecampo.DominioModule;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MonitoramentoPraga implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public Date data;

    public Integer contagem;

    @ManyToOne()
    @JoinColumn(name = "idArmadilha")
    public Armadilha armadilha;

    public MonitoramentoPraga(Integer id, Date data, Integer contagem, Armadilha armadilha) {
        this.id = id;
        this.data = data;
        this.contagem = contagem;
        this.armadilha = armadilha;
    }
    public MonitoramentoPraga() {
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
        MonitoramentoPraga other = (MonitoramentoPraga) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    

}
