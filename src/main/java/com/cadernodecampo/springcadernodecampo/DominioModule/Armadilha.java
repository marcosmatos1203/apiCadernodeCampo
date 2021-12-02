package com.cadernodecampo.springcadernodecampo.DominioModule;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Armadilha implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public double latitude;

    public double longitude;

    public String localizacaoTexto;

    @JsonIgnore()
    @ManyToOne()
    @JoinColumn(name = "idQuadra")
    public Quadra quadra;

    public Armadilha(Integer id, double latitude, double longitude, String localizacaoTexto, Quadra quadra) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.localizacaoTexto = localizacaoTexto;
        this.quadra = quadra;
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
        Armadilha other = (Armadilha) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
