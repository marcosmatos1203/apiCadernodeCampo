package com.cadernodecampo.springcadernodecampo.DominioModule;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
public class Pomar implements Serializable {

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

    //private Integer produtorId;

  //  private Integer respTecnicoId;

    @ManyToOne()
    @JoinColumn(name = "idProdutor")
    private Produtor produtor;

    @ManyToOne()
    @JoinColumn(name = "idRespTecnico")
    private ResponsavelTecnico respTecnico;


    public Pomar(Integer id, String nome, String logradouro, String bairro_localidade, String cidade, String estado,
            String cep, Produtor produtor, ResponsavelTecnico respTecnico) {
        this.setId(id);
        this.setNome(nome);
        this.setLogradouro(logradouro);
        this.setBairro_localidade(bairro_localidade);
        this.setCidade(cidade);
        this.setEstado(estado);
        this.setCep(cep);
        this.setProdutor(produtor);
        this.setRespTecnico(respTecnico);
     //   this.respTecnicoId=respTecnico.getId();
        //this.produtorId=produtor.getId();
    }

    public ResponsavelTecnico getRespTecnico() {
        return respTecnico;
    }

    public void setRespTecnico(ResponsavelTecnico respTecnico) {
        this.respTecnico = respTecnico;
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
        Pomar other = (Pomar) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

  /*  public Integer getProdutorId () {
        return produtorId;
    }

    public void setProdutorId(Integer produtorId) {
        this.produtorId = produtorId;
    }

    public Integer getRespTecnicoId () {
        return respTecnicoId;
    }

    public void setRespTecnicoId(Integer respTecnicoId) {
        this.respTecnicoId = respTecnicoId;
    }
*/
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

    public Pomar() {
        super();
    }

    public Produtor getProdutor() {
        return produtor;
    }

    public void setProdutor(Produtor produtor) {
        this.produtor = produtor;
    }

}
