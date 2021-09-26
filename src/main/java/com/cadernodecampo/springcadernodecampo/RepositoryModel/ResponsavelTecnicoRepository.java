package com.cadernodecampo.springcadernodecampo.RepositoryModel;

import com.cadernodecampo.springcadernodecampo.DominioModel.ResponsavelTecnico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsavelTecnicoRepository extends JpaRepository<ResponsavelTecnico,Integer>{
    
}
