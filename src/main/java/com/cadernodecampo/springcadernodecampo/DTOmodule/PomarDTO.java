package com.cadernodecampo.springcadernodecampo.DTOmodule;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.cadernodecampo.springcadernodecampo.DominioModule.Pomar;

import org.hibernate.validator.constraints.Length;

public class PomarDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "O nome não pode ser nulo")
    @Length(min = 3, max = 60,message = "O nome deve ter entre 3 e 60 caracteres")
    private String nome;
    
    @NotEmpty(message = "O logradouro não pode ser nulo")
    @Length(min = 3, max = 60,message = "O logradouro deve ter entre 3 e 60 caracteres")
    private String logradouro;

    @NotEmpty(message = "O bairro/localidade não pode ser nulo")
    @Length(min = 3, max = 60,message = "O bairro/localidade deve ter entre 3 e 60 caracteres")
    private String bairro_localidade;

    @NotEmpty(message = "O cidade não pode ser nulo")
    @Length(min = 3, max = 60,message = "O cidade deve ter entre 3 e 60 caracteres")
    private String cidade;

    @NotEmpty(message = "O estado não pode ser nulo")
    @Length(min = 3, max = 60,message = "O estado deve ter entre 3 e 60 caracteres")
    private String estado;

    @NotEmpty(message = "O cep não pode ser nulo")
    @Length(min = 8, max = 8,message = "O cep deve ter entre 8 caracteres")
    private String cep;

    @NotEmpty(message = "O produtor não pode ser nulo")
    private String nome_produtor;

   
    @NotEmpty(message = "O responsável técnico não pode ser nulo")
    private String nome_respTecnico;

    public PomarDTO(Pomar obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.logradouro = obj.getLogradouro();
        this.bairro_localidade = obj.getBairro_localidade();
        this.cidade = obj.getCidade();
        this.estado = obj.getEstado();
        this.cep = obj.getCep();
        this.nome_produtor = obj.getProdutor().getNome();
        this.nome_respTecnico = obj.getRespTecnico().getNome();
    }
   

    public String getNome_produtor() {
        return nome_produtor;
    }


    public void setNome_produtor(String nome_produtor) {
        this.nome_produtor = nome_produtor;
    }


    public String getNome_respTecnico() {
        return nome_respTecnico;
    }


    public void setNome_respTecnico(String nome_respTecnico) {
        this.nome_respTecnico = nome_respTecnico;
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
