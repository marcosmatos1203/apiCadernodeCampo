package com.cadernodecampo.springcadernodecampo.RepositoryModule;

import com.cadernodecampo.springcadernodecampo.DominioModule.ResponsavelTecnico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsavelTecnicoRepository extends JpaRepository<ResponsavelTecnico,Integer>{
    
}
