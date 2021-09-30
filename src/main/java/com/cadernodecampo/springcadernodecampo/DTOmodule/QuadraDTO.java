package com.cadernodecampo.springcadernodecampo.DTOmodule;

import java.io.Serializable;

import com.cadernodecampo.springcadernodecampo.DominioModule.Quadra;

public class QuadraDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer anoPlantio;
    private Integer distanciaFilas;
    private Integer distanciaPlantas;
    private Integer quantidadeColmeias;
    private Integer id_pomar;

    
    public QuadraDTO(Quadra obj) {
        this.id = obj.getId();
        this.anoPlantio = obj.getAnoPlantio();
        this.distanciaFilas = obj.getDistanciaFilas();
        this.distanciaPlantas = obj.getDistanciaPlantas();
        this.quantidadeColmeias = obj.getQuantidadeColmeias();
        this.id_pomar = obj.getPomar().getId();
    }
    public QuadraDTO() {
        super();
    }
    public Integer getAnoPlantio() {
        return anoPlantio;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId_pomar() {
        return id_pomar;
    }
    public void setId_pomar(Integer id_pomar) {
        this.id_pomar = id_pomar;
    }
    public Integer getQuantidadeColmeias() {
        return quantidadeColmeias;
    }
    public void setQuantidadeColmeias(Integer quantidadeColmeias) {
        this.quantidadeColmeias = quantidadeColmeias;
    }
    public Integer getDistanciaPlantas() {
        return distanciaPlantas;
    }
    public void setDistanciaPlantas(Integer distanciaPlantas) {
        this.distanciaPlantas = distanciaPlantas;
    }
    public Integer getDistanciaFilas() {
        return distanciaFilas;
    }
    public void setDistanciaFilas(Integer distanciaFilas) {
        this.distanciaFilas = distanciaFilas;
    }
    public void setAnoPlantio(Integer anoPlantio) {
        this.anoPlantio = anoPlantio;
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
        QuadraDTO other = (QuadraDTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
