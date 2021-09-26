package com.cadernodecampo.springcadernodecampo.dominio;

import java.util.ArrayList;

public class Produtor {
    private Integer id;
    private String nome;
    private String logradouro;
    private String bairro_localidade;
    private String cidade;
    private String estado;
    private String cep;
    private String email;
    private String telefone1;
    private String telefone2;

    private ArrayList<Pomar> pomares = new ArrayList<>();

    public Produtor() {
        super();
    }

    public ArrayList<Pomar> getPomares() {
        return pomares;
    }

    public void setPomares(ArrayList<Pomar> pomares) {
        this.pomares = pomares;
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

    public Produtor(String nome, String logradouro, String bairro_localidade, String cidade, String estado, String cep,
            String email, String telefone1, String telefone2) {
        super();
        this.setNome(nome);
        this.setLogradouro(logradouro);
        this.setBairro_localidade(bairro_localidade);
        this.setCidade(cidade);
        this.setEstado(estado);
        this.setCep(cep);
        this.setEmail(email);
        this.setTelefone1(telefone1);
        this.setTelefone2(telefone2);
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
        Produtor other = (Produtor) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
