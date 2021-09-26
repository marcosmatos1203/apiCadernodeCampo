package com.cadernodecampo.springcadernodecampo.dominio;

public class ResponsavelTecnico {
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

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result +((id == null)? 0:id.hashCode());
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
