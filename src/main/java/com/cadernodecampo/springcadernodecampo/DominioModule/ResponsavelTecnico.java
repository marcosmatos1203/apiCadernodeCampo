package com.cadernodecampo.springcadernodecampo.DominioModule;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
public class ResponsavelTecnico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Length(min = 3, max = 15,message = "O cep deve ter entre 8 caracteres")
    private String cep;

    @NotEmpty(message = "O email não pode ser nulo")
    @Length(min = 3, max = 60,message = "O email deve ter entre 3 e 60 caracteres")
    private String email;

    @NotEmpty(message = "O telefone não pode ser nulo")
    @Length(min = 3, max = 60,message = "O telefone deve ter entre 8 e 15 caracteres")
    private String telefone1;

    @NotEmpty(message = "O celular não pode ser nulo")
    @Length(min = 3, max = 15,message = "O celular deve ter entre 8 e 15 caracteres")
    private String telefone2;


    @NotEmpty(message = "O crea não pode ser nulo")
    @Length(min = 3, max = 25,message = "O crea deve ter entre 8 e 25 caracteres")
    private String crea;
   
    
    public ResponsavelTecnico(Integer id, String nome, String logradouro, String bairro_localidade, String cidade,
            String estado, String cep, String email, String telefone1, String telefone2, String crea) {
        this.setId(id);
        this.setNome(nome);
        this.setLogradouro(logradouro);
        this.setBairro_localidade(bairro_localidade);
        this.setCidade(cidade);
        this.setEstado(estado);
        this.setCep(cep);
        this.setEmail(email);
        this.setTelefone1(telefone1);
        this.setTelefone2(telefone2);
        this.setCrea(crea);
    }

    public String getCrea() {
        return crea;
    }

    public void setCrea(String crea) {
        this.crea = crea;
    }

    
    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro_localidade() {
        return bairro_localidade;
    }

    public void setBairro_localidade(String bairro_localidade) {
        this.bairro_localidade = bairro_localidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ResponsavelTecnico() {
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
        ResponsavelTecnico other = (ResponsavelTecnico) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
