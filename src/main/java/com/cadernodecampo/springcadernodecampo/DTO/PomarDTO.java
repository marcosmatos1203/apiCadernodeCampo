package com.cadernodecampo.springcadernodecampo.DTO;

import java.io.Serializable;

import com.cadernodecampo.springcadernodecampo.DominioModel.Pomar;

public class PomarDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String logradouro;
    private String bairro_localidade;
    private String cidade;
    private String estado;
    private String cep;
    private Integer id_produtor;
    private Integer id_resp_tecnico;

    public PomarDTO(Pomar obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.logradouro = obj.getLogradouro();
        this.bairro_localidade = obj.getBairro_localidade();
        this.cidade = obj.getCidade();
        this.estado = obj.getEstado();
        this.cep = obj.getCep();
        this.id_produtor = obj.getProdutor().getId();
        this.id_resp_tecnico = obj.getRespTecnico().getId();
    }
   
    
    public Integer getId_resp_tecnico() {
        return id_resp_tecnico;
    }


    public void setId_resp_tecnico(Integer id_resp_tecnico) {
        this.id_resp_tecnico = id_resp_tecnico;
    }


    public Integer getId_produtor() {
        return id_produtor;
    }
    public void setId_produtor(Integer id_produtor) {
        this.id_produtor = id_produtor;
    }
    public PomarDTO() {
        super();
    }
    public String getCep() {
        return cep;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public String getBairro_localidade() {
        return bairro_localidade;
    }
    public void setBairro_localidade(String bairro_localidade) {
        this.bairro_localidade = bairro_localidade;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setCep(String cep) {
        this.cep = cep;
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
        PomarDTO other = (PomarDTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
